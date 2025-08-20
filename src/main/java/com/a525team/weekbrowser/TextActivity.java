package com.a525team.weekbrowser;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.*;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.Typeface;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import android.text.style.BackgroundColorSpan;

public class TextActivity extends Activity {
	
	private int currentMatchIndex = -1;
	private ArrayList<int[]> matchPositions = new ArrayList<>();
	private final ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
	private boolean isFile = false;
	private String filePath = "";
	private static final int CURRENT_HIGHLIGHT_COLOR = Color.GREEN;
	private static final int DEFAULT_HIGHLIGHT_COLOR = Color.YELLOW;
	private ScaleGestureDetector scaleDetector;
	private float currentScale = 1f;
	private float baseTextSize;
	
	private TextView name;
	private ScrollView vscroll1;
	private LinearLayout serepl;
	private HorizontalScrollView hscroll1;
	private EditText editText;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private LinearLayout linear6;
	private EditText findText;
	private LinearLayout linear7;
	private EditText replaceText;
	private CheckBox ignore;
	private CheckBox regex;
	private TextView sup;
	private TextView srhnum;
	private TextView sdown;
	private TextView find;
	private TextView replace;
	private TextView all;
	private LinearLayout instrl;
	private TextView serrep;
	private TextView save;
	
	private SharedPreferences sf;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		ThemeManager.applyTheme(this);
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.text);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		name = findViewById(R.id.name);
		vscroll1 = findViewById(R.id.vscroll1);
		serepl = findViewById(R.id.serepl);
		hscroll1 = findViewById(R.id.hscroll1);
		editText = findViewById(R.id.editText);
		linear4 = findViewById(R.id.linear4);
		linear5 = findViewById(R.id.linear5);
		linear6 = findViewById(R.id.linear6);
		findText = findViewById(R.id.findText);
		linear7 = findViewById(R.id.linear7);
		replaceText = findViewById(R.id.replaceText);
		ignore = findViewById(R.id.ignore);
		regex = findViewById(R.id.regex);
		sup = findViewById(R.id.sup);
		srhnum = findViewById(R.id.srhnum);
		sdown = findViewById(R.id.sdown);
		find = findViewById(R.id.find);
		replace = findViewById(R.id.replace);
		all = findViewById(R.id.all);
		instrl = findViewById(R.id.instrl);
		serrep = findViewById(R.id.serrep);
		save = findViewById(R.id.save);
		sf = getSharedPreferences("sf", Activity.MODE_PRIVATE);
		
		ignore.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.ignorecase));
				return true;
			}
		});
		
		regex.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.regex));
				return true;
			}
		});
		
		sup.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				moveToPreviousMatch();
			}
		});
		
		sdown.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				moveToNextMatch();
			}
		});
		
		find.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				highlightAllMatches();
			}
		});
		
		replace.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				replaceCurrentMatch();
			}
		});
		
		all.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				replaceAllMatches();
			}
		});
		
		serrep.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (serepl.getVisibility() == View.VISIBLE) {
					serepl.setVisibility(View.GONE);
				} else {
					serepl.setVisibility(View.VISIBLE);
				}
			}
		});
		
		save.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (isFile) {
					    Uri fileUri = getIntent().getData();
					    if (fileUri != null) {
						        if ("file".equals(fileUri.getScheme())) {
							            // Прямий запис у файл
							            File file = new File(fileUri.getPath());
							            try {
								                FileOutputStream fos = new FileOutputStream(file);
								                fos.write(editText.getText().toString().getBytes("utf-8"));
								                fos.flush();
								                fos.close();
								                SketchwareUtil.showMessage(getApplicationContext(), "Saved file (file://)");
								            } catch (Exception e) {
								                SketchwareUtil.showMessage(getApplicationContext(), "Помилка збереження: " + e.getMessage());
								            }
							        } else {
							            // Спроба запису через ContentResolver
							            try {
								                OutputStream outputStream = getContentResolver().openOutputStream(fileUri);
								                if (outputStream != null) {
									                    outputStream.write(editText.getText().toString().getBytes("utf-8"));
									                    outputStream.flush();
									                    outputStream.close();
									                    SketchwareUtil.showMessage(getApplicationContext(), "Saved file (content://)");
									                } else {
									                    SketchwareUtil.showMessage(getApplicationContext(), "Cannot open stream for writing");
									                }
								            } catch (Exception e) {
								                SketchwareUtil.showMessage(getApplicationContext(), "Помилка збереження (content://): " + e.getMessage());
								            }
							        }
						    }
				} else {
					    try {
						        HashMap<String, Object> temp2 = new Gson().fromJson(
						            dataHolder.getData("info"), 
						            new TypeToken<HashMap<String, Object>>(){}.getType()
						        );
						        String temp = temp2.get(getIntent().getStringExtra("dh")).toString();
						        dataHolder.setData(temp, editText.getText().toString());
						        SketchwareUtil.showMessage(getApplicationContext(), "Saved dataHolder");
						    } catch (Exception e) {
						        SketchwareUtil.showMessage(getApplicationContext(), "Помилка збереження в dataHolder: " + e.getMessage());
						    }
				}
				
			}
		});
	}
	
	private void initializeLogic() {
		serepl.setVisibility(View.GONE);
		SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
		
		editText.setTypeface(Typeface.MONOSPACE);
		findText.setTypeface(Typeface.MONOSPACE);
		replaceText.setTypeface(Typeface.MONOSPACE);
		
		editText.setVerticalScrollBarEnabled(false);
		editText.setHorizontalScrollBarEnabled(false);
		editText.setOverScrollMode(View.OVER_SCROLL_NEVER);
		
		baseTextSize = editText.getTextSize() / getResources().getDisplayMetrics().scaledDensity;
		
		scaleDetector = new ScaleGestureDetector(this, new ScaleListener());
		
		//editText.setScroller(null);
		//editText.setMovementMethod(new ScrollingMovementMethod());
		
		// Ініціалізація Skin
		Skin skin = new Skin();
		skin.colorToRam(TextActivity.this);
		//Не питайте мене, нафіга. Так має бути, і воно тільки так працює.
		//Ок, поясню — colorToRam записує кольори в DataHolder, 
		//але щоб викликати colorToRam — треба ініціалізувати Skin
		//Але після colorToRam треба оновити змінні Skin,
		//і для цього треба заново ініціалізувати Skin.
		//Попахує говнокодом, чи не так?
		skin = new Skin();
		// Установлення фону та кольорів тексту
		skin.setBG(getWindow().getDecorView(), 2, false);
		
		ignore.setTextColor((int) Long.parseLong(dataHolder.getData("tf"), 16));
		regex.setTextColor((int) Long.parseLong(dataHolder.getData("tf"), 16));
		
		editText.setTextColor((int) Long.parseLong(dataHolder.getData("tf"), 16));
		editText.setHintTextColor((int) Long.parseLong(dataHolder.getData("h"), 16));
		
		findText.setTextColor((int) Long.parseLong(dataHolder.getData("tf"), 16));
		findText.setHintTextColor((int) Long.parseLong(dataHolder.getData("h"), 16));
		
		replaceText.setTextColor((int) Long.parseLong(dataHolder.getData("tf"), 16));
		replaceText.setHintTextColor((int) Long.parseLong(dataHolder.getData("h"), 16));
		
		srhnum.setTextColor((int) Long.parseLong(dataHolder.getData("add"), 16));
		name.setTextColor((int) Long.parseLong(dataHolder.getData("add"), 16));
		
		// Заміна фону з використанням skin.setBG
		sup.setTextColor((int) Long.parseLong(dataHolder.getData("bt"), 16));
		skin.setBG(sup, 0, false);
		
		sdown.setTextColor((int) Long.parseLong(dataHolder.getData("bt"), 16));
		skin.setBG(sdown, 0, false);
		
		save.setTextColor((int) Long.parseLong(dataHolder.getData("bt"), 16));
		skin.setBG(save, 0, false);
		
		find.setTextColor((int) Long.parseLong(dataHolder.getData("bt"), 16));
		skin.setBG(find, 0, false);
		
		replace.setTextColor((int) Long.parseLong(dataHolder.getData("bt"), 16));
		skin.setBG(replace, 0, false);
		
		all.setTextColor((int) Long.parseLong(dataHolder.getData("bt"), 16));
		skin.setBG(all, 0, false);
		
		serrep.setTextColor((int) Long.parseLong(dataHolder.getData("bt"), 16));
		skin.setBG(serrep, 0, false);
		
		colorify.applyColorifyToAll(getWindow().getDecorView().getRootView());
		
		editText.setOnTouchListener((v, event) -> {
			scaleDetector.onTouchEvent(event);
			return false; // дає змогу все одно редагувати текст
		});
		sup.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		sdown.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		name.setText("Initalizing...");
		if (ThemeManager.getA1()) {
			editText.setBackgroundColor(0xFFFFFFFF);
		}
		((EditText)findText).setMaxLines((int)3);
		((EditText)replaceText).setMaxLines((int)3);
	}
	
	
	@Override
	public void onResume() {
		super.onResume();
		SafeMarginUtils.init(this, findViewById(android.R.id.content));
	}
	
	@Override
	public void onPause() {
		super.onPause();
		SafeMarginUtils.cleanup();
	}
	
	@Override
	protected void onPostCreate(Bundle _savedInstanceState) {
		super.onPostCreate(_savedInstanceState);
		final int slptm = 100;
		
		new Thread(() -> {
			try {
				    Thread.sleep(slptm);
			} catch (InterruptedException e) {
				    // Можна нічого не робити
			}
			runOnUiThread(() -> {
				name.setText("Reading info...");
			});
			
			try {
				    Thread.sleep(slptm);
			} catch (InterruptedException e) {
				    // Можна нічого не робити
			}
			
			ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
			String temp;
			if (getIntent().hasExtra("dh")) {
				HashMap<String, Object> temp2 = new Gson().fromJson(dataHolder.getData("info"), new TypeToken<HashMap<String, Object>>(){}.getType());
				
				temp = temp2.get(getIntent().getStringExtra("dh")).toString();
			} else {
				isFile = true;
				temp = FileUtil.readFile(getIntent().getData().toString());
			}
			runOnUiThread(() -> {
				name.setText("Printing text...");
			});
			
			try {
				    Thread.sleep(slptm);
			} catch (InterruptedException e) {
				    // Можна нічого не робити
			}
			
			runOnUiThread(() -> {
				_read();
				name.setText(/*"[" + Formater.kmgt((int) editText.getText().toString().length()) + "]" +*/ isFile?"File:":"Data Holder: \"" + ((getIntent().getStringExtra("dh") != null && !getIntent().getStringExtra("dh").equals("")) ? getIntent().getStringExtra("dh") : filePath) + "\"");
				
			});
		}).start();
	}
	public void _lang() {
	}
	
	@Override
	protected void attachBaseContext(Context newBase) {
		    if (newBase != null) {
			        SharedPreferences sf = newBase.getSharedPreferences("sf", Context.MODE_PRIVATE);
			        String languageCode = sf.getString("lang", "en");
			        Context context = LocaleHelper.setLocale(newBase, languageCode);
			        super.attachBaseContext(context);
			    } else {
			        super.attachBaseContext(newBase);
			    }
	}
	
	
	{
	}
	
	
	public void _extra() {
	}
	
	private void highlightAllMatches() {
		    matchPositions.clear();
		    currentMatchIndex = -1;
		
		    String text = editText.getText().toString();
		    String search = findText.getText().toString();
		    if (search.isEmpty()) {
			        editText.setText(text);
			        return;
			    }
		
		    Spannable spannable = new SpannableString(text);
		
		    try {
			        int flags = 0;
			        if (ignore.isChecked()) flags |= Pattern.CASE_INSENSITIVE;
			
			        Pattern pattern = regex.isChecked()
			                ? Pattern.compile(search, flags)
			                : Pattern.compile(Pattern.quote(search), flags);
			
			        Matcher matcher = pattern.matcher(text);
			
			        while (matcher.find()) {
				            int start = matcher.start();
				            int end = matcher.end();
				            matchPositions.add(new int[]{start, end});
				        }
			
			        // Встановлюємо стилі для всіх збігів: чорний текст + дефолтне тло
			        for (int[] pos : matchPositions) {
				            spannable.setSpan(new BackgroundColorSpan(DEFAULT_HIGHLIGHT_COLOR),
				                    pos[0], pos[1], Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
				            spannable.setSpan(new ForegroundColorSpan(Color.BLACK),
				                    pos[0], pos[1], Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
				        }
			
			        // Поточний збіг отримує інший колір фону (але чорний вже заданий вище)
			        if (!matchPositions.isEmpty()) {
				            currentMatchIndex = 0;
				            int[] pos = matchPositions.get(currentMatchIndex);
				            spannable.setSpan(new BackgroundColorSpan(CURRENT_HIGHLIGHT_COLOR),
				                    pos[0], pos[1], Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
				        } else {
				Toast.makeText(this, getString(R.string.nofound), Toast.LENGTH_SHORT).show();
				        }
			
			        editText.getText().replace(0, editText.length(), spannable); // ← зберігає undo
			
			        if (!matchPositions.isEmpty()) {
				            int[] pos = matchPositions.get(currentMatchIndex);
				            editText.setSelection(pos[0], pos[1]);
				        }
			
			        updcnt();
			    } catch (Exception e) {
			Toast.makeText(this, getString(R.string.regexerror), Toast.LENGTH_SHORT).show();
			    }
	}
	
	
	private void highlightCurrentMatch(Spannable spannable) {
		    if (currentMatchIndex < 0 || currentMatchIndex >= matchPositions.size()) return;
		
		    int[] pos = matchPositions.get(currentMatchIndex);
		    spannable.setSpan(
		        new BackgroundColorSpan(CURRENT_HIGHLIGHT_COLOR),
		        pos[0], pos[1],
		        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
		    );
		    spannable.setSpan(
		        new ForegroundColorSpan(Color.BLACK),
		        pos[0], pos[1],
		        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
		    );
	}
	
	private void moveToNextMatch() {
		    if (matchPositions.isEmpty()) return;
		
		    int prevIndex = currentMatchIndex;
		    currentMatchIndex = (currentMatchIndex + 1) % matchPositions.size();
		    updateHighlight(prevIndex, currentMatchIndex);
		    scrollToCurrentMatch();
		    updcnt();
	}
	
	private void moveToPreviousMatch() {
		    if (matchPositions.isEmpty()) return;
		
		    int prevIndex = currentMatchIndex;
		    currentMatchIndex = (currentMatchIndex - 1 + matchPositions.size()) % matchPositions.size();
		    updateHighlight(prevIndex, currentMatchIndex);
		    scrollToCurrentMatch();
		    updcnt();
	}
	
	private void updateHighlight(int oldIndex, int newIndex) {
		    Editable text = editText.getText();
		
		    // Зняти попереднє виділення (залишити чорний, змінити лише фон)
		    if (oldIndex >= 0 && oldIndex < matchPositions.size()) {
			        int[] oldPos = matchPositions.get(oldIndex);
			        // Видаляємо попередні BackgroundColorSpan
			        BackgroundColorSpan[] oldBgSpans = text.getSpans(oldPos[0], oldPos[1], BackgroundColorSpan.class);
			        for (BackgroundColorSpan span : oldBgSpans) {
				            text.removeSpan(span);
				        }
			        // Ставимо дефолтний колір
			        text.setSpan(new BackgroundColorSpan(DEFAULT_HIGHLIGHT_COLOR),
			                oldPos[0], oldPos[1], Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
			    }
		
		    // Додати нове виділення (інший фон)
		    if (newIndex >= 0 && newIndex < matchPositions.size()) {
			        int[] newPos = matchPositions.get(newIndex);
			        // Видаляємо попередні BackgroundColorSpan
			        BackgroundColorSpan[] newBgSpans = text.getSpans(newPos[0], newPos[1], BackgroundColorSpan.class);
			        for (BackgroundColorSpan span : newBgSpans) {
				            text.removeSpan(span);
				        }
			        // Ставимо активний колір
			        text.setSpan(new BackgroundColorSpan(CURRENT_HIGHLIGHT_COLOR),
			                newPos[0], newPos[1], Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
			        // Прокрутка + виділення
			        editText.setSelection(newPos[0], newPos[1]);
			    }
		
		    // Не викликаємо setText(), це надто дорого
		    editText.invalidate();
	}
	
	private void scrollToCurrentMatch() {
		    if (currentMatchIndex < 0 || currentMatchIndex >= matchPositions.size()) return;
		
		    int[] pos = matchPositions.get(currentMatchIndex);
		    editText.requestFocus();
		    editText.setSelection(pos[0], pos[1]);
		    editText.bringPointIntoView(pos[1]);
	}
	
	private void replaceCurrentMatch() {
		    if (matchPositions.isEmpty() || currentMatchIndex < 0) return;
		
		    Editable text = editText.getText();
		    int[] pos = matchPositions.get(currentMatchIndex);
		    String replacement = replaceText.getText().toString();
		
		    int oldPosition = pos[0];
		    text.replace(pos[0], pos[1], replacement);
		
		    int lengthDiff = replacement.length() - (pos[1] - pos[0]);
		    updatePositionsAfterReplace(currentMatchIndex, oldPosition, lengthDiff);
		
		    highlightAllMatches();
	}
	
	private void updatePositionsAfterReplace(int replacedIndex, int replacePosition, int lengthDiff) {
		    for (int i = replacedIndex + 1; i < matchPositions.size(); i++) {
			        int[] p = matchPositions.get(i);
			        p[0] += lengthDiff;
			        p[1] += lengthDiff;
			    }
	}
	
	private void replaceAllMatches() {
		    String search = findText.getText().toString();
		    String replacement = replaceText.getText().toString();
		    String text = editText.getText().toString();
		
		    if (search.isEmpty()) return;
		
		    try {
			        int flags = 0;
			        if (ignore.isChecked()) {
				            flags |= Pattern.CASE_INSENSITIVE;
				        }
			
			        Pattern pattern = regex.isChecked()
			                ? Pattern.compile(search, flags)
			                : Pattern.compile(Pattern.quote(search), flags);
			
			        Matcher matcher = pattern.matcher(text);
			        String result = matcher.replaceAll(replacement);
			        editText.getText().replace(0, editText.length(), result); // ← зберігає undo
			        matchPositions.clear();
			        currentMatchIndex = -1;
			        Toast.makeText(this, getString(R.string.replacedall), Toast.LENGTH_SHORT).show();
			
			    } catch (Exception e) {
			        Toast.makeText(this, getString(R.string.regexerror), Toast.LENGTH_SHORT).show();
			    }
		    updcnt();
	}
	
	private void updcnt() {
		    String out = matchPositions.isEmpty()
		            ? "0/0"
		            : (currentMatchIndex + 1) + "/" + matchPositions.size();
		    srhnum.setText(out);
	}
	
	
	private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
		        @Override
		        public boolean onScale(ScaleGestureDetector detector) {
			            currentScale *= detector.getScaleFactor();
			
						float newSize = baseTextSize * currentScale;
			            newSize = newSize<=5?5:newSize>=40?40:newSize;
			            editText.setTextSize(TypedValue.COMPLEX_UNIT_SP, newSize);
			
			            return true;
			        }
		    }
	
	{
	}
	
	
	public void _read() {
		Uri uri = getIntent().getData();
		StringBuilder text = new StringBuilder();
		
		try {
			    InputStream inputStream;
			
			    if ("file".equals(uri.getScheme())) {
				        filePath = uri.getPath(); // напряму
				        inputStream = new FileInputStream(new File(filePath));
				    } else {
				        // content://
				        filePath = uri.toString(); // повний content://
				        inputStream = getContentResolver().openInputStream(uri);
				    }
			
			    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			    String line;
			    while ((line = reader.readLine()) != null) {
				        text.append(line).append("\n");
				    }
			    reader.close();
			    inputStream.close();
			
		} catch (IOException e) {
			    text.append("Read error: ").append(e.getMessage());
		}
		
		// Встановити текст та показати шлях
		editText.setText(text.toString());
	}
	
}
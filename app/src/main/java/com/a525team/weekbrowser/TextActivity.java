package com.a525team.weekbrowser;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.*;
import android.content.DialogInterface;
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
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.a525team.weekbrowser.SkinCheckBox;
import com.a525team.weekbrowser.SkinEditText;
import com.a525team.weekbrowser.SkinTextView;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;
import android.text.style.BackgroundColorSpan;
import android.Manifest;
import android.content.pm.PackageManager;
import android.text.SpannableStringBuilder;
import android.text.Editable;

public class TextActivity extends Activity {
	
	private Timer _timer = new Timer();
	
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
	private boolean isCut = false;
	private boolean changed = false;
	
	private LinearLayout bg;
	private SkinTextView name;
	private ScrollView vscroll1;
	private LinearLayout serepl;
	private HorizontalScrollView hscroll1;
	private SkinEditText editText;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private LinearLayout linear6;
	private SkinEditText findText;
	private LinearLayout linear7;
	private SkinEditText replaceText;
	private SkinCheckBox ignore;
	private SkinCheckBox regex;
	private SkinTextView sup;
	private SkinTextView srhnum;
	private SkinTextView sdown;
	private SkinTextView find;
	private SkinTextView replace;
	private SkinTextView all;
	private LinearLayout instrl;
	private SkinTextView newf;
	private SkinTextView open;
	private SkinTextView serrep;
	private SkinTextView save;
	private SkinTextView settings;
	
	private SharedPreferences sf;
	private TimerTask t;
	private AlertDialog.Builder saveq;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		ThemeManager.applyTheme(this);
		setContentView(R.layout.text);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		bg = findViewById(R.id.bg);
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
		newf = findViewById(R.id.newf);
		open = findViewById(R.id.open);
		serrep = findViewById(R.id.serrep);
		save = findViewById(R.id.save);
		settings = findViewById(R.id.settings);
		sf = getSharedPreferences("sf", Activity.MODE_PRIVATE);
		saveq = new AlertDialog.Builder(this);
		
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
		
		newf.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_handleActionWithCheck(() -> {
					newFile(); // Скидаємо інтерфейс
					changed = false;
				});
			}
		});
		
		open.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_handleActionWithCheck(() -> {
					// Це виконається, якщо зберегли або натиснули "Не зберігати"
					BasedDialog.showFileManager(
					TextActivity.this, 
					getString(R.string.open),
					"",
					false,
					file -> {
						if (file != null) openFile(file);
					}
					);
				});
				
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
				_justSave(success -> {}); 
				
			}
		});
	}
	
	private void initializeLogic() {
		name.setText("Initalizing...");
		serepl.setVisibility(View.GONE);
		settings.setVisibility(View.GONE);
		_buttonsizeset();
		//editText.setGravity(Gravity.TOP | Gravity.START);
		//editText.setMinimumHeight(1000);
		
		StringBuilder hhhh = new StringBuilder();
		
		for(int i=0;i<150;i++)hhhh.append("\n");
		String hhhi = hhhh.toString();
		editText.setHint(hhhi);
		SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
		
		editText.setTypeface(Typeface.MONOSPACE);
		findText.setTypeface(Typeface.MONOSPACE);
		replaceText.setTypeface(Typeface.MONOSPACE);
		
		//Відключаємо зайві ефекти (прокрутка та підсвітка краю),
		//щоб хоч трохи ресурсів зекономити. Те, що 1-2 МБ текст
		//не на кожному сучасному телефоні нормально
		//відкриється — це той ще крінж, але я тут ні до чого.
		//Може колись придумаю, як ще викрутитися
		editText.setVerticalScrollBarEnabled(false);
		editText.setHorizontalScrollBarEnabled(false);
		editText.setOverScrollMode(View.OVER_SCROLL_NEVER);
		
		//примусово грохнув парсинг посилань і відключив автодоповнення
		editText.setLinksClickable(false);
		
		// Додатково вимикаємо перевірку правопису на рівні системи
		if (WTF.SDK_INT() >= 26) {
			editText.setImportantForAutofill(View.IMPORTANT_FOR_AUTOFILL_NO);
		}
		
		if (ThemeManager.getA1()) {
			editText.setBackgroundColor(0xFFFFFFFF); 
		}else{
			editText.setBackground(null); //щоб трохи зменшити навантаження
		}
		
		baseTextSize = editText.getTextSize() / getResources().getDisplayMetrics().scaledDensity;
		
		scaleDetector = new ScaleGestureDetector(this, new ScaleListener());
		
		//editText.setScroller(null);
		//editText.setMovementMethod(new ScrollingMovementMethod());
		
		// Встановлюємо нашу фабрику ОБОВ'ЯЗКОВО до того, як буде задано setText()
		editText.setEditableFactory(new EfficientEditableFactory());
		
		this.textWatcher = new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				// збережіть код, який у вас тут був, якщо був
			}
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// збережіть код, який у вас тут був, якщо був
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				if (!changed) {
					changed = true;
				}
				_updtitle();
			}
		};
		
		editText.setOnTouchListener((v, event) -> {
			scaleDetector.onTouchEvent(event);
			return false; // дає змогу все одно редагувати текст
		});
		name.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		sup.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		sdown.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		serrep.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		open.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		newf.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		save.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		settings.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		((EditText)findText).setMaxLines((int)3);
		((EditText)replaceText).setMaxLines((int)3);
	}
	
	
	@Override
	public void onResume() {
		super.onResume();
		SafeMarginUtils.init(this, bg);
		_timer = new Timer();
		
		{
			Skin s = Skin.getInstance();
			s.colorToRam(this);
			s.setStaticBG(this, 2, false);
		}
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						_updtitle();
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(t, (int)(99), (int)(100));
	}
	
	@Override
	public void onPause() {
		super.onPause();
		SafeMarginUtils.cleanup();
		if (_timer != null) {
			_timer.cancel();
			_timer = null;
		}
	}
	
	@Override
	protected void onPostCreate(Bundle _savedInstanceState) {
		super.onPostCreate(_savedInstanceState);
		_printText();
	}
	
	@Override
	public void onBackPressed() {
		_handleActionWithCheck(() -> {
			finish(); // Закриваємо активність
		});
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
	
	private TextWatcher textWatcher;
	
	public void _read() {
		editText.removeTextChangedListener(textWatcher);
		if (getIntent().getData() != null) {
			// Сценарій 1: Відкрили файл
			_loadFileFromUri(getIntent().getData());
			
		} else if (getIntent().hasExtra("dh")) {
			// Сценарій 2: Відкрили DataHolder
			try {
				ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
				HashMap<String, Object> temp2 = JsonUtils.M(dataHolder.getData("info"));
				String temp = temp2.get(getIntent().getStringExtra("dh")).toString();
				
				isCut = false;
				if (WTF.SDK_INT() >= 28) {
					PrecomputedText.Params params = editText.getTextMetricsParams();
					PrecomputedText precomputedText = PrecomputedText.create(temp, params);
					editText.setText(precomputedText);
				} else {
					editText.setText(temp);
				}
				isFile = false;
				filePath = getIntent().getStringExtra("dh");
				_updtitle();
			} catch (Exception e) {
				editText.setText("Error loading DataHolder: " + e.getMessage());
			}
			
		} else {
			// Сценарій 3: Відкрили порожній редактор (через ярлик)
			newFile(); // Цей метод очистить поле і гарантовано поставить changed = false
		}
		// Знімаємо прапорець в будь-якому випадку
		// і додаємо смотрящого за текстом✵
		changed = false;
		editText.addTextChangedListener(textWatcher);
	}
	
	public void _printText() {
		final int slptm = 150;
		
		new Thread(() -> {
			try { Thread.sleep(slptm); } catch (InterruptedException e) {}
			runOnUiThread(() -> name.setText("Reading info..."));
			
			try { Thread.sleep(slptm); } catch (InterruptedException e) {}
			runOnUiThread(() -> name.setText("Printing text..."));
			
			try { Thread.sleep(slptm); } catch (InterruptedException e) {}
			
			// Вся логіка визначення типу (файл/dh/новий) тепер надійно лежить у _read()
			runOnUiThread(() -> _read());
		}).start();
	}
	
	private void _loadFileFromUri(Uri uri) {
		if (uri == null) return;
		int maxTextLength = (WTF.SDK_INT() >= 28) ?
		2097152 : 524288; // 2 МіБ : 512 КіБ
		// Використовуємо StringBuilder з початковою місткістю (якщо файл великий)
		StringBuilder text = new StringBuilder();
		try {
			InputStream inputStream = "file".equals(uri.getScheme()) ? 
			new FileInputStream(new File(uri.getPath())) : 
			getContentResolver().openInputStream(uri);
			
			if (inputStream != null) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
				char[] buffer = new char[65536]; // Буфер на 64 КБ
				int read;
				while ((read = reader.read(buffer)) != -1) {
					text.append(buffer, 0, read);
					// Захист від критичного перевантаження (наприклад, 5 МБ)
					if (text.length() > maxTextLength) break; 
				}
				reader.close();
				inputStream.close();
			}
			
			// Встановлюємо текст
			if (text.length() > maxTextLength) {
				isCut = true;
				editText.setText(text.substring(0, maxTextLength));
			} else {
				isCut = false;
				editText.setText(text.toString());
			}
			
			isFile = true;
			changed = false;
			filePath = ("file".equals(uri.getScheme())) ? uri.getPath() : uri.toString();
			
		} catch (Exception e) {
			editText.setText("Read error: " + e.getMessage());
		}
		_updtitle();
	}
	
	private void _handleActionWithCheck(final Runnable action) {
		// 1. Якщо змін не було — просто виконуємо дію (відкрити/новий/вийти)
		if (!changed) {
			action.run();
			return;
		}
		
		// 2. Якщо зміни є — показуємо діалог
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(getString(R.string.saveh) + "?");
		builder.setMessage(getString(R.string.not_saved));
		
		// Зберегти
		builder.setPositiveButton(getString(R.string.saveh), (dialog, which) -> {
			_justSave(success -> {
				if (success) {
					changed = false; // Скидаємо прапор змін після успішного збереження
					action.run();    // Виконуємо заплановану дію
				}
				// Якщо success == false (скасували вибір файлу), нічого не робимо (залишаємося в редакторі)
			});
		});
		
		// Не зберігати
		builder.setNegativeButton(getString(R.string.dont_save), (dialog, which) -> {
			changed = false; // Користувач свідомо відмовився від збереження
			action.run();    // Просто виконуємо дію
		});
		
		// Скасувати (Нічого не робити)
		builder.setNeutralButton(getString(R.string.cancel), null);
		AlertDialog dddddd = builder.create();
		RenderUtils.setupDialogDim(this, dddddd);
		builder.show();
	}
	
	private void openFileSelectorToSave(SaveResultListener listener) {
		BasedDialog.showFileManager(
		this, 
		getString(R.string.saveh),
		"",
		true,
		file -> {
			if (file != null) {
				saveContentToFile(file);
				listener.onResult(true);
			} else {
				listener.onResult(false);
			}
			// Видалив return true, якщо метод має бути void
		}
		);
	}
	
	// Створимо простий інтерфейс для результату
	public interface SaveResultListener {
		void onResult(boolean success);
	}
	
	public void _justSave(SaveResultListener listener) {
		// Якщо у нас є шлях (з Intent або діалогу)
		if (isFile && filePath != null && !filePath.isEmpty()) {
			Uri uri = Uri.parse(filePath);
			boolean ok;
			
			if ("file".equals(uri.getScheme()) || filePath.startsWith("/")) {
				// Якщо це звичайний шлях до файлу
				File file = filePath.startsWith("/") ? new File(filePath) : new File(uri.getPath());
				ok = saveToFileScheme(Uri.fromFile(file));
			} else {
				// Якщо це content://
				ok = saveToContentScheme(uri);
			}
			
			if (ok) changed = false;
			listener.onResult(ok);
		} else if (getIntent().hasExtra("dh")) {
			// Якщо це DataHolder
			boolean ok = saveToDataHolder();
			if (ok) changed = false;
			listener.onResult(ok);
		} else {
			// Якщо шляху немає взагалі — викликаємо діалог вибору місця збереження
			openFileSelectorToSave(listener);
		}
	}
	
	private void openFile(File file) {
		if (file != null) {
			_loadFileFromUri(Uri.fromFile(file));
		}
	}
	
	private void newFile(){
		filePath = "";
		isFile = true;
		isCut = false;
		editText.setText("");
		changed = false;
	}
	
	private boolean saveToFileScheme(Uri uri) {
		try {
			File file = new File(uri.getPath());
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(editText.getText().toString().getBytes("utf-8"));
			fos.flush();
			fos.close();
			SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.file_saved) + " (file://)");
			return true;
		} catch (Exception e) {
			SketchwareUtil.showMessage(getApplicationContext(), "Помилка: " + e.getMessage());
			return false;
		}
	}
	
	private boolean saveToContentScheme(Uri uri) {
		try {
			OutputStream outputStream = getContentResolver().openOutputStream(uri);
			if (outputStream != null) {
				outputStream.write(editText.getText().toString().getBytes("utf-8"));
				outputStream.flush();
				outputStream.close();
				SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.file_saved) + " (content://)");
				return true;
			}
		} catch (Exception e) {
			SketchwareUtil.showMessage(getApplicationContext(), "Помилка: " + e.getMessage());
		}
		return false;
	}
	
	private boolean saveToDataHolder() {
		try {
			HashMap<String, Object> temp2 = JsonUtils.M(dataHolder.getData("info"));
			String key = getIntent().getStringExtra("dh");
			dataHolder.setData(temp2.get(key).toString(), editText.getText().toString());
			SketchwareUtil.showMessage(getApplicationContext(), "Saved to DataHolder");
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	// Допоміжний метод для самого запису (щоб не дублювати код)
	private void saveContentToFile(File file) {
		try {
			java.io.FileOutputStream fos = new java.io.FileOutputStream(file);
			fos.write(editText.getText().toString().getBytes("utf-8"));
			fos.flush();
			fos.close();
			
			// Оновлюємо Uri в змінній, щоб наступне збереження було швидким
			filePath = Uri.fromFile(file).toString();
			isFile = true;
			
			SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.file_saved));
			
		} catch (Exception e) {
			SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.error_save) + e.getMessage());
		}
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
			
			// Отримуємо поточну позицію курсора
			int cursorPosition = editText.getSelectionStart();
			
			// Індекси збігів, які найближчі до курсора
			int firstBeforeIndex = -1;
			int lastBeforeIndex = -1;
			
			while (matcher.find()) {
				int start = matcher.start();
				int end = matcher.end();
				matchPositions.add(new int[]{start, end});
				
				// Фіксуємо останній знайдений збіг, який знаходиться ПЕРЕД курсором
				if (start <= cursorPosition) {
					lastBeforeIndex = matchPositions.size() - 1;
				}
			}
			
			if (matchPositions.isEmpty()) {
				Toast.makeText(this, getString(R.string.nofound), Toast.LENGTH_SHORT).show();
				editText.getText().replace(0, editText.length(), spannable);
				updcnt();
				return;
			}
			
			// Визначаємо межі для підсвічування (вікно в 50 збігів в обидва боки)
			int totalMatches = matchPositions.size();
			int startHighlightIndex = 0;
			int endHighlightIndex = totalMatches - 1;
			
			if (lastBeforeIndex != -1) {
				// Починаємо максимум за 50 збігів до курсора
				startHighlightIndex = Math.max(0, lastBeforeIndex - 49);
				// Закінчуємо максимум через 50 збігів після курсора (включаючи той, на якому курсор)
				endHighlightIndex = Math.min(totalMatches - 1, lastBeforeIndex + 50);
			} else {
				// Якщо курсор стоїть перед усім текстом, беремо просто перші 50 збігів
				endHighlightIndex = Math.min(totalMatches - 1, 49);
			}
			
			// Фарбуємо лише ті збіги, що потрапили у "вікно"
			for (int i = startHighlightIndex; i <= endHighlightIndex; i++) {
				int[] pos = matchPositions.get(i);
				spannable.setSpan(new BackgroundColorSpan(DEFAULT_HIGHLIGHT_COLOR),
				pos[0], pos[1], Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
				spannable.setSpan(new ForegroundColorSpan(Color.BLACK),
				pos[0], pos[1], Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
			}
			
			// Визначаємо поточний активний збіг (наприклад, найближчий перед курсором або найперший)
			currentMatchIndex = (lastBeforeIndex != -1) ? lastBeforeIndex : 0;
			
			// Окремо підсвічуємо поточний збіг
			int[] currentPos = matchPositions.get(currentMatchIndex);
			spannable.setSpan(new BackgroundColorSpan(CURRENT_HIGHLIGHT_COLOR),
			currentPos[0], currentPos[1], Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
			
			// Оновлюємо текст (зберігає undo)
			editText.getText().replace(0, editText.length(), spannable);
			
			// Якщо потрібно змінити виділення (опціонально, залежно від твоєї логіки "Next/Prev")
			// editText.setSelection(currentPos[0], currentPos[1]);
			
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
	
	public class GapBuffer {
		private char[] buffer;
		private int gapStart;
		private int gapEnd;
		private int capacity;
		
		public GapBuffer(CharSequence initialText) {
			this.capacity = Math.max(initialText.length() * 2, 1024); // Запас ходу
			this.buffer = new char[capacity];
			
			// Копіюємо початковий текст на початок буфера
			for (int i = 0; i < initialText.length(); i++) {
				buffer[i] = initialText.charAt(i);
			}
			
			this.gapStart = initialText.length();
			this.gapEnd = capacity;
		}
		
		// Рухаємо розрив до позиції, де користувач хоче щось змінити (наприклад, поставив курсор)
		public void moveGapTo(int index) {
			if (index == gapStart) return;
			
			if (index < gapStart) {
				// Рухаємо розрив ліворуч
				int distance = gapStart - index;
				System.arraycopy(buffer, index, buffer, gapEnd - distance, distance);
				gapStart -= distance;
				gapEnd -= distance;
			} else {
				// Рухаємо розрив праворуч
				int distance = index - gapStart;
				System.arraycopy(buffer, gapEnd, buffer, gapStart, distance);
				gapStart += distance;
				gapEnd += distance;
			}
		}
		
		// Вставка символів у розрив (Працює миттєво, якщо є місце в gap)
		public void insert(int index, CharSequence text) {
			moveGapTo(index);
			
			// Якщо розрив закінчився, розширюємо масив
			while (gapEnd - gapStart < text.length()) {
				grow();
			}
			
			for (int i = 0; i < text.length(); i++) {
				buffer[gapStart++] = text.charAt(i);
			}
		}
		
		// Видалення символів (Просто розширюємо розрив — миттєва операція!)
		public void delete(int index, int length) {
			moveGapTo(index);
			gapEnd += length; // Просто зміщуємо вказівник, фізично видаляти символи не треба
		}
		
		// Розширення масиву, якщо текст переріс буфер
		private void grow() {
			int newCapacity = capacity * 2;
			char[] newBuffer = new char[newCapacity];
			
			// Копіюємо частину ДО розриву
			System.arraycopy(buffer, 0, newBuffer, 0, gapStart);
			
			// Копіюємо частину ПІСЛЯ розриву в самий кінець нового буфера
			int tailLength = capacity - gapEnd;
			int newGapEnd = newCapacity - tailLength;
			System.arraycopy(buffer, gapEnd, newBuffer, newGapEnd, tailLength);
			
			this.buffer = newBuffer;
			this.gapEnd = newGapEnd;
			this.capacity = newCapacity;
		}
		
		public int length() {
			return gapStart + (capacity - gapEnd);
		}
		
		@Override
		public String toString() {
			// Збираємо текст до купи для відображення (без урахування розриву)
			StringBuilder sb = new StringBuilder();
			sb.append(buffer, 0, gapStart);
			sb.append(buffer, gapEnd, capacity - gapEnd);
			return sb.toString();
		}
	}
	
	public class GapBufferEditable extends SpannableStringBuilder {
		private final GapBuffer gapBuffer;
		
		public GapBufferEditable(CharSequence text) {
			// 1. Правильно передаємо текст у суперклас SpannableStringBuilder
			super(text); 
			// 2. Ініціалізуємо внутрішній GapBuffer (рівно один раз!)
			this.gapBuffer = new GapBuffer(text); 
		}
		
		@Override
		public SpannableStringBuilder replace(int start, int end, CharSequence tb, int tbstart, int tbend) {
			// 1. Обробляємо видалення старого тексту в нашому Gap Buffer
			if (end > start) {
				gapBuffer.delete(start, end - start);
			}
			
			// 2. Обробляємо вставку нового тексту в наш Gap Buffer
			if (tbend > tbstart) {
				CharSequence insertedText = tb.subSequence(tbstart, tbend);
				gapBuffer.insert(start, insertedText);
			}
			
			// 3. Віддаємо команду суперкласу, щоб EditText оновив UI
			// Для суперкласу це теж буде легше, бо ми контролюємо структуру синхронно
			return super.replace(start, end, tb, tbstart, tbend);
		}
		
		// Перевизначення toString гарантує, що коли система захоче зберегти файл,
		// вона візьме оптимізовану збірку тексту з GapBuffer
		@Override
		public String toString() {
			if(gapBuffer!=null)
			return gapBuffer.toString();
			else return "null";
		}
	}
	
	public class EfficientEditableFactory extends Editable.Factory {
		@Override
		public Editable newEditable(CharSequence source) {
			// Замість стандартного SpannableStringBuilder повертаємо наш оптимізований клас
			return new GapBufferEditable(source);
		}
	}
	
	{
	}
	
	
	public void _buttonsizeset() {
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		float buttonBaseSize = Float.parseFloat(sf.getString("button", "40")); // 40 як запасне значення
		
		TextView[] buttons = {
			//back, pgup, forward, pgdn,
			//bookmarks, histori, home, tabs,
			//dual, skipvideo, pagesearch, coordinates,
			serrep, save, settings, sup, sdown, newf, open
		};
		
		for (TextView b : buttons) {
			adjustButton(b, buttonBaseSize);
		}
		
	}
	private void adjustButton(TextView button, float baseSizeDp) {
		float density = getResources().getDisplayMetrics().density;
		ViewGroup.LayoutParams lp = button.getLayoutParams();
		lp.width  = (int) (baseSizeDp * density * 1.27f);
		lp.height = (int) (baseSizeDp * density);
		button.setLayoutParams(lp); // щоб застосувати нові розміри
		button.setTextSize(baseSizeDp / 2.5f);
	}
	{
	}
	
	
	public void _updtitle() {
		new Thread(() -> {
			String len = Formater.kmgt((int) editText.getText().toString().length());
			runOnUiThread(() -> {
				name.setText((changed ? "*" : "") +
				(isCut ? " " : "") +
				"[" +
				len +
				"] " +
				(isFile ? "File:" : "Data Holder:") + " \"" +
				(isFile ? (filePath != null ? filePath : "Unknown") : filePath) + "\"");
			});
		}).start();
	}
	
}
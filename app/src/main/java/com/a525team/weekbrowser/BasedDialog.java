package com.a525team.weekbrowser; // Або вашого проекту

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.text.InputType;
import android.view.*;
import android.widget.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class BasedDialog {
	
	public interface OnInputResult {
		void onResult(String text);
	}
	
	public interface OnFileSelected {
		void onSelected(File file);
	}
	
	// 1. Стандартний діалог введення з підтримкою RenderUtils
	public static void showInput(Activity activity, String title, String hint, boolean onlyNumbers, String prev, final OnInputResult callback) {
    final EditText input = new EditText(activity);
    input.setHint(hint);
    
    // НАЛАШТУВАННЯ ТИПУ ВВОДУ
    if (onlyNumbers) {
        input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_NUMBER_FLAG_DECIMAL);
    } else {
        // Додаємо прапорець багаторядковості
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_MULTI_LINE);
        // Додаткові налаштування для зручності:
        input.setSingleLine(false);
        input.setMinLines(1);
        input.setMaxLines(10); // Обмеження висоти (з'явиться скрол)
        input.setGravity(Gravity.TOP | Gravity.START); // Курсор і текст будуть зверху ліворуч
    }
    
    input.setText(prev);
    
    // Перевірка на моноширинний шрифт
    SharedPreferences sf = activity.getSharedPreferences("sf", Context.MODE_PRIVATE);
    if ("1".equals(sf.getString("monoforta", ""))) {
        input.setTypeface(android.graphics.Typeface.MONOSPACE);
    }
    
    FrameLayout container = new FrameLayout(activity);
    FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    params.leftMargin = 50;
    params.rightMargin = 50;
    input.setLayoutParams(params);
    container.addView(input);
    
    AlertDialog dialog = new AlertDialog.Builder(activity)
            .setTitle(title)
            .setView(container)
            .setPositiveButton(activity.getString(R.string.ok), (d, w) -> callback.onResult(input.getText().toString()))
            .setNegativeButton(activity.getString(R.string.cancel), null)
            .create();
    
    RenderUtils.setupDialogDim(activity, dialog);
    dialog.show();
}
	
	public static void showFileManager(Activity activity, String title, String filter, boolean isSaveMode, final OnFileSelected callback) {
		showFileManager(activity, title, filter, (byte)(0x00 | (isSaveMode ? 0x01 : 0x00)), callback);
	}
	
	// 2. Метод для запуску Міні-Файлового Менеджера
	public static void showFileManager(Activity activity, String title, String filter, byte isSaveMode, final OnFileSelected callback) {
		// 0x00 — Відкрити файл
		// 0x01 — Зберегти файл
		// 0x02 — Обрати папку
		if (!hasStoragePermission(activity)) {
			requestStoragePermission(activity);
			return;
		}
		
		LinearLayout root = new LinearLayout(activity);
		root.setOrientation(LinearLayout.VERTICAL);
		root.setPadding(20, 20, 20, 20);
		
		// --- Верхня панель (Шлях + Нова папка) ---
		LinearLayout topBar = new LinearLayout(activity);
		topBar.setOrientation(LinearLayout.HORIZONTAL);
		topBar.setGravity(Gravity.CENTER_VERTICAL);
		
		final TextView pathTv = new TextView(activity);
		pathTv.setPadding(10, 10, 10, 10);
		LinearLayout.LayoutParams pathParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f);
		pathTv.setLayoutParams(pathParams);
		
		// Кнопка створення папки
		TextView btnNewFolder = new TextView(activity);
		btnNewFolder.setText(""); // Ваша іконка
		try {
			btnNewFolder.setTypeface(android.graphics.Typeface.createFromAsset(activity.getAssets(), "fonts/icons.ttf"));
		} catch (Exception e) {}
		btnNewFolder.setTextSize(24);
		btnNewFolder.setPadding(15, 10, 15, 10);
		btnNewFolder.setGravity(Gravity.CENTER);
		
		ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
		try {
			btnNewFolder.setTextColor((int) Long.parseLong(dataHolder.getData("add"), 16));
		} catch (Exception e) {
			btnNewFolder.setTextColor(Color.BLUE);
		}
		
		topBar.addView(pathTv);
		topBar.addView(btnNewFolder);
		
		// --- Панель збереження (Ім'я файлу + Розширення) ---
		LinearLayout saveBar = new LinearLayout(activity);
		saveBar.setOrientation(LinearLayout.HORIZONTAL);
		
		// ВИПРАВЛЕНО 1: Показуємо поле вводу ТІЛЬКИ в режимі Збереження (0x01)
		if (isSaveMode != 0x01) {
			saveBar.setVisibility(View.GONE);
		}
		
		final EditText fileNameInput = new EditText(activity);
		fileNameInput.setHint(activity.getString(R.string.filenameddd));
		fileNameInput.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f));
		
		SharedPreferences sf = activity.getSharedPreferences("sf", Context.MODE_PRIVATE);
		if ("1".equals(sf.getString("monoforta", ""))) {
			fileNameInput.setTypeface(android.graphics.Typeface.MONOSPACE);
		}
		
		final String extension = (filter != null && !filter.trim().isEmpty()) 
		? (filter.startsWith(".") ? filter.split("[,;\\s]+")[0] : "." + filter.split("[,;\\s]+")[0]) 
		: ".txt";
		
		Button btnExt = new Button(activity);
		btnExt.setText(extension);
		
		btnExt.setOnClickListener(v -> {
			String currentText = fileNameInput.getText().toString();
			if (!currentText.isEmpty() && !currentText.endsWith(extension)) {
				fileNameInput.setText(currentText + extension);
				fileNameInput.setSelection(fileNameInput.getText().length());
			}
		});
		
		saveBar.addView(fileNameInput);
		saveBar.addView(btnExt);
		
		// --- Список файлів ---
		final ListView listView = new ListView(activity);
		final File[] currentDir = {Environment.getExternalStorageDirectory()};
		final ArrayList<String> fileList = new ArrayList<>();
		ThemeManager.setList(activity, fileList, listView);
		
		final AlertDialog[] dialogContainer = new AlertDialog[1];
		
		Runnable updateList = new Runnable() {
			@Override
			public void run() {
				fileList.clear();
				pathTv.setText(activity.getString(R.string.pathdd) + currentDir[0].getAbsolutePath());
				fileList.add(".. [" + activity.getString(R.string.backbtn) + "]");
				
				File[] files = currentDir[0].listFiles();
				if (files != null) {
					ArrayList<String> dirs = new ArrayList<>();
					ArrayList<String> ffs = new ArrayList<>();
					for (File f : files) {
						if (f.isDirectory()) dirs.add(f.getName() + "/");
						else if (filter == null || filter.isEmpty() || f.getName().toLowerCase().endsWith(filter.toLowerCase())) {
							ffs.add(f.getName());
						}
					}
					Collections.sort(dirs);
					Collections.sort(ffs);
					fileList.addAll(dirs);
					fileList.addAll(ffs);
				}
				((BaseAdapter) listView.getAdapter()).notifyDataSetChanged();
			}
		};
		
		btnNewFolder.setOnClickListener(v -> {
			showInput(activity, activity.getString(R.string.newf), "Folder name", false, "", name -> {
				if (name != null && !name.trim().isEmpty()) {
					File newDir = new File(currentDir[0], name.trim());
					if (!newDir.exists()) {
						if (newDir.mkdirs()) {
							updateList.run();
						} else {
							Toast.makeText(activity, "Error creating folder", Toast.LENGTH_SHORT).show();
						}
					}
				}
			});
		});
		
		listView.setOnItemClickListener((parent, view, position, id) -> {
			String item = fileList.get(position);
			if (item.equals(".. [" + activity.getString(R.string.backbtn) + "]")) {
				if (currentDir[0].getParentFile() != null) {
					currentDir[0] = currentDir[0].getParentFile();
					updateList.run();
				}
			} else if (item.endsWith("/")) {
				currentDir[0] = new File(currentDir[0], item.substring(0, item.length() - 1));
				updateList.run();
			} else {
				if (isSaveMode == 0x01) {
					fileNameInput.setText(item);
				} else if (isSaveMode == 0x00) {
					callback.onSelected(new File(currentDir[0], item));
					if (dialogContainer[0] != null) dialogContainer[0].dismiss();
				}
				// Якщо isSaveMode == 0x02, клік по файлу просто ігнорується (це правильно)
			}
		});
		
		root.addView(topBar);
		root.addView(saveBar);
		root.addView(listView);
		updateList.run();
		
		// ВИПРАВЛЕНО 2: Динамічна назва кнопки
		String positiveBtnText = (isSaveMode == 0x01) ? activity.getString(R.string.saveh) : activity.getString(R.string.ok);
		
		dialogContainer[0] = new AlertDialog.Builder(activity)
		.setTitle(title)
		.setView(root)
		.setPositiveButton(positiveBtnText, (d, w) -> {
			// ВИПРАВЛЕНО 3: Розділена логіка для Збереження і Вибору папки
			if (isSaveMode == 0x01) {
				String name = fileNameInput.getText().toString();
				if (!name.isEmpty()) {
					File target = new File(currentDir[0], name);
					if (target.exists()) {
						new AlertDialog.Builder(activity)
						.setTitle(activity.getString(R.string.file_exist))
						.setMessage(activity.getString(R.string.rewriteq))
						.setPositiveButton(activity.getString(R.string.yes), (d2, w2) -> callback.onSelected(target))
						.setNegativeButton(activity.getString(R.string.no), null).show();
					} else {
						callback.onSelected(target);
					}
				}
			} else if (isSaveMode == 0x02) {
				// У режимі вибору папки просто повертаємо поточну відкриту директорію
				callback.onSelected(currentDir[0]);
			}
		})
		.setNegativeButton(activity.getString(R.string.cancel), null)
		.create();
		
		RenderUtils.setupDialogDim(activity, dialogContainer[0]);
		dialogContainer[0].show();
		dialogContainer[0].getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
	}
	
	// --- Логіка Дозволів ---
	
	private static boolean hasStoragePermission(Context context) {
		if (WTF.SDK_INT() >= 30) {
			return Environment.isExternalStorageManager();
		} else if (WTF.SDK_INT() >= 23) {
			return context.checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == android.content.pm.PackageManager.PERMISSION_GRANTED;
		}
		return true; // SDK < 23
	}
	
	private static void requestStoragePermission(Activity activity) {
		if (WTF.SDK_INT() >= 30) {
			try {
				Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
				intent.setData(Uri.parse("package:" + activity.getPackageName()));
				activity.startActivity(intent);
			} catch (Exception e) {
				Intent intent = new Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
				activity.startActivity(intent);
			}
		} else {
			// Для SDK 23-29 запускаємо стандартний SAF як фолбек або просимо дозвіл
			// Тут ми просто нагадаємо користувачу, що треба дозвіл
			Toast.makeText(activity, "Надайте дозвіл на запис у налаштуваннях", Toast.LENGTH_LONG).show();
		}
	}
}

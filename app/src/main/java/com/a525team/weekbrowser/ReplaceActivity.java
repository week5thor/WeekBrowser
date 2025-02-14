package com.a525team.weekbrowser;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.*;
import android.content.pm.PackageManager;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ScrollView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.regex.*;
import org.json.*;

public class ReplaceActivity extends Activity {
	
	private ArrayList<String> languag = new ArrayList<>();
	
	private ScrollView vscroll1;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.replace);
		initialize(_savedInstanceState);
		
		if (Build.VERSION.SDK_INT >= 23) {
			if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
				requestPermissions(new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 1000);
			} else {
				initializeLogic();
			}
		} else {
			initializeLogic();
		}
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		ThemeManager.applyTheme(this); // Встановлення теми
		 
		        super.onCreate(_savedInstanceState);
		        setContentView(R.layout.replace);
		vscroll1 = findViewById(R.id.vscroll1);
	}
	
	private void initializeLogic() {
	}
	
	@Override
	public void onResume() {
		super.onResume();
		
	}
	public void _language() {
		if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
			languag = new Gson().fromJson(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Language.welang"), new TypeToken<ArrayList<String>>(){}.getType());
		}
		try{
			
		}catch(Exception e){
			if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
				
			}
			else {
				
			}
		}
		try{
			
		}catch(Exception e){
			if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
				
			}
			else {
				
			}
		}
		try{
			
			
			
			
			
		}catch(Exception e){
			if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
				
				
				
				
				
			}
			else {
				
				
				
				
				
			}
		}
		try{
			
			
			
			
			
		}catch(Exception e){
			if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
				
				
				
				
				
			}
			else {
				
				
				
				
				
			}
		}
		try{
			
			
			
			
			
		}catch(Exception e){
			if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
				
				
				
				
				
			}
			else {
				
				
				
				
				
			}
		}
	}
	
}
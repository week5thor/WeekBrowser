package com.a525team.weekbrowser;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.*;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.os.Bundle;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class IntentActivity extends Activity {
	
	private String filePath = "";
	private String content = "";
	private boolean isfree = false;
	private boolean isAd = false;
	private String blockedline = "";
	
	private ArrayList<String> skin = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> window = new ArrayList<>();
	
	private LinearLayout linear1;
	private TextView textview1;
	
	private Intent thema = new Intent();
	private Intent intent2 = new Intent();
	private AlertDialog.Builder d;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.intent);
		initialize(_savedInstanceState);
		
		if (Build.VERSION.SDK_INT >= 23) {
			if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
			||checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
				requestPermissions(new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
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
		int themeValue = Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt"));
		
		        switch (themeValue) {
				            case 0:
				                setTheme(android.R.style.Theme_Material_Light);
				                break;
				            case 1:
				                setTheme(android.R.style.Theme_Material);
				                break;
				            case 2:
				                setTheme(android.R.style.Theme_Light);
				                break;
				            case 3:
				                
				        String styleValue = FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/style.txt");
				
				        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
						            setTheme(android.R.style.Theme_Black);
						        } else {
						            switch (styleValue) {
								                case "1":
								                    setTheme(android.R.style.Theme_Black);
								                    break;
								                case "2":
								                    setTheme(android.R.style.Theme_Light);
								                    break;
								                case "3":
								                    setTheme(android.R.style.Theme_Holo);
								                    break;
								                case "4":
								                    setTheme(android.R.style.Theme_Holo_Light);
								                    break;
								                case "5":
								                    setTheme(android.R.style.Theme_Material);
								                    break;
								                case "6":
								                    setTheme(android.R.style.Theme_Material_Light);
								                    break;
								                default:
								                    setTheme(android.R.style.Theme_Light);
								                    break;
								            }
						        }
				                
				                break;
				            case 4:
				                setTheme(android.R.style.Theme_Material_Light);
				                break;
				            case 5:
				                setTheme(android.R.style.Theme_Material);
				                break;
				            case 6:
				                setTheme(android.R.style.Theme_Holo_Light);
				                break;
				            case 7:
				                setTheme(android.R.style.Theme_Holo);
				                break;
				            case 8:
				                setTheme(android.R.style.Theme_Material_Light);
				                break;
				            case 9:
				                setTheme(android.R.style.Theme_Material);
				                break;
				            case 10:
				                setTheme(android.R.style.Theme_Material);
				                break;
				                case 11:
				                setTheme(android.R.style.Theme_Light);
				                break;
				                case 12:
				                setTheme(android.R.style.Theme_Light);
				                break;
				
				            default:
				                setTheme(android.R.style.Theme_Light);
				                break;
				        }
		
		        super.onCreate(_savedInstanceState);
		        setContentView(R.layout.intent);
		linear1 = findViewById(R.id.linear1);
		textview1 = findViewById(R.id.textview1);
		d = new AlertDialog.Builder(this);
	}
	
	private void initializeLogic() {
		intent2 = getIntent();
		
		Uri fileUri = intent2.getData();
		String filePath = fileUri.getPath(); // Може повернути щось на кшталт "/uid/file:///storage/emulated/0/..."
		
		// Якщо шлях містить "/uid/", спробуйте його також прибрати:
		if (filePath.startsWith("/uid/")) {
			    filePath = filePath.replaceFirst("/uid/", "");
		}
		
		// Якщо шлях містить "file://" спочатку, треба його прибрати:
		if (filePath.startsWith("file://")) {
			    filePath = filePath.replaceFirst("file://", "");
		}
		
		filePath = decodeUrl(filePath);
		if (!filePath.isEmpty() && filePath.matches(".*\\.wesk$")) {
			content = FileUtil.readFile(filePath);
			if (!content.equals("")) {
				skin = new Gson().fromJson(content, new TypeToken<ArrayList<String>>(){}.getType());
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/bg.txt", skin.get((int)(0)));
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/buttonbg.txt", skin.get((int)(1)).concat(skin.get((int)(2))));
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/redbuttonbg.txt", skin.get((int)(3)).concat(skin.get((int)(4))));
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/text.txt", skin.get((int)(5)));
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/textfield.txt", skin.get((int)(6)));
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/additional.txt", skin.get((int)(7)));
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/hint.txt", skin.get((int)(8)));
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/buttontext.txt", skin.get((int)(9)));
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/redbuttontext.txt", skin.get((int)(10)));
				try{
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/style.txt", skin.get((int)(11)));
				}catch(Exception e){
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/style.txt", "3");
				}
				try{
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/roundness.txt", skin.get((int)(12)));
				}catch(Exception e){
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/roundness.txt", "0");
				}
				try{
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/composebuttoncolor.txt", skin.get((int)(13)));
				}catch(Exception e){
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/composebuttoncolor.txt", skin.get((int)(5)));
				}
				try{
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/trackpadcolor.txt", skin.get((int)(14)));
				}catch(Exception e){
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/trackpadcolor.txt", skin.get((int)(5)));
				}
				try{
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/thumbcolor.txt", skin.get((int)(15)));
				}catch(Exception e){
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/thumbcolor.txt", skin.get((int)(6)));
				}
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt", "3");
				_colorToRam();
				thema.setClass(getApplicationContext(), SettingsActivity.class);
				startActivity(thema);
				finish();
			}
		}
		else {
			if (!filePath.isEmpty() && filePath.matches(".*\\.wesk2$")) {
				new UnZip().unZipIt(filePath, "/storage/emulated/0/WeekBrowser");
				thema.setClass(getApplicationContext(), SettingsActivity.class);
				startActivity(thema);
				finish();
			}
			else {
				if (!filePath.isEmpty() && filePath.matches(".*\\.wedes$")) {
					new UnZip().unZipIt(filePath, "/storage/emulated/0/WeekBrowser");
					thema.setClass(getApplicationContext(), BookmarksActivity.class);
					startActivity(thema);
					finish();
				}
				else {
					if (!filePath.isEmpty() && filePath.matches(".*\\.skin$")) {
						content = FileUtil.readFile(filePath);
						if (!content.equals("")) {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/bg.txt", extractColor(content, "KeyboardBackgroundStartColor="));
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/buttonbg.txt", extractColor(content, "KeyBackEndColor=").concat(extractColor(content, "KeyBackStartColor=")));
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/redbuttonbg.txt", extractColor(content, "SpecKeyBackEndColor=").concat(extractColor(content, "SpecKeyBackStartColor=")));
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/text.txt", extractColor(content, "KeyTextColor="));
						}
					}
					else {
						if (intent2.getData().toString().startsWith("https://multilink2.weekbrowser.com/")) {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/activeTab.txt", "0");
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Tabs.json", decodeUrl(intent2.getData().toString().replace("https://multilink2.weekbrowser.com/", "")));
							thema.setClass(getApplicationContext(), MainActivity.class);
							thema.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
							startActivity(thema);
							finish();
						}
						else {
							try{
								for (int i = 0; i < FileUtils.getFileLines("/storage/emulated/0/WeekBrowser/Blockad/domains.txt"); i++) {
									    String line = FileUtils.readLinesFromFile("/storage/emulated/0/WeekBrowser/Blockad/domains.txt", i);
									    if (line != null) {
										        line = line.replace("\\.", ".");
										        if (!line.isEmpty() && !line.startsWith("//") && !line.startsWith("#")) {
											            if (intent2.getData().toString().toLowerCase().startsWith("%")) {
												                if (intent2.getData().toString().matches(".*" + line.substring(1) + ".*")) {
													                    isAd = true;
													                    blockedline = line;
													                    break;
													                }
												            } else {
												                if (_extractDomain(intent2.getData().toString()).matches(".*" + line + ".*")) {
													                    isAd = true;
													                    blockedline = line;
													                    break;
													                }
												            }
											        }
										    } else {
										        Log.e("ReadLineError", "Failed to read line " + i + " from domains.txt");
										   
										    }
								}
								
								for (int i = 0; i < FileUtils.getFileLines("/storage/emulated/0/WeekBrowser/Blockad/userdomains.txt"); i++) {
									    String line = FileUtils.readLinesFromFile("/storage/emulated/0/WeekBrowser/Blockad/userdomains.txt", i);
									    if (line != null) {
										        line = line.replace("\\.", ".");
										        if (!line.isEmpty() && !line.startsWith("//") && !line.startsWith("#")) {
											            if (intent2.getData().toString().toLowerCase().startsWith("%")) {
												                if (intent2.getData().toString().matches(".*" + line.substring(1) + ".*")) {
													                    isAd = true;
													blockedline = line;
													                    break;
													                }
												            } else {
												                if (_extractDomain(intent2.getData().toString()).matches(".*" + line + ".*")) {
													                    isAd = true;
													blockedline = line;
													                    break;
													                }
												            }
											        }
										    } else {
										        Log.e("ReadLineError", "Failed to read line " + i + " from userdomains.txt");
										       
										    }
								}
								
							}catch(Exception e){
								isAd = false;
							}
							if (isAd) {
								SketchwareUtil.showMessage(getApplicationContext(), "Цей сайт заблокований блокувальником реклами\n".concat(blockedline));
								moveTaskToBack(true);
							}
							else {
								FileUtil.writeFile("/storage/emulated/0/WeekBrowser/url", intent2.getData().toString());
								thema.setClass(getApplicationContext(), MainActivity.class);
								startActivity(thema);
							}
							finish();
						}
					}
				}
			}
		}
	}
	
	public void _extra() {
	}
	
	
	/*MADE BY ARAB WARE CHANNEL*/
	/*WHAT IS MADE ? ===>ADD FOLDER TO ZIP*/
	
	public void ArabWareAddFolderToZip (String _from,String _to) {
		if (FileUtil.isExistFile(_to.replace(Uri.parse(_to).getLastPathSegment(), "").concat("files/"))) {
				new UnZip().unZipIt(_to, _to.replace(Uri.parse(_to).getLastPathSegment(), "").concat("files/"));
				new java.io.File(_from).renameTo(new java.io.File(_to.replace(Uri.parse(_to).getLastPathSegment(), "").concat("files/").concat(Uri.parse(_from).getLastPathSegment())));
				try {
						Zip.zipFolder(_to.replace(Uri.parse(_to).getLastPathSegment(), "").concat("files/"),_to.replace(Uri.parse(_to).getLastPathSegment(), "") + Uri.parse(_to).getLastPathSegment());
				} catch(Exception e) {}
				FileUtil.deleteFile(_to.replace(Uri.parse(_to).getLastPathSegment(), "").concat("files/"));
		}
		else {
				FileUtil.makeDir(_to.replace(Uri.parse(_to).getLastPathSegment(), "").concat("files/"));
				new UnZip().unZipIt(_to, _to.replace(Uri.parse(_to).getLastPathSegment(), "").concat("files/"));
				new java.io.File(_from).renameTo(new java.io.File(_to.replace(Uri.parse(_to).getLastPathSegment(), "").concat("files/").concat(Uri.parse(_from).getLastPathSegment())));
				try {
						Zip.zipFolder(_to.replace(Uri.parse(_to).getLastPathSegment(), "").concat("files/"),_to.replace(Uri.parse(_to).getLastPathSegment(), "") + Uri.parse(_to).getLastPathSegment());
				} catch(Exception e) {}
				FileUtil.deleteFile(_to.replace(Uri.parse(_to).getLastPathSegment(), "").concat("files/"));
		}
	}
	
	
	
	public void addFilesToZip(java.io.File source, java.io.File files)
	{
		    try
		    {
			
			   
			        byte[] buffer = new byte[1024];
			        java.util.zip.ZipInputStream zin = new java.util.zip.ZipInputStream(new java.io.FileInputStream(files));
			        java.util.zip.ZipOutputStream out = new java.util.zip.ZipOutputStream(new java.io.FileOutputStream(source));
			            java.io.InputStream in = new java.io.FileInputStream(files);
			            out.putNextEntry(new java.util.zip.ZipEntry(files.getName()));
			            for(int read = in.read(buffer); read > -1; read = in.read(buffer))
			            {
				                out.write(buffer, 0, read);
				            }
			            out.closeEntry();
			            in.close();
			
			        for(java.util.zip.ZipEntry ze = zin.getNextEntry(); ze != null; ze = zin.getNextEntry())
			        {
				            out.putNextEntry(ze);
				            for(int read = zin.read(buffer); read > -1; read = zin.read(buffer))
				            {
					                out.write(buffer, 0, read);
					            }
				            out.closeEntry();
				        }
			
			        out.close();
			      
			    }
		    catch(Exception e)
		    {
			       showMessage(e.getMessage());
			    }
	}
	public static class Zip {
		
		public static void zipFolder(String str, String str2) throws Exception {
			            java.util.zip.ZipOutputStream zipOutputStream = new java.util.zip.ZipOutputStream(new java.io.FileOutputStream(str2));
			            addFolderToZip("", str, zipOutputStream);
			            zipOutputStream.flush();
			            zipOutputStream.close();
			        }
		
		
		public static void addFolderToZip(String str, String str2, java.util.zip.ZipOutputStream zipOutputStream) throws Exception {
			            java.io.File file = new java.io.File(str2);
			            for (String str3 : file.list()) {
				                if (str.equals("")) {
					                    addFileToZip(file.getName(), new StringBuilder(String.valueOf(str2)).append("/").append(str3).toString(), zipOutputStream);
					                } else {
					                    addFileToZip(new StringBuilder(String.valueOf(str)).append("/").append(file.getName()).toString(), new StringBuilder(String.valueOf(str2)).append("/").append(str3).toString(), zipOutputStream);
					                }
				            }
			        }
		
		
		
		  public static void addFileToZip(String path, String srcFile, java.util.zip.ZipOutputStream zip)
		      throws Exception {
			    java.io.File folder = new java.io.File(srcFile);
			    if (folder.isDirectory()) {
				      
				    } else {
				      byte[] buf = new byte[1024];
				      int len;
				      java.io.FileInputStream in = new java.io.FileInputStream(srcFile);
				      zip.putNextEntry(new java.util.zip.ZipEntry(path + "/" + folder.getName()));
				      while ((len = in.read(buf)) > 0) {
					        zip.write(buf, 0, len);
					      }
				    }
		}
		  }
	
	public static class UnZip {
		List<String> fileList;
		
		public void unZipIt(String zipFile, String outputFolder){
			byte[] buffer = new byte[1024];
			try{
				java.util.zip.ZipInputStream zis = new java.util.zip.ZipInputStream(new java.io.FileInputStream(zipFile));
				java.util.zip.ZipEntry ze = zis.getNextEntry();
				while(ze!=null){
					String fileName = ze.getName();
					java.io.File newFile = new java.io.File(outputFolder + java.io.File.separator + fileName);
					new java.io.File(newFile.getParent()).mkdirs();
					java.io.FileOutputStream fos = new java.io.FileOutputStream(newFile);
					int len;
					while ((len = zis.read(buffer)) > 0) {
						fos.write(buffer, 0, len);
					}
					fos.close();
					ze = zis.getNextEntry(); 
				}
				zis.closeEntry();
				zis.close();
			}catch(java.io.IOException ex){
				ex.printStackTrace();
			}
		}
	}
	
	    public static String extractColor(String inputText, String prefix) {
		        String regex = prefix + "0x" + "([a-fA-F0-9]+)";
		        
		        Pattern pattern = Pattern.compile(regex);
		        Matcher matcher = pattern.matcher(inputText);
		        
		        if (matcher.find()) {
			            return matcher.group(1);
			        } else {
			           regex = prefix + "#" + "([a-fA-F0-9]+)";
			        
			        pattern = Pattern.compile(regex);
			        matcher = pattern.matcher(inputText);
			        
			        if (matcher.find()) {
				            return matcher.group(1);
				        } else {return null;} 
			        }
		    }
	
	public static String extractColo(String inputText, String prefix) {
		        String regex = prefix + "([a-fA-F0-9]+)";
		        
		        Pattern pattern = Pattern.compile(regex);
		        Matcher matcher = pattern.matcher(inputText);
		        
		        if (matcher.find()) {
			            return matcher.group(1);
			        } else {
			        return null;
			        }
		    }
	    
	    public static String decodeUrl(String url) {
		        try {
			            return URLDecoder.decode(url, "UTF-8");
			        } catch (UnsupportedEncodingException e) {
			            e.printStackTrace();
			            return url; // Повертаємо оригінальний URL у випадку помилки
			        }
		    }
	    public static String encodeUrl(String url) {
		        try {
			            return URLEncoder.encode(url, "UTF-8");
			        } catch (UnsupportedEncodingException e) {
			            e.printStackTrace();
			            return url; // Повертаємо оригінальний URL у випадку помилки
			        }
		    }
	
	{
	}
	
	
	public String _extractDomain(final String _url) {
		try {
			            URI uri = new URI(_url);
			            final Set<String> COMMON_PREFIXES = new HashSet<>(Arrays.asList("www", "m", "mobile"));
			            String domain = uri.getHost();
			            if (domain != null) {
				                String[] parts = domain.split("\\.");
				                if (parts.length > 2 && COMMON_PREFIXES.contains(parts[0])) {
					                    // Видаляє префікс, якщо він присутній у списку
					                    domain = String.join(".", Arrays.copyOfRange(parts, 1, parts.length));
					                }
				                return domain;
				            }
			        } catch (URISyntaxException e) {
			            e.printStackTrace(); // Додайте ваше логування тут
			        }
		        return null;
	}
	
	
	public void _colorToRam() {
		ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
		switch(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt")) {
			case "0": {
				if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
					
					dataHolder.setData("bg", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_10)).toUpperCase());
					dataHolder.setData("bbg", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_600)).toUpperCase());
					dataHolder.setData("bbg2", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_600)).toUpperCase());
					dataHolder.setData("rbg", Integer.toHexString(getResources().getColor(android.R.color.system_accent3_600)).toUpperCase());
					dataHolder.setData("rbg2", Integer.toHexString(getResources().getColor(android.R.color.system_accent3_600)).toUpperCase());
					dataHolder.setData("t", Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_700)).toUpperCase());
					dataHolder.setData("tf", Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_700)).toUpperCase());
					dataHolder.setData("add", Integer.toHexString(getResources().getColor(android.R.color.system_accent3_600)).toUpperCase());
					dataHolder.setData("h", Integer.toHexString(getResources().getColor(android.R.color.system_accent2_600)).toUpperCase());
					dataHolder.setData("bt", "ffffffff");
					dataHolder.setData("rbt", "ffffffff");
					dataHolder.setData("rou", "12");
				}else{
					dataHolder.setData("bg", "ffffffff");
					dataHolder.setData("bbg", "ff018577");
					dataHolder.setData("bbg2", "ff018577");
					dataHolder.setData("rbg", "fff44336");
					dataHolder.setData("rbg2", "fff44336");
					dataHolder.setData("t", "ff000000");
					dataHolder.setData("tf", "ff000000");
					dataHolder.setData("add", "ff018577");
					dataHolder.setData("h", "ff888888");
					dataHolder.setData("bt", "ffffffff");
					dataHolder.setData("rbt", "ffffffff");
					dataHolder.setData("rou", "12");
				}
				break;
			}
			case "1": {
				if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
					
					dataHolder.setData("bg", Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_900)).toUpperCase());
					dataHolder.setData("bbg", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_200)).toUpperCase());
					dataHolder.setData("bbg2", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_200)).toUpperCase());
					dataHolder.setData("rbg", Integer.toHexString(getResources().getColor(android.R.color.system_accent3_200)).toUpperCase());
					dataHolder.setData("rbg2", Integer.toHexString(getResources().getColor(android.R.color.system_accent3_200)).toUpperCase());
					dataHolder.setData("t", Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_200)).toUpperCase());
					dataHolder.setData("tf", Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_200)).toUpperCase());
					dataHolder.setData("add", Integer.toHexString(getResources().getColor(android.R.color.system_accent3_200)).toUpperCase());
					dataHolder.setData("h", Integer.toHexString(getResources().getColor(android.R.color.system_accent2_200)).toUpperCase());
					dataHolder.setData("bt", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_800)).toUpperCase());
					dataHolder.setData("rbt", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_800)).toUpperCase());
					dataHolder.setData("rou", "12");
				}else{
					dataHolder.setData("bg", "ff303030");
					dataHolder.setData("bbg", "ff80cbc4");
					dataHolder.setData("bbg2", "ff80cbc4");
					dataHolder.setData("rbg", "fff44336");
					dataHolder.setData("rbg2", "fff44336");
					dataHolder.setData("t", "ffffffff");
					dataHolder.setData("tf", "ffffffff");
					dataHolder.setData("add", "ff80cbc4");
					dataHolder.setData("h", "ff888888");
					dataHolder.setData("bt", "ff000000");
					dataHolder.setData("rbt", "ffffffff");
					dataHolder.setData("rou", "12");
				}
				break;
			}
			case "2": {
				dataHolder.setData("bg", "ff000000");
				dataHolder.setData("bbg", "ff00ffff");
				dataHolder.setData("bbg2", "ff00ffff");
				dataHolder.setData("rbg", "ffff0000");
				dataHolder.setData("rbg2", "ffff0000");
				dataHolder.setData("t", "ffffffff");
				dataHolder.setData("tf", "ff000000");
				dataHolder.setData("add", "ff00ffff");
				dataHolder.setData("h", "ffffff00");
				dataHolder.setData("bt", "ff000000");
				dataHolder.setData("rbt", "ffffffff");
				dataHolder.setData("rou", "0");
				break;
			}
			case "4": {
				if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
					
					dataHolder.setData("bg", "ffffffff");
					dataHolder.setData("bbg", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_600)).toUpperCase());
					dataHolder.setData("bbg2", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_600)).toUpperCase());
					dataHolder.setData("rbg", Integer.toHexString(getResources().getColor(android.R.color.system_accent3_600)).toUpperCase());
					dataHolder.setData("rbg2", Integer.toHexString(getResources().getColor(android.R.color.system_accent3_600)).toUpperCase());
					dataHolder.setData("t", Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_700)).toUpperCase());
					dataHolder.setData("tf", Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_700)).toUpperCase());
					dataHolder.setData("add", Integer.toHexString(getResources().getColor(android.R.color.system_accent3_600)).toUpperCase());
					dataHolder.setData("h", Integer.toHexString(getResources().getColor(android.R.color.system_accent2_600)).toUpperCase());
					dataHolder.setData("bt", "ffffffff");
					dataHolder.setData("rbt", "ffffffff");
					dataHolder.setData("rou", "12");
				}else{
					dataHolder.setData("bg", "ffffffff");
					dataHolder.setData("bbg", "ff018577");
					dataHolder.setData("bbg2", "ff018577");
					dataHolder.setData("rbg", "fff44336");
					dataHolder.setData("rbg2", "ff44336");
					dataHolder.setData("t", "ff000000");
					dataHolder.setData("tf", "ff000000");
					dataHolder.setData("add", "ff018577");
					dataHolder.setData("h", "ff888888");
					dataHolder.setData("bt", "ffffffff");
					dataHolder.setData("rbt", "ffffffff");
					dataHolder.setData("rou", "12");
				}
				break;
			}
			case "5": {
				if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
					
					dataHolder.setData("bg", "ff000000");
					dataHolder.setData("bbg", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_200)).toUpperCase());
					dataHolder.setData("bbg2", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_200)).toUpperCase());
					dataHolder.setData("rbg", Integer.toHexString(getResources().getColor(android.R.color.system_accent3_200)).toUpperCase());
					dataHolder.setData("rbg2", Integer.toHexString(getResources().getColor(android.R.color.system_accent3_200)).toUpperCase());
					dataHolder.setData("t", Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_200)).toUpperCase());
					dataHolder.setData("tf", Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_200)).toUpperCase());
					dataHolder.setData("add", Integer.toHexString(getResources().getColor(android.R.color.system_accent3_200)).toUpperCase());
					dataHolder.setData("h", Integer.toHexString(getResources().getColor(android.R.color.system_accent2_200)).toUpperCase());
					dataHolder.setData("bt", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_800)).toUpperCase());
					dataHolder.setData("rbt", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_800)).toUpperCase());
					dataHolder.setData("rou", "12");
				}else{
					dataHolder.setData("bg", "ff000000");
					dataHolder.setData("bbg", "ff80cbc4");
					dataHolder.setData("bbg2", "ff80cbc4");
					dataHolder.setData("rbg", "fff44336");
					dataHolder.setData("rbg2", "fff44336");
					dataHolder.setData("t", "ffffffff");
					dataHolder.setData("tf", "ffffffff");
					dataHolder.setData("add", "ff80cbc4");
					dataHolder.setData("h", "ff888888");
					dataHolder.setData("bt", "ff000000");
					dataHolder.setData("rbt", "ffffffff");
					dataHolder.setData("rou", "12");
				}
				break;
			}
			case "6": {
				dataHolder.setData("bg", "ffffffff");
				dataHolder.setData("bbg", "ff33b5e5");
				dataHolder.setData("bbg2", "ff33b5e5");
				dataHolder.setData("rbg", "ffb71c1c");
				dataHolder.setData("rbg2", "ffb71c1c");
				dataHolder.setData("t", "ff000000");
				dataHolder.setData("tf", "ff000000");
				dataHolder.setData("add", "ff35b5e5");
				dataHolder.setData("h", "ff757575");
				dataHolder.setData("bt", "ff000000");
				dataHolder.setData("rbt", "ffffffff");
				dataHolder.setData("rou", "0");
				break;
			}
			case "7": {
				dataHolder.setData("bg", "ff000000");
				dataHolder.setData("bbg", "ff33b5e5");
				dataHolder.setData("bbg2", "ff33b5e5");
				dataHolder.setData("rbg", "ffb71c1c");
				dataHolder.setData("rbg2", "ffb71c1c");
				dataHolder.setData("t", "ffffffff");
				dataHolder.setData("tf", "ffffffff");
				dataHolder.setData("add", "ff35b5e5");
				dataHolder.setData("h", "ffbdbdbd");
				dataHolder.setData("bt", "ff000000");
				dataHolder.setData("rbt", "ffffffff");
				dataHolder.setData("rou", "0");
				break;
			}
			case "8": {
				dataHolder.setData("bg", "ffffffff");
				dataHolder.setData("bbg", "ff018577");
				dataHolder.setData("bbg2", "ff018577");
				dataHolder.setData("rbg", "fff44336");
				dataHolder.setData("rbg2", "fff44336");
				dataHolder.setData("t", "ff000000");
				dataHolder.setData("tf", "ff000000");
				dataHolder.setData("add", "ff018577");
				dataHolder.setData("h", "ff888888");
				dataHolder.setData("bt", "ffffffff");
				dataHolder.setData("rbt", "ffffffff");
				dataHolder.setData("rou", "12");
				break;
			}
			case "9": {
				dataHolder.setData("bg", "ff303030");
				dataHolder.setData("bbg", "ff80cbc4");
				dataHolder.setData("bbg2", "ff80cbc4");
				dataHolder.setData("rbg", "fff44336");
				dataHolder.setData("rbg2", "fff44336");
				dataHolder.setData("t", "ffffffff");
				dataHolder.setData("tf", "ffffffff");
				dataHolder.setData("add", "ff80cbc4");
				dataHolder.setData("h", "ff888888");
				dataHolder.setData("bt", "ff000000");
				dataHolder.setData("rbt", "ffffffff");
				dataHolder.setData("rou", "12");
				break;
			}
			case "10": {
				dataHolder.setData("bg", "ff000000");
				dataHolder.setData("bbg", "ff80cbc4");
				dataHolder.setData("bbg2", "ff80cbc4");
				dataHolder.setData("rbg", "fff44336");
				dataHolder.setData("rbg2", "fff44336");
				dataHolder.setData("t", "ffffffff");
				dataHolder.setData("tf", "ffffffff");
				dataHolder.setData("add", "ff80cbc4");
				dataHolder.setData("h", "ff888888");
				dataHolder.setData("bt", "ff000000");
				dataHolder.setData("rbt", "ffffffff");
				dataHolder.setData("rou", "12");
				break;
			}
			case "11": {
				dataHolder.setData("bg", "ffffffff");
				dataHolder.setData("bbg", "ffeaeaea");
				dataHolder.setData("bbg2", "ffb8b8b8");
				dataHolder.setData("rbg", "ffeaeaea");
				dataHolder.setData("rbg2", "ffb8b8b8");
				dataHolder.setData("t", "ff000000");
				dataHolder.setData("tf", "ff000000");
				dataHolder.setData("add", "ff68B200");
				dataHolder.setData("h", "ff888888");
				dataHolder.setData("bt", "ff000000");
				dataHolder.setData("rbt", "ffff0000");
				dataHolder.setData("rou", "0");
				break;
			}
			case "12": {
				dataHolder.setData("bg", "ff000000");
				dataHolder.setData("bbg", "ffeaeaea");
				dataHolder.setData("bbg2", "ffb8b8b8");
				dataHolder.setData("rbg", "ffeaeaea");
				dataHolder.setData("rbg2", "ffb8b8b8");
				dataHolder.setData("t", "ffffffff");
				dataHolder.setData("tf", "ff000000");
				dataHolder.setData("add", "ff90ff22");
				dataHolder.setData("h", "ff888888");
				dataHolder.setData("bt", "ff000000");
				dataHolder.setData("rbt", "ffff0000");
				dataHolder.setData("rou", "0");
				break;
			}
			case "3": {
				
				
				dataHolder.setData("bg", FileUtil.readFile("storage/emulated/0/WeekBrowser/CustomTheme/bg.txt"));
				dataHolder.setData("bbg", FileUtil.readFile("storage/emulated/0/WeekBrowser/CustomTheme/buttonbg.txt"));
				dataHolder.setData("bbg2", FileUtil.readFile("storage/emulated/0/WeekBrowser/CustomTheme/buttonbg2.txt"));
				dataHolder.setData("rbg", FileUtil.readFile("storage/emulated/0/WeekBrowser/CustomTheme/redbuttonbg.txt"));
				dataHolder.setData("rbg2", FileUtil.readFile("storage/emulated/0/WeekBrowser/CustomTheme/redbuttonbg2.txt"));
				dataHolder.setData("t", FileUtil.readFile("storage/emulated/0/WeekBrowser/CustomTheme/text.txt"));
				dataHolder.setData("tf", FileUtil.readFile("storage/emulated/0/WeekBrowser/CustomTheme/textfield.txt"));
				dataHolder.setData("add", FileUtil.readFile("storage/emulated/0/WeekBrowser/CustomTheme/additional.txt"));
				dataHolder.setData("h", FileUtil.readFile("storage/emulated/0/WeekBrowser/CustomTheme/hint.txt"));
				dataHolder.setData("bt", FileUtil.readFile("storage/emulated/0/WeekBrowser/CustomTheme/buttontext.txt"));
				dataHolder.setData("rbt", FileUtil.readFile("storage/emulated/0/WeekBrowser/CustomTheme/redbuttontext.txt"));
				dataHolder.setData("rou", FileUtil.readFile("storage/emulated/0/WeekBrowser/CustomTheme/roundness.txt"));
				break;
			}
		}
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}
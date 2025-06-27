package com.a525team.weekbrowser;

import android.app.AlertDialog;
import android.app.Activity;
import android.graphics.Color;
//import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.EditText;
import android.text.Editable;
import android.text.TextWatcher;
//import android.view.inputmethod.InputMethodManager;
import android.view.WindowManager;
import android.graphics.drawable.GradientDrawable;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.MotionEvent;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.GridView;
import java.util.ArrayList;
import java.util.HashMap;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.Window;

public class ColorPickerDialog {
	private String[] colmain = {
        "ff000000", "ffffffff", "ffff0000", "ffffff00", "ff00ff00", "ff00ffff", "ff0000ff",
        "ff111111", "ffeeeeee", "ffdd0000", "ffdddd00", "ff00dd00", "ff00dddd", "ff0000dd",
        "ff222222", "ffdddddd", "ffbb0000", "ffbbbb00", "ff00bb00", "ff00bbbb", "ff0000bb",
        "ff333333", "ffcccccc", "ff990000", "ff999900", "ff009900", "ff009999", "ff000099",
        "ff444444", "ffbbbbbb", "ff770000", "ff777700", "ff007700", "ff007777", "ff000077",
        "ff555555", "ffaaaaaa", "ff550000", "ff555500", "ff005500", "ff005555", "ff000055",
        "ff666666", "ff999999", "ff330000", "ff333300", "ff003300", "ff003333", "ff000033",
        "ff777777", "ff888888", "ff110000", "ff111100", "ff001100", "ff001111", "ff000011",
        "ffff00ff", "ffee00ee", "ffbb00bb", "ff990099", "ff770077", "ff550055", "ff330033",
        "ffff8000", "ff80ff00", "ff00ff80", "ff0080ff", "ff8000ff", "ffff0080", "ff110011"
        };
        
    private String[] colmain2 = {
        "FFC284FF", "FFB47363", "ffff0000", "ffffff00", "ff00ff00", "ff00ffff", "ff0000ff",
        "FFA8E0FF", "FF64C992", "ffff1111", "ffffff11", "ff11ff11", "ff11ffff", "ff1111ff",
        "FF4BFF9E", "FF49C1AE", "ffff3333", "ffffff33", "ff33ff33", "ff33ffff", "ff3333ff",
        "FF9DFFAB", "FF9770E1", "ffff5555", "ffffff55", "ff55ff55", "ff55ffff", "ff5555ff",
        "FFECB8FF", "ff735184", "ffff7777", "ffffff77", "ff77ff77", "ff77ffff", "ff7777ff",
        "FFFFA0B5", "ff465464", "ffff9999", "ffffff99", "ff99ff99", "ff99ffff", "ff9999ff",
        "FFFFEDB6", "FF6E5941", "ffffbbbb", "ffffffbb", "ff99ff99", "ffbbffff", "ffbbbbff",
        "FFFFA38C", "FF988100", "ffffdddd", "ffffffdd", "ffddffdd", "ffddffff", "ffddddff",
        "ffff00ff", "ffff11ff", "ffff33ff", "ffff55ff", "ffff77ff", "ffff99ff", "ffffbbff",
        "ffff8000", "ff80ff00", "ff00ff80", "ff0080ff", "ff8000ff", "ffff0080", "ffffddff"
        };
        
    private String[] colredyellow = {
        "ffCD5C5C", "ffF08080", "ffFA8072", "ffE9967A", "ffFFA07A", "ffDC143C", "ffFF0000",
        "ffB22222", "ff8B0000", "ffFFA07A", "ffFF7F50", "FFFF6347", "ffFF4500", "ffFF8C00",
        "ffFFA500", "ffFFD700", "ffFFFF00", "ffFFFFE0", "ffFFFACD", "ffFAFAD2", "ffFFEFD5",
        "ffFFE4B5", "ffFFDAB9", "ffEEE8AA", "ffF0E68C", "ffBDB76B", "ffFFF8DC", "ffFFEBCD",
        "ffFFE4C4", "ffFFDEAD", "ffF5DEB3", "ffDEB887", "ffD2B48C", "ffBC8F8F", "ffF4A460",
        "ffDAA520", "ffB8860B", "ffCD853F", "ffD2691E", "ff8B4513", "ffA0522D", "ffA52A2A",
        "ff800000", "ff000000", "ff2F4F4F", "ff708090", "ff778899", "ff696969", "ff808080",
        "ffA9A9A9", "ffC0C0C0", "ffD3D3D3", "ffDCDCDC", "ffFFFFFF", "ffFFFAFA", "ffF0FFF0",
        "ffF5FFFA", "ffF0FFFF", "ffF0F8FF", "ffF8F8FF", "ffF5F5F5", "ffFFF5EE", "ffF5F5DC",
        "ffFDF5E6", "ffFFFAF0", "ffFFFFF0", "ffFAEBD7", "ffFAF0E6", "ffFFF0F5", "ffFFE4E1"
        };
    private String[] colbluepink = {
        "ffADFF2F", "ff7FFF00", "ff7CFC00", "ff00FF00", "ff32CD32", "ff98FB98", "ff90EE90",
        "ff00FA9A", "ff00FF7F", "ff3CB371", "ff2E8B57", "ff228B22", "ff008000", "ff006400",
        "ff9ACD32", "ff6B8E23", "ff808000", "ff556B2F", "ff66CDAA", "ff8FBC8F", "ff20B2AA",
        "ff008B8B", "ff008080", "ff00FFFF", "ffE0FFFF", "ffAFEEEE", "ff7FFFD4", "ff40E0D0",
        "ff48D1CC", "ff00CED1", "ff5F9EA0", "ff4682B4", "ffB0C4DE", "ffB0E0E6", "ffADD8E6",
        "ff87CEEB", "ff87CEFA", "ff00BFFF", "ff1E90FF", "ff6495ED", "ff7B68EE", "ff4169E1",
        "ff0000FF", "ff0000CD", "ff00008B", "ff000080", "ff191970", "ffE6E6FA", "ffD8BFD8",
        "ffDDA0DD", "ffEE82EE", "ffDA70D6", "ffFF00FF", "ffBA55D3", "ff9370DB", "ff8A2BE2",
        "ff9400D3", "ff9932CC", "ff8B008B", "ff800080", "ff4B0082", "ff6A5ACD", "ff483D8B",
        "ffFFC0CB", "ffFFB6C1", "ffFF69B4", "ffFF1493", "ffC71585", "ffDB7093", "ffca5675"
        };
        
    private String[] coolor1 = {
        "ffF94144", "ffF3722C", "ffF8961E", "ffF9844A", "ffF9C74F", "ff90BE6D", "ff43AA8B",
        "ff4D908E", "ff577590", "ff277DA1", "ff000000", "ff84FFC9", "ffAAB2FF", "ffECA0FF",
        "ff2D00F7", "ff6A00F4", "ff8900F2", "ffBC00DD", "ffE500A4", "ffF20089", "ffFFB600",
        "ff72BAD5", "ff0E4C6D", "ff03324E", "ff01263D", "ffEF4043", "ffBE1E2D", "ffC43240",
        "ff264653", "ff287271", "ff2A9D8F", "ff8AB17D", "ffE9C46A", "ffF4A261", "ffE76F51",
        "ff42047E", "ff382C83", "ff2E5489", "ff257C8E", "ff1BA493", "ff11CC99", "ff07F49E",
        "ff774936", "ff6A3E2D", "ff5C3324", "ff4F281C", "ff411D13", "ff34120A", "ff260701",
        "ff264653", "ff2A9D8F", "ffE9C46A", "ffF4A261", "ffE76F51", "ffEC8C74", "ffF0A390",
        "ff95F9C3", "ff7ED9B4", "ff67B9A4", "ff509995", "ff397885", "ff225876", "ff0B3866",
        "ffCACFF9", "ffD1CEF4", "ffD8CEEE", "ffE0CDE9", "ffE7CCE4", "ffEECCDE", "ffF5CBD9"
        };
        
    private String[] coolor2 = {
        "ffFF6D00", "ffFF8500", "ffFF9E00", "ff240046", "ff5A189A", "ff9D4EDD", "ff18AF9D",
        "ff0AD2FF", "ff2962FF", "ff9500FF", "ffFF0059", "ffFF8C00", "ffB4E600", "ff0FFFDB",
        "ff2D00F7", "ffE500A4", "ffF20089", "ffFFB600", "ff6A00F4", "ff8900F2", "ffBC00DD",
        "ffFF1970", "ffE81766", "ffDB12AF", "ffBF09D5", "ffA200FA", "ff6500E9", "ff3C17DB",
        "ffFF4200", "ffFF147D", "ff7D14FF", "ff005AFF", "ff14FFE6", "ffBAFF14", "ffFFF600",
        "ff2D00F7", "ffE500A4", "ffF20089", "ffFFB600", "ff6A00F4", "ff8900F2", "ffBC00DD",
        "ff361C0E", "ff570211", "ff7E3110", "ff004540", "ff032C4D", "ff360825", "ff000044",
        "ff007A7A", "ff004040", "ff000000", "ff3D0000", "ff7A0000", "ff000000", "ff000000",
        "ffCB997E", "ffEDDCD2", "ffFFF1E6", "ffF0EFEB", "ffDDBEA9", "ffA5A58D", "ffB7B7A4",
        "ffF0EAD2", "ffDDE5B6", "ffADC178", "ff7B8F4B", "ffA98467", "ff6C584C", "ff79675C"
        };
     
     private String[] kelvin1 = {//1000 to 7900K
    "ffff4300", "ffff880d", "ffffb16d", "ffffcda6", "ffffe4cd", "fffff6ec", "fff2f2ff",
    "ffff4d00", "ffff8d1b", "ffffb474", "ffffd0aa", "ffffe5d1", "fffff7ef", "ffeff0ff",
    "ffff5600", "ffff9227", "ffffb77b", "ffffd2af", "ffffe7d4", "fffff9f2", "ffeceeff",
    "ffff5e00", "ffff9632", "ffffba81", "ffffd5b3", "ffffe9d7", "fffffbf4", "ffeaedff",
    "ffff6500", "ffff9b3c", "ffffbd87", "ffffd7b7", "ffffebdb", "fffffcf7", "ffe7ecff",
    "ffff6c00", "ffff9f46", "ffffc08c", "ffffd9bb", "ffffedde", "fffffefa", "ffe5eaff",
    "ffff7200", "ffffa24f", "ffffc392", "ffffdbbf", "ffffefe1", "ffffffff", "ffe3e9ff",
    "ffff7800", "ffffa657", "ffffc697", "ffffddc3", "fffff1e4", "fffef8ff", "ffe2e8ff",
    "ffff7e00", "ffffaa5f", "ffffc89c", "ffffdfc6", "fffff2e7", "fff9f6ff", "ffe0e7ff",
    "ffff8300", "ffffad66", "ffffcba1", "ffffe2ca", "fffff4ea", "fff6f4ff", "ffdee6ff"
};

	private String[] kelvin2 = {//8000 to 21800K
    "ffdde5ff", "ffc9daff", "ffbfd3ff", "ffb7ceff", "ffb2cbff", "ffaec8ff", "ffaac6ff",
    "ffdae4ff", "ffc8d9ff", "ffbed2ff", "ffb7ceff", "ffb2cbff", "ffadc8ff", "ffaac6ff",
    "ffd7e2ff", "ffc7d8ff", "ffbdd2ff", "ffb6ceff", "ffb1caff", "ffadc8ff", "ffaac5ff",
    "ffd5e1ff", "ffc5d7ff", "ffbcd1ff", "ffb6cdff", "ffb1caff", "ffadc7ff", "ffa9c5ff",
    "ffd3e0ff", "ffc4d7ff", "ffbbd1ff", "ffb5cdff", "ffb0caff", "ffacc7ff", "ffa9c5ff",
    "ffd1deff", "ffc3d6ff", "ffbbd1ff", "ffb5cdff", "ffb0caff", "ffacc7ff", "ffa9c5ff",
    "ffcfddff", "ffc2d5ff", "ffbad0ff", "ffb4ccff", "ffafc9ff", "ffacc7ff", "ffa8c5ff",
    "ffcedcff", "ffc1d5ff", "ffb9d0ff", "ffb4ccff", "ffafc9ff", "ffabc7ff", "ffa8c4ff",
    "ffccdbff", "ffc0d4ff", "ffb9cfff", "ffb3ccff", "ffafc9ff", "ffabc6ff", "ffa8c4ff",
    "ffcbdaff", "ffbfd4ff", "ffb8cfff", "ffb3cbff", "ffaec8ff", "ffabc6ff", "ffa7c4ff"
};

private String[] material1 = {
        "ffFFEBEE", "ffFCE4EC", "ffF3E5F5", "ffEDE7F6", "ffE8EAF6", "ffE3F2FD", "ffE1F5FE",
        "ffFFCDD2", "ffF8BBD0", "ffE1BEE7", "ffD1C4E9", "ffC5CAE9", "ffBBDEFB", "ffB3E5FC",
        "ffEF9A9A", "ffF48FB1", "ffCE93D8", "ffB39DDB", "ff9FA8DA", "ff90CAF9", "ff81D4FA",
        "ffE57373", "ffF06292", "ffBA68C8", "ff9575CD", "ff7986CB", "ff64B5F6", "ff4FC3F7",
        "ffEF5350", "ffEC407A", "ffAB47BC", "ff7E57C2", "ff5C6BC0", "ff42A5F5", "ff29B6F6",
        "ffF44336", "ffE91E63", "ff9C27B0", "ff673AB7", "ff3F51B5", "ff2196F3", "ff03A9F4",
        "ffE53935", "ffD81B60", "ff8E24AA", "ff5E35B1", "ff3949AB", "ff1E88E5", "ff039BE5",
        "ffD32F2F", "ffC2185B", "ff7B1FA2", "ff512DA8", "ff303F9F", "ff1976D2", "ff0288D1",
        "ffC62828", "ffAD1457", "ff6A1B9A", "ff4527A0", "ff283593", "ff1565C0", "ff0277BD",
        "ffB71C1C", "ff880E4F", "ff4A148C", "ff311B92", "ff1A237E", "ff0D47A1", "ff01579B"
        };

private String[] material2 = {
        "ffE0F7FA", "ffE0F2F1", "ffE8F5E9", "ffF1F8E9", "ffF9FBE7", "ffFFFDE7", "ffFFF8E1",
        "ffB2EBF2", "ffB2DFDB", "ffC8E6C9", "ffDCEDC8", "ffF0F4C3", "ffFFF9C4", "ffFFECB3",
        "ff80DEEA", "ff80CBC4", "ffA5D6A7", "ffC5E1A5", "ffE6EE9C", "ffFFF59D", "ffFFE082",
        "ff4DD0E1", "ff4DB6AC", "ff81C784", "ffAED581", "ffDCE775", "ffFFF176", "ffFFD54F",
        "ff26C6DA", "ff26A69A", "ff66BB6A", "ff9CCC65", "ffD4E157", "ffFFEE58", "ffFFCA28",
        "ff00BCD4", "ff009688", "ff4CAF50", "ff8BC34A", "ffCDDC39", "ffFFEB3B", "ffFFC107",
        "ff00ACC1", "ff00897B", "ff43A047", "ff7CB342", "ffC0CA33", "ffFDD835", "ffFFB300",
        "ff0097A7", "ff00796B", "ff388E3C", "ff689F38", "ffAFB42B", "ffFBC02D", "ffFFA000",
        "ff00838F", "ff00695C", "ff2E7D32", "ff558B2F", "ff9E9D24", "ffF9A825", "ffFF8F00",
        "ff006064", "ff004D40", "ff1B5E20", "ff33691E", "ff827717", "ffF57F17", "ffFF6F00"
        };
        
private String[] material3 = {
        "ffFFF3E0", "ffFBE9E7", "ffEFEBE9", "ffFAFAFA", "ffECEFF1", "ffFF8A80", "ffEA80FC",
        "ffFFE0B2", "ffFFCCBC", "ffD7CCC8", "ffF5F5F5", "ffCFD8DC", "ffFF5252", "ffE040FB",
        "ffFFCC80", "ffFFAB91", "ffBCAAA4", "ffEEEEEE", "ffB0BEC5", "ffFF1744", "ffD500F9",
        "ffFFB74D", "ffFF8A65", "ffA1887F", "ffE0E0E0", "ff90A4AE", "ffD50000", "ffAA00FF",
        "ffFFA726", "ffFF7043", "ff8D6E63", "ffBDBDBD", "ff78909C", "ffFF80AB", "ffB388FF",
        "ffFF9800", "ffFF5722", "ff795548", "ff9E9E9E", "ff607D8B", "ffFF4081", "ff7C4DFF",
        "ffFB8C00", "ffF4511E", "ff6D4C41", "ff757575", "ff546E7A", "ffF50057", "ff651FFF",
        "ffF57C00", "ffE64A19", "ff5D4037", "ff616161", "ff455A64", "ffC51162", "ff6200EA",
        "ffEF6C00", "ffD84315", "ff4E342E", "ff424242", "ff37474F", "ff8C9EFF", "ff3D5AFE",
        "ffE65100", "ffBF360C", "ff3E2723", "ff212121", "ff263238", "ff536DFE", "ff304FFE"
        };

private String[] material4 = {
        "ff82B1FF", "ff84FFFF", "ffB9F6CA", "ffF4FF81", "ffFFE57F", "ffFF9E80", "ff000000",
        "ff448AFF", "ff18FFFF", "ff69F0AE", "ffEEFF41", "ffFFD740", "ffFF6E40", "ffffffff",
        "ff2979FF", "ff00E5FF", "ff00E676", "ffC6FF00", "ffFFC400", "ffFF3D00", "ff000000",
        "ff2962FF", "ff00B8D4", "ff00C853", "ffAEEA00", "ffFFAB00", "ffDD2C00", "ffffffff",
        "ff80D8FF", "ffA7FFEB", "ffCCFF90", "ffFFFF8D", "ffFFD180", "ffF1C40F", "ffF39C12",
        "ff40C4FF", "ff64FFDA", "ffB2FF59", "ffFFFF00", "ffFFAB40", "ffE67E22", "ffD35400",
        "ff00B0FF", "ff1DE9B6", "ff76FF03", "ffFFEA00", "ffFF9100", "ffE74C3C", "ffC0392B",
        "ff0091EA", "ff00BFA5", "ff64DD17", "ffFFD600", "ffFF6D00", "ffECF0F1", "ffBDC3C7",
        "ff1ABC9C", "ff2ECC71", "ff3498DB", "ff9B59B6", "ff34495E", "ff95A5A6", "ff7F8C8D",
        "ff16A085", "ff27AE60", "ff2980B9", "ff8E44AD", "ff2C3E50", "ff000000", "ff000000"
        };

/*private String[] coolor2 = {
        "ff", "ff", "ff", "ff", "ff", "ff", "ff",
        "ff", "ff", "ff", "ff", "ff", "ff", "ff",
        "ff", "ff", "ff", "ff", "ff", "ff", "ff",
        "ff", "ff", "ff", "ff", "ff", "ff", "ff",
        "ff", "ff", "ff", "ff", "ff", "ff", "ff",
        "ff", "ff", "ff", "ff", "ff", "ff", "ff",
        "ff", "ff", "ff", "ff", "ff", "ff", "ff",
        "ff", "ff", "ff", "ff", "ff", "ff", "ff",
        "ff", "ff", "ff", "ff", "ff", "ff", "ff",
        "ff", "ff", "ff", "ff", "ff", "ff", "ff"
        };
*/

	private ArrayList<HashMap<String, Object>> colorgrid = new ArrayList<>();
    private final Activity activity;
	private String hexRed = "00";
	private String hexGreen = "00";
	private String hexBlue = "00";
	private String hexAlpha = "00";
	private ColorPickerListener listener;
	private Bitmap bitmap;// = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);;
	private boolean hsvc;
	SeekBar red;
	SeekBar green;
	SeekBar blue;
	SeekBar alpha;
	SeekBar hue;
	SeekBar satur;
	SeekBar val;
	EditText medit;
    GridView pallete2;
	SeekBar pseek;
    TextView pname;
    
	int[] colors = {
		Color.parseColor("#FF0000"), // червоний
		Color.parseColor("#FFFF00"), // жовтий
		Color.parseColor("#00FF00"), // зелений
		Color.parseColor("#808080"), // сірий
		Color.parseColor("#00FFFF"), // блакитний
		Color.parseColor("#0000FF"), // синій
		Color.parseColor("#FF00FF"), // пурпурний
		Color.parseColor("#000000"), // чорний
		Color.parseColor("#FFFFFF"), // білий
		Color.parseColor("#804000"), // коричневий
		Color.parseColor("#FF0000")  // червоний (повтор, щоб замкнути градієнт)
	};
    
    int[] colors2 = {
		Color.parseColor("#008080"), // темно-бірюзовий
		Color.parseColor("#FF0000"), // червоний
		Color.parseColor("#008000"), // темно-зелений
		Color.parseColor("#800000"), // темно-червоний
		Color.parseColor("#808000"), // темно-жовтий
		Color.parseColor("#000080"), // темно-синій
		Color.parseColor("#0000ff"), // синій
		Color.parseColor("#ff00ff"), // пурпурний
		Color.parseColor("#ff0080"), // малиновий
		Color.parseColor("#8000ff"), // фіолетовий
		Color.parseColor("#008080")  // темно-бірюзовий (повтор, щоб замкнути градієнт)
	};
	
	public interface ColorPickerListener {
		void onColorPicked(String colorHex);
	}
	
	public ColorPickerDialog(Activity activity) {
		this.activity = activity;
	}
	
	public void setColorPickerListener(ColorPickerListener listener) {
		this.listener = listener;
	}
	
	public void show(String colhex) {
		RenderUtils ru = new RenderUtils(activity);
		// Перевірка на формат Monet або шістнадцятковий код
		if (colhex.startsWith("m__")) {
			// Обробка кольору Monet
			// TODO: Реалізуйте перетворення кольору Monet у шістнадцятковий формат
			// Наприклад: колір = processColor(colhex, false, isAndroid12OrHigher);
			// Встановити hexRed, hexGreen, hexBlue на відповідні значення
			hexRed = "00"; // Змінити на отримане значення
			hexGreen = "00"; // Змінити на отримане значення
			hexBlue = "00"; // Змінити на отримане значення
			hexAlpha = "00"; // Змінити на отримане значення
		} else {
			// Обробка шістнадцяткового коду
			hexRed = colhex.substring(2, 4);
			hexGreen = colhex.substring(4, 6);
			hexBlue = colhex.substring(6, 8);
			hexAlpha = colhex.substring(0, 2);
		}
		
		final AlertDialog dialog2 = new AlertDialog.Builder(activity).create();
		View inflate = LayoutInflater.from(activity).inflate(R.layout.colorpick, null);
		dialog2.setView(inflate);
		dialog2.setTitle("Built-in Color Picker v1.1");
		
		red = inflate.findViewById(R.id.red);
		green = inflate.findViewById(R.id.green);
		blue = inflate.findViewById(R.id.blue);
		alpha = inflate.findViewById(R.id.alpha);
		hue = inflate.findViewById(R.id.hue);
		satur = inflate.findViewById(R.id.satur);
		val = inflate.findViewById(R.id.val);
		Button ok = inflate.findViewById(R.id.ok);
		Button dismiss = inflate.findViewById(R.id.dismiss);
		medit = inflate.findViewById(R.id.medit);
		LinearLayout preview = inflate.findViewById(R.id.preview);
		LinearLayout palette = inflate.findViewById(R.id.palette);
    	LinearLayout palette2 = inflate.findViewById(R.id.palette2);
		pallete2 = inflate.findViewById(R.id.pallete2);
		pseek = inflate.findViewById(R.id.pseek);
		pname = inflate.findViewById(R.id.pname);
		
		if (WTF.SDK_INT() >= 21) {
			red.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#00ffff")));
			red.setThumbTintList(ColorStateList.valueOf(Color.parseColor("#00ffff")));
			green.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#ff00ff")));
			green.setThumbTintList(ColorStateList.valueOf(Color.parseColor("#ff00ff")));
			blue.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#ffff00")));
			blue.setThumbTintList(ColorStateList.valueOf(Color.parseColor("#ffff00")));
			hue.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#000000")));
			hue.setThumbTintList(ColorStateList.valueOf(Color.parseColor("#000000")));
			satur.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#00ffff")));
			satur.setThumbTintList(ColorStateList.valueOf(Color.parseColor("#00ffff")));
			val.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#00ffff")));
			val.setThumbTintList(ColorStateList.valueOf(Color.parseColor("#00ffff")));
		} else {
			// Для API < 21 немає підтримки ColorStateList для SeekBar
			// Можливо, ви захочете додати обробку для цих версій тут.
		}
		
		// Встановити початкові значення SeekBar згідно з поточним кольором
		red.setProgress(Integer.parseInt(hexRed, 16));
		green.setProgress(Integer.parseInt(hexGreen, 16));
		blue.setProgress(Integer.parseInt(hexBlue, 16));
		alpha.setProgress(Integer.parseInt(hexAlpha, 16));
		preview.setBackgroundColor(Color.parseColor("#" + hexAlpha + hexRed + hexGreen + hexBlue));
		medit.setText(hexAlpha + hexRed + hexGreen + hexBlue);
		rehsv();
		GradientDrawable drawable = new GradientDrawable();
		drawable.setShape(GradientDrawable.RECTANGLE);
		drawable.setGradientType(GradientDrawable.SWEEP_GRADIENT);
		drawable.setColors(colors);
		drawable.setGradientCenter(0.5f, 0.5f);  // Центр градієнта
		palette.setBackground(drawable);
        
        		GradientDrawable drawabled = new GradientDrawable();
		drawabled.setShape(GradientDrawable.RECTANGLE);
		drawabled.setGradientType(GradientDrawable.SWEEP_GRADIENT);
		drawabled.setColors(colors2);
		drawabled.setGradientCenter(0.5f, 0.5f);  // Центр градієнта
		palette2.setBackground(drawabled);
		
		{
			GradientDrawable hued = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{
				Color.parseColor("#FF0000"), // червоний
				Color.parseColor("#FFFF00"), // жовтий
				Color.parseColor("#00FF00"), // зелений
				Color.parseColor("#00FFFF"), // блакитний
				Color.parseColor("#0000FF"), // синій
				Color.parseColor("#FF00FF"), // рожевий
				Color.parseColor("#FF0000"), // червоний
			});
			hue.setBackground(hued);
		}{
			GradientDrawable saturd = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{
				Color.parseColor("#FFFFFF"), // білий
				Color.parseColor("#FF0000"), // червоний
			});
			satur.setBackground(saturd);
		}{
			GradientDrawable vald = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{
				Color.parseColor("#000000"), // чорний
				Color.parseColor("#FF0000"), // червоний
			});
			val.setBackground(vald);
		}		
		palette.setOnTouchListener((view, event) -> {
			if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
				int width = palette.getWidth();
				int height = palette.getHeight();
				
				// Переконайтесь, що палітра має правильний розмір
				bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
				Canvas canvas = new Canvas(bitmap);
				drawable.draw(canvas);
				// Отримання координат натискання
				int x = (int) event.getX();
				int y = (int) event.getY();
				
				// Перевірка, чи знаходяться координати в межах палітри
				if (x >= 0 && x < bitmap.getWidth() && y >= 0 && y < bitmap.getHeight()) {
					try {
						// Отримання кольору пікселя
						int pixelColor = bitmap.getPixel(x, y);
						String hexColor = String.format("#%08X", pixelColor); // Приведення до шістнадцяткового формату
						
						// Встановлення значення в EditText
						medit.setText(hexColor.substring(1));
					} catch (Exception e) {
						e.printStackTrace();  // Додано для налагодження
					}
				}
			}
			return true;
		});
        
        palette2.setOnTouchListener((view, event) -> {
			if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
				int width = palette2.getWidth();
				int height = palette2.getHeight();
				
				// Переконайтесь, що палітра має правильний розмір
				bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
				Canvas canvas = new Canvas(bitmap);
				drawabled.draw(canvas);
				// Отримання координат натискання
				int x = (int) event.getX();
				int y = (int) event.getY();
				
				// Перевірка, чи знаходяться координати в межах палітри
				if (x >= 0 && x < bitmap.getWidth() && y >= 0 && y < bitmap.getHeight()) {
					try {
						// Отримання кольору пікселя
						int pixelColor = bitmap.getPixel(x, y);
						String hexColor = String.format("#%08X", pixelColor); // Приведення до шістнадцяткового формату
						
						// Встановлення значення в EditText
						medit.setText(hexColor.substring(1));
					} catch (Exception e) {
						e.printStackTrace();  // Додано для налагодження
					}
				}
			}
			return true;
		});
		
		SeekBar.OnSeekBarChangeListener colorChangeListener = new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if(fromUser){
					hexRed = String.format("%02X", red.getProgress());
					hexGreen = String.format("%02X", green.getProgress());
					hexBlue = String.format("%02X", blue.getProgress());
					hexAlpha = String.format("%02X", alpha.getProgress());
					preview.setBackgroundColor(Color.parseColor("#" + hexAlpha + hexRed + hexGreen + hexBlue));
					
					medit.setText(hexAlpha + hexRed + hexGreen + hexBlue);}
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {}
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {}
		};
		
		setupHsvListeners();
		
		
		red.setOnSeekBarChangeListener(colorChangeListener);
		green.setOnSeekBarChangeListener(colorChangeListener);
		blue.setOnSeekBarChangeListener(colorChangeListener);
		alpha.setOnSeekBarChangeListener(colorChangeListener);
		
		medit.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String cs = _param1.toString();
				try{
					hexRed = cs.substring(2, 4);
					hexGreen = cs.substring(4, 6);
					hexBlue = cs.substring(6, 8);
					hexAlpha = cs.substring(0, 2);
					red.setProgress(Integer.parseInt(hexRed, 16));
					green.setProgress(Integer.parseInt(hexGreen, 16));
					blue.setProgress(Integer.parseInt(hexBlue, 16));
					alpha.setProgress(Integer.parseInt(hexAlpha, 16));
					preview.setBackgroundColor(Color.parseColor("#" + hexAlpha + hexRed + hexGreen + hexBlue));
					if(!hsvc)rehsv();
				}
				catch(Exception e){
					
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		dismiss.setOnClickListener(view -> {dialog2.dismiss();});
		
		ok.setOnClickListener(view -> {
			String selectedColorHex = hexAlpha + hexRed + hexGreen + hexBlue;
			if (listener != null) {
				listener.onColorPicked(selectedColorHex);
			}
			dialog2.dismiss();
		});
		
		pallete2.setAdapter(new Pallete2Adapter(colorgrid));
		setpallete(0);
		
		pseek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				setpallete(_param2);
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
        
        dialog2.setOnDismissListener(d -> {
ru.off();
    });
ru.on();

dialog2.setOnShowListener(d -> {
    Window window = dialog2.getWindow();
    if (window != null) {
        window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        window.setDimAmount(0f);
    }
});

		dialog2.show();
		
		// Ініціалізація кольорів Monet
		fillmonet(inflate, dialog2);
		
	}
	
	public static ArrayList<HashMap<String, Object>> ctg(String[] col0) {
		ArrayList<HashMap<String, Object>> colorgrid = new ArrayList<>();
		for (String color : col0) {
			HashMap<String, Object> map = new HashMap<>();
			map.put("c", color);
			colorgrid.add(map);
		}
		
		return colorgrid;
	}
	
	private void setpallete(int p) {
    ArrayList<HashMap<String, Object>> newData;
    switch (p) {
        case 0: 
            newData = ctg(colmain);
            pname.setText("Main colors");
            break;
        case 1: 
            newData = ctg(colmain2);
            pname.setText("Main Pastel colors");
            break;
        case 2: 
            newData = ctg(colredyellow);
            pname.setText("HTML colors №1");
            break;
        case 3: 
            newData = ctg(colbluepink);
            pname.setText("HTML colors №2");
            break;
        case 4: 
            newData = ctg(coolor1);
            pname.setText("Coolors color set №1");
            break;
        case 5: 
            newData = ctg(coolor2);
            pname.setText("Coolors color set №2");
            break;
        case 6: 
            newData = ctg(kelvin1);
            pname.setText("1000,1100..7900 kelvins");
            break;
        case 7: 
            newData = ctg(kelvin2);
            pname.setText("8000,8200..21800 kelvins");
            break;
        case 8: 
            newData = ctg(material1);
            pname.setText("Material Design Colors №1");
            break;
        case 9: 
            newData = ctg(material2);
            pname.setText("Material Design Colors №2");
            break;
        case 10: 
            newData = ctg(material3);
            pname.setText("Material Design Colors №3");
            break;
        case 11: 
            newData = ctg(material4);
            pname.setText("Material Design + Flat UI Colors №4");
            break;
        default: 
            pname.setText("!");
            newData = new ArrayList<>();
            break;
    }
    // Оновлюємо дані в адаптері
    ((Pallete2Adapter) pallete2.getAdapter()).updateData(newData);
}

	
	public class Pallete2Adapter extends BaseAdapter { 
    private ArrayList<HashMap<String, Object>> _data; 

    public Pallete2Adapter(ArrayList<HashMap<String, Object>> _arr) { 
        _data = _arr; 
    } 

    public void updateData(ArrayList<HashMap<String, Object>> newData) {
        _data.clear();
        _data.addAll(newData);
        notifyDataSetChanged();
    }

    @Override 
    public int getCount() { 
        return _data.size(); 
    } 

    @Override 
    public HashMap<String, Object> getItem(int _index) { 
        return _data.get(_index); 
    } 

    @Override 
    public long getItemId(int _index) { 
        return _index; 
    } 

    @Override
    public View getView(final int _position, View _v, ViewGroup _container) {
        LayoutInflater _inflater = LayoutInflater.from(_container.getContext());
        View _view = _v;
        if (_view == null) {
            _view = _inflater.inflate(R.layout.rect, _container, false);
        }

        final Button btn = _view.findViewById(R.id.btn);
        // Припускаємо, що у кожному HashMap під ключем "c" зберігається колір
        btn.setBackgroundColor(Color.parseColor("#" + _data.get(_position).get("c").toString().substring(2)));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _view) {
                // Припустимо, що змінна listener та medit оголошені і ініціалізовані десь у вашому класі
                if (listener != null) {
                    medit.setText(_data.get(_position).get("c").toString());
                }
            }
        });

        return _view;
    }
}

		
		private void rehsv() {
			int r = red.getProgress();
			int g = green.getProgress();
			int b = blue.getProgress();
			
			// Перетворення в діапазон [0; 1]
			double rNorm = r / 255.0;
			double gNorm = g / 255.0;
			double bNorm = b / 255.0;
			
			// Обчислення Max і Min
			double max = Math.max(rNorm, Math.max(gNorm, bNorm));
			double min = Math.min(rNorm, Math.min(gNorm, bNorm));
			double delta = max - min;
			
			// Обчислення яскравості (Value)
			double v = max * 255;
			val.setProgress((int) v);
			
			// Обчислення насиченості (Saturation)
			double s = (max == 0) ? 0 : (delta / max) * 255;
			satur.setProgress((int) s);
			
			// Обчислення відтінку (Hue)
			double h = 0;
			if (delta != 0) {
				if (max == rNorm) {
					h = (gNorm - bNorm) / delta;
				} else if (max == gNorm) {
					h = 2.0 + (bNorm - rNorm) / delta;
				} else {
					h = 4.0 + (rNorm - gNorm) / delta;
				}
				
				h *= 60; // Перетворення в градуси
				if (h < 0) {
					h += 360; // Переклад у позитивний діапазон
				}
			}
			
			// Перетворення Hue у ваш діапазон [0; 1530]
			h = h / 360.0 * 1530.0;
			hue.setProgress((int) h);
		}
		
		
		private int hsvToRgb(int h, int s, int v) {
			double hue = h / 1530.0; // Нормалізуємо hue до [0, 1]
			double saturation = s / 255.0; // Нормалізуємо saturation до [0, 1]
			double value = v / 255.0; // Нормалізуємо value до [0, 1]
			
			double c = value * saturation; // Хроматичність
			double x = c * (1 - Math.abs((hue * 6) % 2 - 1)); // Другий компонент кольору
			double m = value - c; // Зміщення для отримання RGB у [0, 1]
			
			double r = 0, g = 0, b = 0;
			
			if (0 <= hue && hue < 1.0 / 6.0) {
				r = c;
				g = x;
			} else if (1.0 / 6.0 <= hue && hue < 2.0 / 6.0) {
				r = x;
				g = c;
			} else if (2.0 / 6.0 <= hue && hue < 3.0 / 6.0) {
				g = c;
				b = x;
			} else if (3.0 / 6.0 <= hue && hue < 4.0 / 6.0) {
				g = x;
				b = c;
			} else if (4.0 / 6.0 <= hue && hue < 5.0 / 6.0) {
				r = x;
				b = c;
			} else if (5.0 / 6.0 <= hue && hue <= 1) {
				r = c;
				b = x;
			}
			
			r = (r + m) * 255;
			g = (g + m) * 255;
			b = (b + m) * 255;
			
			return Color.rgb((int) Math.round(r), (int) Math.round(g), (int) Math.round(b));
		}
		
		
		
		private void setupHsvListeners() {
			SeekBar.OnSeekBarChangeListener hsvChangeListener = new SeekBar.OnSeekBarChangeListener() {
				@Override
				public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
					if (fromUser) {
						// Отримуємо поточні значення HSV
						int h = hue.getProgress();
						int s = satur.getProgress();
						int v = val.getProgress();
						
						// Конвертуємо HSV у RGB
						int rgb = hsvToRgb(h, s, v);
						
						// Отримуємо значення прозорості (alpha)
						int alphaValue = alpha.getProgress();
						
						// Перетворюємо RGB у шістнадцятковий формат AARRGGBB
						String hexColor = String.format("#%02X%02X%02X%02X",
						alphaValue,
						(rgb >> 16) & 0xFF, // Червоний
						(rgb >> 8) & 0xFF,  // Зелений
						rgb & 0xFF);        // Синій
						
						// Встановлюємо значення у текстове поле medit
						medit.setText(hexColor.substring(1));
					}
				}
				
				@Override
				public void onStartTrackingTouch(SeekBar seekBar) {hsvc = true;}
				
				@Override
				public void onStopTrackingTouch(SeekBar seekBar) {hsvc = false;}
			};
			
			// Призначаємо прослуховувачі для кожного повзунка
			hue.setOnSeekBarChangeListener(hsvChangeListener);
			satur.setOnSeekBarChangeListener(hsvChangeListener);
			val.setOnSeekBarChangeListener(hsvChangeListener);
			alpha.setOnSeekBarChangeListener(hsvChangeListener);
		}
		
		
		private void fillmonet(View inflate, final AlertDialog dialog2) {
			Button n110 = inflate.findViewById(R.id.n110);
			Button n150 = inflate.findViewById(R.id.n150);
			Button n1100 = inflate.findViewById(R.id.n1100);
			Button n1200 = inflate.findViewById(R.id.n1200);
			Button n1300 = inflate.findViewById(R.id.n1300);
			Button n1400 = inflate.findViewById(R.id.n1400);
			Button n1500 = inflate.findViewById(R.id.n1500);
			Button n1600 = inflate.findViewById(R.id.n1600);
			Button n1700 = inflate.findViewById(R.id.n1700);
			Button n1800 = inflate.findViewById(R.id.n1800);
			Button n1900 = inflate.findViewById(R.id.n1900);
			Button n210 = inflate.findViewById(R.id.n210);
			Button n250 = inflate.findViewById(R.id.n250);
			Button n2100 = inflate.findViewById(R.id.n2100);
			Button n2200 = inflate.findViewById(R.id.n2200);
			Button n2300 = inflate.findViewById(R.id.n2300);
			Button n2400 = inflate.findViewById(R.id.n2400);
			Button n2500 = inflate.findViewById(R.id.n2500);
			Button n2600 = inflate.findViewById(R.id.n2600);
			Button n2700 = inflate.findViewById(R.id.n2700);
			Button n2800 = inflate.findViewById(R.id.n2800);
			Button n2900 = inflate.findViewById(R.id.n2900);
			Button a110 = inflate.findViewById(R.id.a110);
			Button a150 = inflate.findViewById(R.id.a150);
			Button a1100 = inflate.findViewById(R.id.a1100);
			Button a1200 = inflate.findViewById(R.id.a1200);
			Button a1300 = inflate.findViewById(R.id.a1300);
			Button a1400 = inflate.findViewById(R.id.a1400);
			Button a1500 = inflate.findViewById(R.id.a1500);
			Button a1600 = inflate.findViewById(R.id.a1600);
			Button a1700 = inflate.findViewById(R.id.a1700);
			Button a1800 = inflate.findViewById(R.id.a1800);
			Button a1900 = inflate.findViewById(R.id.a1900);
			Button a210 = inflate.findViewById(R.id.a210);
			Button a250 = inflate.findViewById(R.id.a250);
			Button a2100 = inflate.findViewById(R.id.a2100);
			Button a2200 = inflate.findViewById(R.id.a2200);
			Button a2300 = inflate.findViewById(R.id.a2300);
			Button a2400 = inflate.findViewById(R.id.a2400);
			Button a2500 = inflate.findViewById(R.id.a2500);
			Button a2600 = inflate.findViewById(R.id.a2600);
			Button a2700 = inflate.findViewById(R.id.a2700);
			Button a2800 = inflate.findViewById(R.id.a2800);
			Button a2900 = inflate.findViewById(R.id.a2900);
			Button a310 = inflate.findViewById(R.id.a310);
			Button a350 = inflate.findViewById(R.id.a350);
			Button a3100 = inflate.findViewById(R.id.a3100);
			Button a3200 = inflate.findViewById(R.id.a3200);
			Button a3300 = inflate.findViewById(R.id.a3300);
			Button a3400 = inflate.findViewById(R.id.a3400);
			Button a3500 = inflate.findViewById(R.id.a3500);
			Button a3600 = inflate.findViewById(R.id.a3600);
			Button a3700 = inflate.findViewById(R.id.a3700);
			Button a3800 = inflate.findViewById(R.id.a3800);
			Button a3900 = inflate.findViewById(R.id.a3900);
			if (WTF.SDK_INT() >= 31) {
				n110.setBackgroundColor(activity.getResources().getColor(android.R.color.system_neutral1_10, activity.getTheme()));
				n150.setBackgroundColor(activity.getResources().getColor(android.R.color.system_neutral1_50, activity.getTheme()));
				n1100.setBackgroundColor(activity.getResources().getColor(android.R.color.system_neutral1_100, activity.getTheme()));
				n1200.setBackgroundColor(activity.getResources().getColor(android.R.color.system_neutral1_200, activity.getTheme()));
				n1300.setBackgroundColor(activity.getResources().getColor(android.R.color.system_neutral1_300, activity.getTheme()));
				n1400.setBackgroundColor(activity.getResources().getColor(android.R.color.system_neutral1_400, activity.getTheme()));
				n1500.setBackgroundColor(activity.getResources().getColor(android.R.color.system_neutral1_500, activity.getTheme()));
				n1600.setBackgroundColor(activity.getResources().getColor(android.R.color.system_neutral1_600, activity.getTheme()));
				n1700.setBackgroundColor(activity.getResources().getColor(android.R.color.system_neutral1_700, activity.getTheme()));
				n1800.setBackgroundColor(activity.getResources().getColor(android.R.color.system_neutral1_800, activity.getTheme()));
				n1900.setBackgroundColor(activity.getResources().getColor(android.R.color.system_neutral1_900, activity.getTheme()));
				
				n210.setBackgroundColor(activity.getResources().getColor(android.R.color.system_neutral2_10, activity.getTheme()));
				n250.setBackgroundColor(activity.getResources().getColor(android.R.color.system_neutral2_50, activity.getTheme()));
				n2100.setBackgroundColor(activity.getResources().getColor(android.R.color.system_neutral2_100, activity.getTheme()));
				n2200.setBackgroundColor(activity.getResources().getColor(android.R.color.system_neutral2_200, activity.getTheme()));
				n2300.setBackgroundColor(activity.getResources().getColor(android.R.color.system_neutral2_300, activity.getTheme()));
				n2400.setBackgroundColor(activity.getResources().getColor(android.R.color.system_neutral2_400, activity.getTheme()));
				n2500.setBackgroundColor(activity.getResources().getColor(android.R.color.system_neutral2_500, activity.getTheme()));
				n2600.setBackgroundColor(activity.getResources().getColor(android.R.color.system_neutral2_600, activity.getTheme()));
				n2700.setBackgroundColor(activity.getResources().getColor(android.R.color.system_neutral2_700, activity.getTheme()));
				n2800.setBackgroundColor(activity.getResources().getColor(android.R.color.system_neutral2_800, activity.getTheme()));
				n2900.setBackgroundColor(activity.getResources().getColor(android.R.color.system_neutral2_900, activity.getTheme()));
				
				a110.setBackgroundColor(activity.getResources().getColor(android.R.color.system_accent1_10, activity.getTheme()));
				a150.setBackgroundColor(activity.getResources().getColor(android.R.color.system_accent1_50, activity.getTheme()));
				a1100.setBackgroundColor(activity.getResources().getColor(android.R.color.system_accent1_100, activity.getTheme()));
				a1200.setBackgroundColor(activity.getResources().getColor(android.R.color.system_accent1_200, activity.getTheme()));
				a1300.setBackgroundColor(activity.getResources().getColor(android.R.color.system_accent1_300, activity.getTheme()));
				a1400.setBackgroundColor(activity.getResources().getColor(android.R.color.system_accent1_400, activity.getTheme()));
				a1500.setBackgroundColor(activity.getResources().getColor(android.R.color.system_accent1_500, activity.getTheme()));
				a1600.setBackgroundColor(activity.getResources().getColor(android.R.color.system_accent1_600, activity.getTheme()));
				a1700.setBackgroundColor(activity.getResources().getColor(android.R.color.system_accent1_700, activity.getTheme()));
				a1800.setBackgroundColor(activity.getResources().getColor(android.R.color.system_accent1_800, activity.getTheme()));
				a1900.setBackgroundColor(activity.getResources().getColor(android.R.color.system_accent1_900, activity.getTheme()));
				
				a210.setBackgroundColor(activity.getResources().getColor(android.R.color.system_accent2_10, activity.getTheme()));
				a250.setBackgroundColor(activity.getResources().getColor(android.R.color.system_accent2_50, activity.getTheme()));
				a2100.setBackgroundColor(activity.getResources().getColor(android.R.color.system_accent2_100, activity.getTheme()));
				a2200.setBackgroundColor(activity.getResources().getColor(android.R.color.system_accent2_200, activity.getTheme()));
				a2300.setBackgroundColor(activity.getResources().getColor(android.R.color.system_accent2_300, activity.getTheme()));
				a2400.setBackgroundColor(activity.getResources().getColor(android.R.color.system_accent2_400, activity.getTheme()));
				a2500.setBackgroundColor(activity.getResources().getColor(android.R.color.system_accent2_500, activity.getTheme()));
				a2600.setBackgroundColor(activity.getResources().getColor(android.R.color.system_accent2_600, activity.getTheme()));
				a2700.setBackgroundColor(activity.getResources().getColor(android.R.color.system_accent2_700, activity.getTheme()));
				a2800.setBackgroundColor(activity.getResources().getColor(android.R.color.system_accent2_800, activity.getTheme()));
				a2900.setBackgroundColor(activity.getResources().getColor(android.R.color.system_accent2_900, activity.getTheme()));
				
				a310.setBackgroundColor(activity.getResources().getColor(android.R.color.system_accent3_10, activity.getTheme()));
				a350.setBackgroundColor(activity.getResources().getColor(android.R.color.system_accent3_50, activity.getTheme()));
				a3100.setBackgroundColor(activity.getResources().getColor(android.R.color.system_accent3_100, activity.getTheme()));
				a3200.setBackgroundColor(activity.getResources().getColor(android.R.color.system_accent3_200, activity.getTheme()));
				a3300.setBackgroundColor(activity.getResources().getColor(android.R.color.system_accent3_300, activity.getTheme()));
				a3400.setBackgroundColor(activity.getResources().getColor(android.R.color.system_accent3_400, activity.getTheme()));
				a3500.setBackgroundColor(activity.getResources().getColor(android.R.color.system_accent3_500, activity.getTheme()));
				a3600.setBackgroundColor(activity.getResources().getColor(android.R.color.system_accent3_600, activity.getTheme()));
				a3700.setBackgroundColor(activity.getResources().getColor(android.R.color.system_accent3_700, activity.getTheme()));
				a3800.setBackgroundColor(activity.getResources().getColor(android.R.color.system_accent3_800, activity.getTheme()));
				a3900.setBackgroundColor(activity.getResources().getColor(android.R.color.system_accent3_900, activity.getTheme()));
			}else{
				//neutral 1
				n110.setBackgroundColor(0xFFFEFAFE);
				n150.setBackgroundColor(0xFFFAFAFA);
				n1100.setBackgroundColor(0xFFF5F5F5);
				n1200.setBackgroundColor(0xFFEEEEEE);
				n1300.setBackgroundColor(0xFFE0E0E0);
				n1400.setBackgroundColor(0xFFBDBDBD);
				n1500.setBackgroundColor(0xFF9E9E9E);
				n1600.setBackgroundColor(0xFF757575);
				n1700.setBackgroundColor(0xFF616161);
				n1800.setBackgroundColor(0xFF424242);
				n1900.setBackgroundColor(0xFF212121);
				
				//neutral 2
				n210.setBackgroundColor(0xFFF2F3F6);
				n250.setBackgroundColor(0xFFECEFF1);
				n2100.setBackgroundColor(0xFFCFD8DC);
				n2200.setBackgroundColor(0xFFB0BEC5);
				n2300.setBackgroundColor(0xFF90A4AE);
				n2400.setBackgroundColor(0xFF78909C);
				n2500.setBackgroundColor(0xFF607D8B);
				n2600.setBackgroundColor(0xFF546E7A);
				n2700.setBackgroundColor(0xFF455A64);
				n2800.setBackgroundColor(0xFF37474F);
				n2900.setBackgroundColor(0xFF263238);
				
				//accent 1
				a110.setBackgroundColor(0xFFE9F6FB);
				a150.setBackgroundColor(0xFFE0F2F1);
				a1100.setBackgroundColor(0xFFB2DFDB);
				a1200.setBackgroundColor(0xFF80CBC4);
				a1300.setBackgroundColor(0xFF4DB6AC);
				a1400.setBackgroundColor(0xFF26A69A);
				a1500.setBackgroundColor(0xFF009688);
				a1600.setBackgroundColor(0xFF00897B);
				a1700.setBackgroundColor(0xFF00796B);
				a1800.setBackgroundColor(0xFF00695C);
				a1900.setBackgroundColor(0xFF004D40);
				
				//accent 2
				a210.setBackgroundColor(0xFFF2FFFC);
				a250.setBackgroundColor(0xFFDAF7F3);
				a2100.setBackgroundColor(0xFFCCE8E4);
				a2200.setBackgroundColor(0xFFB0CCC8);
				a2300.setBackgroundColor(0xFF96B1AD);
				a2400.setBackgroundColor(0xFF7B9693);
				a2500.setBackgroundColor(0xFF617B78);
				a2600.setBackgroundColor(0xFF4A6360);
				a2700.setBackgroundColor(0xFF324B49);
				a2800.setBackgroundColor(0xFF1C3532);
				a2900.setBackgroundColor(0xFF051F1D);
				
				//accent 3
				a310.setBackgroundColor(0xFFFCFCFF);
				a350.setBackgroundColor(0xFFE9F1FF);
				a3100.setBackgroundColor(0xFFCFE5FF);
				a3200.setBackgroundColor(0xFFAFC9E7);
				a3300.setBackgroundColor(0xFF94AECB);
				a3400.setBackgroundColor(0xFF7A93AF);
				a3500.setBackgroundColor(0xFF607893);
				a3600.setBackgroundColor(0xFF48617B);
				a3700.setBackgroundColor(0xFF304962);
				a3800.setBackgroundColor(0xFF18324A);
				a3900.setBackgroundColor(0xFF001D34);
			}
			
			//Neutral 1
			n110.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__n1010");}dialog2.dismiss();}
			});
			n150.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__n1050");}dialog2.dismiss();}
			});
			n1100.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__n1100");}dialog2.dismiss();}
			});
			n1200.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__n1200");}dialog2.dismiss();}
			});
			n1300.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__n1300");}dialog2.dismiss();}
			});
			n1400.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__n1400");}dialog2.dismiss();}
			});
			n1500.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__n1500");}dialog2.dismiss();}
			});
			n1600.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__n1600");}dialog2.dismiss();}
			});
			n1700.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__n1700");}dialog2.dismiss();}
			});
			n1800.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__n1800");}dialog2.dismiss();}
			});
			n1900.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__n1900");}dialog2.dismiss();}
			});
			//Neutral 2
			n210.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__n2010");}dialog2.dismiss();}
			});
			n250.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__n2050");}dialog2.dismiss();}
			});
			n2100.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__n2100");}dialog2.dismiss();}
			});
			n2200.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__n2200");}dialog2.dismiss();}
			});
			n2300.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__n2300");}dialog2.dismiss();}
			});
			n2400.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__n2400");}dialog2.dismiss();}
			});
			n2500.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__n2500");}dialog2.dismiss();}
			});
			n2600.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__n2600");}dialog2.dismiss();}
			});
			n2700.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__n2700");}dialog2.dismiss();}
			});
			n2800.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__n2800");}dialog2.dismiss();}
			});
			n2900.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__n2900");}dialog2.dismiss();}
			});
			//Accent 1
			a110.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__a1010");}dialog2.dismiss();}
			});
			a150.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__a1050");}dialog2.dismiss();}
			});
			a1100.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__a1100");}dialog2.dismiss();}
			});
			a1200.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__a1200");}dialog2.dismiss();}
			});
			a1300.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__a1300");}dialog2.dismiss();}
			});
			a1400.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__a1400");}dialog2.dismiss();}
			});
			a1500.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__a1500");}dialog2.dismiss();}
			});
			a1600.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__a1600");}dialog2.dismiss();}
			});
			a1700.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__a1700");}dialog2.dismiss();}
			});
			a1800.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__a1800");}dialog2.dismiss();}
			});
			a1900.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__a1900");}dialog2.dismiss();}
			});
			//Accent 2
			a210.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__a2010");}dialog2.dismiss();}
			});
			a250.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__a2050");}dialog2.dismiss();}
			});
			a2100.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__a2100");}dialog2.dismiss();}
			});
			a2200.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__a2200");}dialog2.dismiss();}
			});
			a2300.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__a2300");}dialog2.dismiss();}
			});
			a2400.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__a2400");}dialog2.dismiss();}
			});
			a2500.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__a2500");}dialog2.dismiss();}
			});
			a2600.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__a2600");}dialog2.dismiss();}
			});
			a2700.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__a2700");}dialog2.dismiss();}
			});
			a2800.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__a2800");}dialog2.dismiss();}
			});
			a2900.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__a2900");}dialog2.dismiss();}
			});
			//Accent 3
			a310.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__a3010");}dialog2.dismiss();}
			});
			a350.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__a3050");}dialog2.dismiss();}
			});
			a3100.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__a3100");}dialog2.dismiss();}
			});
			a3200.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__a3200");}dialog2.dismiss();}
			});
			a3300.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__a3300");}dialog2.dismiss();}
			});
			a3400.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__a3400");}dialog2.dismiss();}
			});
			a3500.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__a3500");}dialog2.dismiss();}
			});
			a3600.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__a3600");}dialog2.dismiss();}
			});
			a3700.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__a3700");}dialog2.dismiss();}
			});
			a3800.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__a3800");}dialog2.dismiss();}
			});
			a3900.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {if (listener != null) {
						listener.onColorPicked("m__a3900");}dialog2.dismiss();}
			});
			
			
		}
		
		
		
		//}	
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
package com.a525team.weekbrowser;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class ColorPickerDialog {
    private final Context context;
    private String hexRed = "00";
    private String hexGreen = "00";
    private String hexBlue = "00";
    private ColorPickerListener listener;

    public interface ColorPickerListener {
        void onColorPicked(String colorHex);
    }

    public ColorPickerDialog(Context context) {
        this.context = context;
    }

    public void setColorPickerListener(ColorPickerListener listener) {
        this.listener = listener;
    }

    public void show(String colhex) {
        // Перевірка на формат Monet або шістнадцятковий код
        if (colhex.startsWith("m__")) {
            // Обробка кольору Monet
            // TODO: Реалізуйте перетворення кольору Monet у шістнадцятковий формат
            // Наприклад: колір = processColor(colhex, false, isAndroid12OrHigher);
            // Встановити hexRed, hexGreen, hexBlue на відповідні значення
            hexRed = "00"; // Змінити на отримане значення
            hexGreen = "00"; // Змінити на отримане значення
            hexBlue = "00"; // Змінити на отримане значення
        } else {
            // Обробка шістнадцяткового коду
            hexRed = colhex.substring(2, 4);
            hexGreen = colhex.substring(4, 6);
            hexBlue = colhex.substring(6, 8);
        }

        final AlertDialog dialog2 = new AlertDialog.Builder(context).create();
        View inflate = LayoutInflater.from(context).inflate(R.layout.colorpick, null);
        dialog2.setView(inflate);
        dialog2.setTitle("Color");

        SeekBar red = inflate.findViewById(R.id.red);
        SeekBar green = inflate.findViewById(R.id.green);
        SeekBar blue = inflate.findViewById(R.id.blue);
        Button ok = inflate.findViewById(R.id.ok);
        Button dismiss = inflate.findViewById(R.id.dismiss);
        LinearLayout preview = inflate.findViewById(R.id.preview);

        // Встановити початкові значення SeekBar згідно з поточним кольором
        red.setProgress(Integer.parseInt(hexRed, 16));
        green.setProgress(Integer.parseInt(hexGreen, 16));
        blue.setProgress(Integer.parseInt(hexBlue, 16));
        preview.setBackgroundColor(Color.parseColor("#" + hexRed + hexGreen + hexBlue));

        SeekBar.OnSeekBarChangeListener colorChangeListener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                hexRed = String.format("%02X", red.getProgress());
                hexGreen = String.format("%02X", green.getProgress());
                hexBlue = String.format("%02X", blue.getProgress());
                preview.setBackgroundColor(Color.parseColor("#" + hexRed + hexGreen + hexBlue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        };

        red.setOnSeekBarChangeListener(colorChangeListener);
        green.setOnSeekBarChangeListener(colorChangeListener);
        blue.setOnSeekBarChangeListener(colorChangeListener);

        dismiss.setOnClickListener(view -> dialog2.dismiss());

        ok.setOnClickListener(view -> {
            String selectedColorHex = "FF" + hexRed + hexGreen + hexBlue;
            if (listener != null) {
                listener.onColorPicked(selectedColorHex);
            }
            dialog2.dismiss();
        });

        dialog2.show();

        // Ініціалізація кольорів Monet
            fillmonet(inflate, dialog2);
        
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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        n110.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral1_10, context.getTheme()));
        n150.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral1_50, context.getTheme()));
        n1100.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral1_100, context.getTheme()));
        n1200.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral1_200, context.getTheme()));
        n1300.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral1_300, context.getTheme()));
        n1400.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral1_400, context.getTheme()));
        n1500.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral1_500, context.getTheme()));
        n1600.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral1_600, context.getTheme()));
        n1700.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral1_700, context.getTheme()));
        n1800.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral1_800, context.getTheme()));
        n1900.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral1_900, context.getTheme()));

        n210.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral2_10, context.getTheme()));
        n250.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral2_50, context.getTheme()));
        n2100.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral2_100, context.getTheme()));
        n2200.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral2_200, context.getTheme()));
        n2300.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral2_300, context.getTheme()));
        n2400.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral2_400, context.getTheme()));
        n2500.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral2_500, context.getTheme()));
        n2600.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral2_600, context.getTheme()));
        n2700.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral2_700, context.getTheme()));
        n2800.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral2_800, context.getTheme()));
        n2900.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral2_900, context.getTheme()));

        a110.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent1_10, context.getTheme()));
        a150.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent1_50, context.getTheme()));
        a1100.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent1_100, context.getTheme()));
        a1200.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent1_200, context.getTheme()));
        a1300.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent1_300, context.getTheme()));
        a1400.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent1_400, context.getTheme()));
        a1500.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent1_500, context.getTheme()));
        a1600.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent1_600, context.getTheme()));
        a1700.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent1_700, context.getTheme()));
        a1800.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent1_800, context.getTheme()));
        a1900.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent1_900, context.getTheme()));

        a210.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent2_10, context.getTheme()));
        a250.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent2_50, context.getTheme()));
        a2100.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent2_100, context.getTheme()));
        a2200.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent2_200, context.getTheme()));
        a2300.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent2_300, context.getTheme()));
        a2400.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent2_400, context.getTheme()));
        a2500.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent2_500, context.getTheme()));
        a2600.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent2_600, context.getTheme()));
        a2700.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent2_700, context.getTheme()));
        a2800.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent2_800, context.getTheme()));
        a2900.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent2_900, context.getTheme()));

        a310.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent3_10, context.getTheme()));
        a350.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent3_50, context.getTheme()));
        a3100.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent3_100, context.getTheme()));
        a3200.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent3_200, context.getTheme()));
        a3300.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent3_300, context.getTheme()));
        a3400.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent3_400, context.getTheme()));
        a3500.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent3_500, context.getTheme()));
        a3600.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent3_600, context.getTheme()));
        a3700.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent3_700, context.getTheme()));
        a3800.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent3_800, context.getTheme()));
        a3900.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent3_900, context.getTheme()));
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





}
package com.a525team.weekbrowser;

import android.view.animation.*;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.content.Context;
import android.provider.Settings;

public class Animator2 {
	public static void anim(Context context, View v, int t, int d){
        ExtendedDataHolder dh = ExtendedDataHolder.getInstance();
        if ((Settings.Global.getFloat(
        context.getContentResolver(), 
        Settings.Global.ANIMATOR_DURATION_SCALE, 
        1.0f) != 0.0f) && dh.getData("batsav").equals("0")) {
		String p;
		String i;
		switch(t){
			case 0:
			p = dh.getData("listanimp");
			i = dh.getData("listanimi");
			setanim(context, p,i,v,d);
			break;
            	case 1:
			p = dh.getData("bpanimp");
			i = dh.getData("bpanimi");
			setanim(context, p,i,v,d);
			break;
            	case 2:
			p = dh.getData("spanimp");
			i = dh.getData("spanimi");
			setanim(context, p,i,v,d);
			break;
		}
        }
	}
	
	private static void setanim(Context context2, String pp, String ii, View vv, int dd){
		ObjectAnimator o = new ObjectAnimator();
		o.setTarget(vv);
		o.setDuration(dd);
		switch(pp) {
			case "0": {
				o.setPropertyName("alpha");
				o.setFloatValues((float)(0), (float)(1));
				break;
			}
			case "1": {
				o.setPropertyName("scaleX");
				o.setFloatValues((float)(0), (float)(1));
				break;
			}
			case "2": {
				o.setPropertyName("scaleY");
				o.setFloatValues((float)(0), (float)(1));
				break;
			}
			case "3": {
				o.setPropertyName("translationX");
				o.setFloatValues((float)(-SketchwareUtil.getDisplayWidthPixels(context2)), (float)(0));
				break;
			}
			case "4": {
				o.setPropertyName("translationX");
				o.setFloatValues((float)(SketchwareUtil.getDisplayWidthPixels(context2)), (float)(0));
				break;
			}
            case "5": {
				o.setPropertyName("rotation");
				o.setFloatValues((float)(-360), (float)(0));
				break;
			}
            case "6": {
				o.setPropertyName("rotation");
				o.setFloatValues((float)(-180), (float)(0));
				break;
			}
            case "7": {
				o.setPropertyName("rotation");
				o.setFloatValues((float)(-90), (float)(0));
				break;
			}
            case "8": {
				o.setPropertyName("rotation");
				o.setFloatValues((float)(90), (float)(0));
				break;
			}
            case "9": {
				o.setPropertyName("rotation");
				o.setFloatValues((float)(180), (float)(0));
				break;
			}
            case "10": {
				o.setPropertyName("rotation");
				o.setFloatValues((float)(360), (float)(0));
				break;
			}
            case "11": {
            	ObjectAnimator o2 = new ObjectAnimator();
                o2.setTarget(vv);
				o2.setDuration(dd);
				o2.setPropertyName("scaleY");
				o2.setFloatValues((float)(0), (float)(1));
                iii(ii, o2, dd);
                o2.start();
				o.setPropertyName("scaleX");
				o.setFloatValues((float)(0), (float)(1));
				break;
			}
            default: {}
		}
		if(!pp.equals("12")){iii(ii, o, dd);
		o.start();}
	}

private static void iii(String ii, ObjectAnimator o, int dd){
switch(ii) {
			case "0": {
				o.setInterpolator(new LinearInterpolator());
				break;
			}
			case "1": {
				o.setInterpolator(new AccelerateInterpolator());
				break;
			}
			case "2": {
				o.setInterpolator(new DecelerateInterpolator());
				break;
			}
			case "3": {
				o.setInterpolator(new AccelerateDecelerateInterpolator());
				break;
			}
			case "4": {
				o.setInterpolator(new BounceInterpolator());
                		o.setDuration(dd*3);
				break;
			}
		}
}





}

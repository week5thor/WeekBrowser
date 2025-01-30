package com.a525team.weekbrowser;

import android.view.animation.*;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.content.Context;

public class Animator2 {
	public static void anim(Context context, View v, int t, int d){
	ExtendedDataHolder dh = ExtendedDataHolder.getInstance();
		String p;
		String i;
		switch(t){
			case 0:
			p = dh.getData("listanimp");
			i = dh.getData("listanimi");
			setanim(context, p,i,v,d);
			break;
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
				o.setPropertyName("rotation");
				o.setFloatValues((float)(-360), (float)(0));
				break;
			}
			case "4": {
				o.setPropertyName("translationX");
				o.setFloatValues((float)(-SketchwareUtil.getDisplayWidthPixels(context2)), (float)(0));
				break;
			}
			case "5": {
				o.setPropertyName("translationX");
				o.setFloatValues((float)(SketchwareUtil.getDisplayWidthPixels(context2)), (float)(0));
				break;
			}
		}
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
		o.start();
	}
}

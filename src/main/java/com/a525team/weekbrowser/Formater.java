package com.a525team.weekbrowser;

public class Formater {
    public static String kmgt(double n){
        if(n>=1e+15){
            n = Math.round(n/1e+13)*1e+13;
            return String.valueOf(n/1e+15)+" P";
        }
        if(n>=1e+12){
            n = Math.round(n/1e+10)*1e+10;
            return String.valueOf(n/1e+12)+" T";
        }
        if(n>=1e+9){
            n = Math.round(n/1e+7)*1e+7;
            return String.valueOf(n/1e+9)+" G";
        }
        if(n>=1e+6){
            n = Math.round(n/1e+4)*1e+4;
            return String.valueOf(n/1e+6)+" M";
        }
        if(n>=1e+3){
            n = Math.round(n/10.)*10.;
            return String.valueOf(n/1e+3)+" k";
        }
        if(n>=1){
            n = Math.round(n/0.01)*0.01;
            return String.valueOf(n)+" ";
        }
        if(n>=1e-3){
            n = Math.round(n/1e-5)*1e-5;
            return String.valueOf(n/1e-3)+" m";
        }
        if(n>=1e-6){
            n = Math.round(n/1e-8)*1e-8;
            return String.valueOf(n/1e-6)+" μ";
        }
        if(n>=1e-9){
            n = Math.round(n/1e-11)*1e-11;
            return String.valueOf(n/1e-9)+" n";
        }
        if(n>=1e-12){
            n = Math.round(n/1e-14)*1e-14;
            return String.valueOf(n/1e-12)+" p";
        }
        if(n>=1e-15){
            n = Math.round(n/1e-17)*1e-17;
            return String.valueOf(n/1e-15)+" f";
        }
        else return String.valueOf(n);
    }
    
    public static String kmgt(long n){
        if(n>=1e+15){
            n = Math.round(n/(int)1e+13)*(int)1e+13;
            return String.valueOf(n/1e+15)+" P";
        }
        if(n>=1e+12){
            n = Math.round(n/(int)1e+10)*(int)1e+10;
            return String.valueOf(n/1e+12)+" T";
        }
        if(n>=1e+9){
            n = Math.round(n/(int)1e+7)*(int)1e+7;
            return String.valueOf(n/1e+9)+" G";
        }
        if(n>=1e+6){
            n = Math.round(n/(int)1e+4)*(int)1e+4;
            return String.valueOf(n/1e+6)+" M";
        }
        if(n>=1e+3){
            n = Math.round(n/10)*10;
            return String.valueOf(n/1e+3)+" k";
        }
        else return String.valueOf(n)+" ";
    }
    
    public static String kimgt(long n) {
    double value = n;
    String[] units = {" ", "Ki", "Mi", "Gi", "Ti", "Pi"};
    int unitIndex = 0;

    while (value >= 1024 && unitIndex < units.length - 1) {
        value /= 1024.0;
        unitIndex++;
    }

    return String.format("%.2f %s", value, units[unitIndex]);
}

    
}









package com.a525team.weekbrowser;

public class Formater {
	
	public static String kimgt(long n) {
		double value = n;
		String[] units = {" ", "Ki", "Mi", "Gi", "Ti", "Pi", "Ei"};
		int unitIndex = 0;
		
		while (value >= 1024 && unitIndex < units.length - 1) {
			value /= 1024.0;
			unitIndex++;
		}
		return String.format("%.2f %s", value, units[unitIndex]);
	}
	
/*	public static String kmgt(double n) {
		double value = n * 1e+30;
		String[] units = {"q", "r", "y", "z", "a", "f", "p", "n", "μ", "m", "", "K", "M", "G", "T", "P", "E", "Z", "Y", "R", "Q"};
		int unitIndex = 0;
		
		while (value >= 1024 && unitIndex < units.length - 1) {
			value /= 1024.0;
			unitIndex++;
		}
		return String.format("%.2f %s", value, units[unitIndex]);
	}
    //Закоментував, оскільки він ніде поки що не використовується
	*/
	public static String kmgt(long n) {
		double value = n;
		String[] units = {" ", "K", "M", "G", "T", "P", "E"};
		int unitIndex = 0;
		
		while (value >= 1000 && unitIndex < units.length - 1) {
			value /= 1000.0;
			unitIndex++;
		}
		
        if(unitIndex == 0)
        return String.valueOf((int)n);
        else
		return String.format("%.2f %s", value, units[unitIndex]);
	}
	
	public static String shrink(String x, int n) {
		if (x.length() > n)
		return x.substring(0, n);
		return x;
	}
	
	public static String shrinkddd(String x, int n) {
		if (x.length() > n)
		return x.substring(0, n) + "...";
		return x;
	}
    
    public static String rshrinkddd(String x, int n) {
        int m = x.length();
		if (m > n)
		return "..." + x.substring(m-n);
		return x;
	}
}









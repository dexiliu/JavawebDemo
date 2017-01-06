package util;

import java.util.Locale;
import java.util.ResourceBundle;

public class MyConfigUtil {
	private static ResourceBundle rb = ResourceBundle.getBundle("application",
			new Locale("zh", "CN")); 

	public static String getValue(String key) {
		return rb.getString(key);
	}

	public static int getIntValue(String key) {
		return Integer.parseInt(getValue(key));
	}
	
	public static long getLongValue(String key) {
		return Long.parseLong(getValue(key));
	}
}

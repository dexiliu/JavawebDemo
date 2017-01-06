package util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期处理工具类 。
 */
public class MyDateUtil {

	/**
	 * 用指定的格式的字符串生成日期对象 。<br>
	 * Format eg. EEE, yyyy-MM(M)-dd HH:mm:ss(S) Z
	 */
	public static Date getDate(String strDate, String format) {
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			date = sdf.parse(strDate);
		} catch (Exception ex) {
			date = new Date();
		}

		return date;
	}
	/**
	 * 用指定的格式的字符串生成日期字符串 。<br>
	 * Format eg. EEE, yyyy-MM(M)-dd HH:mm:ss(S) Z
	 */
	public static String getStr(Date date, String format) {
		if (date != null) {
			SimpleDateFormat dFormat = new SimpleDateFormat(format);
			return dFormat.format(date);

		} else {
			return "";
		}
	}
	
	/**
	 * 获取相对时间，时间差值可为负值 。
	 */
	public static Date getRelativeDate(Date date, long milliseconds) {
		if (date == null) return null;
		
		return new Date(date.getTime() + milliseconds);
	}

}

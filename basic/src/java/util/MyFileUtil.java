package util;

import java.text.DecimalFormat;

/**
 * 文件处理工具类 。
 */
public class MyFileUtil {

	/**
	 * 获取带单位的文件名，单位会自动显示为合适的值，如B、KB、MB等
	 * @param size 文件字节大小
	 */
	public static String readableFileSize(long size) {
		if(size <= 0) return "0";
	    final String[] units = new String[] { "B", "KB", "MB", "GB", "TB" };
	    int digitGroups = (int) (Math.log10(size)/Math.log10(1024));
	    return new DecimalFormat("#,##0.#").format(size/Math.pow(1024, digitGroups)) + " " + units[digitGroups];
	}
}

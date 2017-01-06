package util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * 字符串处理工具类 。<p>
 */
public class MyStringUtil {
	/**
	 * 从目标字符串中获取匹配的部分 。
	 */
	public static String getRegexMatch(String regex, String str) {
		List<String> resultList = getRegexMatchList(regex, str);
		
		return resultList.isEmpty() ? "" : resultList.get(0);
	}
	
	/**
	 * 从目标字符串中获取所有匹配的部分 。
	 */
	public static List<String> getRegexMatchList(String regex, String str) {
		List<String> resultList = new ArrayList<String>();
		if (StringUtils.isNotBlank(str)) {
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(str);
			while (m.find()) {
				resultList.add(m.group());
			}
		}
		
		return resultList;
	}
	
	/**
	 * 从目匹配的字符串中定点取需要的部分 。
	 */
	public static String getRegexGroup(String regex, String str, int id) {
		String resultStr = "";
		if (StringUtils.isNotBlank(str)) {
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(str);
			if (m.find()) {
				resultStr = m.group(id);
			}	
		}
		
		return resultStr;		
	}
	
	/**
	 * 用于模糊搜索。
	 */
	public static String quoteLike(String str) {
		return StringUtils.isNotBlank(str) ? "%" + str.trim() + "%" : "%";
	}
	
	public static String trim(String str) {
		return StringUtils.isNotBlank(str) ? str.trim() : "";
	}
}

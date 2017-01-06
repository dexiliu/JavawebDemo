package bean.querypage;

/**
 * 继承page对象，增加更多的查询条件 。
 */
public class UserQp extends Page {

	/** 用于在用户名和显示名中搜索 */
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

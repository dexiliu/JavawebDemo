package action.base;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.struts2.ServletActionContext;
import org.codehaus.jackson.map.ObjectMapper;

import action.ShiroDbRealm;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BasicAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	/** 提示信息专用 */
	public String message;
	
	/** 用于存放错误信息 */
	public Map<String, String> errorMap = new HashMap<String, String>();
	
	/** 获取request对象 */
	public HttpServletRequest getRequest() {
		return (HttpServletRequest) ActionContext.getContext().get(
				ServletActionContext.HTTP_REQUEST);
	}
	
	/** 获取response对象 */
	public HttpServletResponse getResponse() {
		return (HttpServletResponse) ActionContext.getContext().get(
				ServletActionContext.HTTP_RESPONSE);
	}
	
	/** 获取session对象 */
	public Map<String, Object> getSession() {
		return ActionContext.getContext().getSession();
	}

	/** 将对象转化成jason串 */
	public void writeJson(Object value) {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		
		ObjectMapper mapper = new ObjectMapper();
		DateFormat df =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		mapper.setDateFormat(df);
		
		try {
		  	mapper.writeValue(response.getWriter(), value);
		}catch (Exception e) {
		    e.printStackTrace();
		}
    }
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, String> getErrorMap() {
		return errorMap;
	}

	public void setErrorMap(Map<String, String> errorMap) {
		this.errorMap = errorMap;
	}
	
	/** 获取当前用户id */
	public int getUserId() {
		return ((ShiroDbRealm.ShiroUser) SecurityUtils.getSubject()
				.getPrincipal()).getId();
	}
	
}
 
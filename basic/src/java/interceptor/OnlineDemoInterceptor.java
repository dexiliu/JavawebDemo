package interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 自定义拦截器：为不影响用户体验，在线演示禁用了此操作。
 */
public class OnlineDemoInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = -1689526894183598040L;
	private static Logger log = Logger.getLogger(OnlineDemoInterceptor.class);

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String path = request.getRequestURI();
		log.info(path);
		
		if (path.endsWith("/permission/save.do") ||
			path.endsWith("/permission/delete.do") ||
			path.endsWith("/role/save.do") || 
			path.endsWith("/role/delete.do") ||
			path.endsWith("/user/save.do") ||
			path.endsWith("/user/delete.do")) {
			
			request.setAttribute("message", "为不影响用户体验，在线演示禁用了此操作。<br/>" +
			"本地运行时注释掉struts.xml中的 &lt;interceptor-ref name=\"onlineDemo\" /&gt;即可。");
			return "message";
		}
		
		return ai.invoke();
	}
}

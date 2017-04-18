package zyf.interceptor;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import zyf.entity.User;

/**
 * 判断用户是否登录的拦截器
 * @author OracleOAEC
 *
 */
public class IsLoginInterceptor2 extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user =(User) session.getAttribute("user");
		if(user!=null){
			return invocation.invoke();
		}else{
			return "login";
		}
	}
	
	
}

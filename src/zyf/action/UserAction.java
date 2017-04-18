package zyf.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import zyf.entity.User;
import zyf.service.IUserService;
import zyf.service.impl.UserServiceImpl;

public class UserAction extends ActionSupport{
	private static final long serialVersionUID = 3790820111022390130L;
	private final String  SUCCESS = "success";
	private final String  FAILED = "failed";

	@Override
	public String execute() throws Exception {
		return null;
		}

	/**
	 * 用户登录
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception{
		

		HttpServletRequest req = ServletActionContext.getRequest();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String txtcode = req.getParameter("txtcode");
		String id = req.getParameter("");
		
		User user = new User(username,password,txtcode);
		
		IUserService ius = new UserServiceImpl();
		User loginUser = ius.login(user);
		HttpSession session = req.getSession();
		if(loginUser!=null){
			session.setAttribute("user", loginUser);
			return SUCCESS;
		}else{
			
			return FAILED;
		}
		
	
	}
}

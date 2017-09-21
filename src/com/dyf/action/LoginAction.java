package com.dyf.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.dyf.model.STable;
import com.dyf.service.IUserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

public class LoginAction extends BaseAction{
   private IUserService userService;
   public IUserService getUserService() {
	return userService;
}
   public void setUserService(IUserService userService) {
	this.userService = userService;
}
   private String sid;
   private String spassword;
   public String getSid() {
	return sid;
}
   public void setSid(String sid) {
	this.sid = sid;
}
   public String getSpassword() {
	return spassword;
}
   public void setSpassword(String spassword) {
	this.spassword = spassword;
}
   // 显示登录页面
	@Override
	public String execute() throws Exception {
		return LOGIN;
	} 
	// 处理登录请求
	@InputConfig(resultName = LOGIN)
	public String check() throws Exception {
		/*HttpServletRequest request = ServletActionContext.getRequest();*/
		STable stable = userService.findByLogin(sid, spassword);
		if (stable != null) {
			// 放置stable对象到session
			ActionContext.getContext().getSession().put(USER_IN_SESSION, stable);
			// 重定向到主页
			return "main";
		}
		putContext("msg","用户名或密码错误");
		return LOGIN;
	}
	
}

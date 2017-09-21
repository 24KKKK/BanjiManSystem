package com.dyf.service;

import com.dyf.model.STable;

public interface IUserService extends IBaseService<STable> {
	    // <!-- 如果不需要事务service层方法名必须以：get和find开头 -->
		boolean findByName(String sid);
		// 验证登录
		// boolean还是对象User好？后续页面需要用户名，id
		STable findByLogin(String sid, String spassword);
}

package com.dyf.service.impl;

import java.util.List;

import com.dyf.model.STable;
import com.dyf.service.IUserService;

public class UserServiceImpl extends BaseServiceImpl<STable> implements IUserService{

	@Override
	public boolean findByName(String sid) {
	    // String hql="select o from Employee o where o.name=?";
	    // 性能高一些
		String hql = "select count(o) from STable o where o.sid=?";				
		List<Long> list = baseDao.findByHql(hql, sid);
		// if(list.size()>0){//错误的写法
		// count无论如果都有返回值:0-n
		if (list.get(0) > 0) {// ("{\"valid\":false}");用户名重复
			return false;
		}			
		return true;
	}

	@Override
	public STable findByLogin(String sid, String spassword) {
		String hql = "select o from STable o where o.sid=? and o.spassword=?";
		List<STable> list = baseDao.findByHql(hql, sid, spassword);
		if (list.size() > 0) {// 必须判断size
			return list.get(0);
		}
		return null;
	}

}

package com.dyf.service.impl;

import java.util.List;

import com.dyf.model.STable;
import com.dyf.service.IBanJiService;
import com.dyf.service.IStudentService;

public class StudentServiceImpl extends BaseServiceImpl<STable> implements IStudentService{

	@Override
	public boolean findByName(String id) {
		String hql = "select count(o) from STable o where o.id=?";				
		List<Long> list = baseDao.findByHql(hql, id);
	
		if (list.get(0) > 0) {// ("{\"valid\":false}");用户名重复
			return false;
		}			
		return true;
	}

}

package com.dyf.service;

import com.dyf.model.STable;

public interface IStudentService extends IBaseService<STable> {
	public boolean findByName(String id);
}

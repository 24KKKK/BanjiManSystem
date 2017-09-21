package com.dyf.service;

import com.dyf.model.BTable;

public interface IBanJiService extends IBaseService<BTable> {
	
	public boolean findByName(String id);
	
}

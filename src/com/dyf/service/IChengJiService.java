package com.dyf.service;

import com.dyf.model.CTable;


public interface IChengJiService extends IBaseService<CTable> {
	boolean findByName(Long id);
}

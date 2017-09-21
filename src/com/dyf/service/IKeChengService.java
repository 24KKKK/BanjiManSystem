package com.dyf.service;

import java.util.List;

import com.dyf.model.KTable;

public interface IKeChengService extends IBaseService<KTable> {

	boolean findByName(String id);
}

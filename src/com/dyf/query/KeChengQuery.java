package com.dyf.query;

import org.apache.commons.lang.StringUtils;

import com.dyf.model.KTable;


/**
 * 
 * 子类自己的查询条件：课程名
 *
 */
public class KeChengQuery extends BaseQuery {
	
	private String kname;

	public String getKname() {
		return kname;
	}

	public void setKname(String kname) {
		this.kname = kname;
	}

	public KeChengQuery() {
		super(KTable.class.getName());
	}

	@Override
	protected void addWhere() {
		if (StringUtils.isNotBlank(kname)) 
		{
			addCondition("o.kname like ?", "%" + kname + "%");
		}
	}
}

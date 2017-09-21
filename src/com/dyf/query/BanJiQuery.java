package com.dyf.query;

import org.apache.commons.lang.StringUtils;

import com.dyf.model.BTable;


/**
 * 
 * 子类自己的查询条件：班级名
 *
 */
public class BanJiQuery extends BaseQuery {
	
	private String bname;

	
	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public BanJiQuery() {
		super(BTable.class.getName());
	}

	@Override
	protected void addWhere() {
		if (StringUtils.isNotBlank(bname)) 
		{
			addCondition("o.bname like ?", "%" + bname + "%");
		}
	}
}

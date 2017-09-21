package com.dyf.query;

import org.apache.commons.lang.StringUtils;

import com.dyf.model.STable;

/**
 * 
 * 子类自己的查询条件：学生名
 *
 */
public class StudentQuery extends BaseQuery{
 
	private String sname;
	
	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public StudentQuery() {
		super(STable.class.getName());
	}

	@Override
	protected void addWhere() {
		if(StringUtils.isNotBlank(sname))
		{
			addCondition("o.sname like ?", "%" + sname + "%");
		}
	}

}

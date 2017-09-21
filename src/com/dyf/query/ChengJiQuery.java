package com.dyf.query;

import org.apache.commons.lang.StringUtils;

import com.dyf.model.BTable;
import com.dyf.model.CTable;
import com.dyf.model.STable;


/**
 * 
 * 子类自己的查询条件：学生学号，课程id，成绩主键
 *
 */
public class ChengJiQuery extends BaseQuery {
	
	private Long cid;
	private String sid;
    private String kid;
	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getKid() {
		return kid;
	}

	public void setKid(String kid) {
		this.kid = kid;
	}

	public ChengJiQuery() {
		super(CTable.class.getName());
	}
	@Override
	protected void addWhere() {
		if (cid!=null&&cid!=-1) 
		{
			addCondition("o.cid like ?", "%" + cid+ "%");
		}
		if (StringUtils.isNotBlank(kid)) {
			addCondition("o.KTable.kid like ?", "%" + kid + "%");
		}
		if (StringUtils.isNotBlank(sid)) {
			addCondition("o.STable.sid like ?", "%" + sid + "%");
		}
	}
}

package com.dyf.action;

import com.dyf.model.CTable;
import com.dyf.query.ChengJiQuery;
import com.dyf.query.PageList;
import com.dyf.service.IChengJiService;
import com.dyf.service.IKeChengService;

public class ScoreAction extends CRUDAction<CTable>{

	private CTable ctable;
	private IChengJiService chengJiService;
	private IKeChengService keChengService;
	private ChengJiQuery baseQuery = new ChengJiQuery();
	private PageList pageList;
	
	public CTable getCtable() {
		return ctable;
	}

	public void setCtable(CTable ctable) {
		this.ctable = ctable;
	}

	public IChengJiService getChengJiService() {
		return chengJiService;
	}

	public void setChengJiService(IChengJiService chengJiService) {
		this.chengJiService = chengJiService;
	}

	public IKeChengService getKeChengService() {
		return keChengService;
	}

	public void setKeChengService(IKeChengService keChengService) {
		this.keChengService = keChengService;
	}

	public ChengJiQuery getBaseQuery() {
		return baseQuery;
	}

	public void setBaseQuery(ChengJiQuery baseQuery) {
		this.baseQuery = baseQuery;
	}

	public PageList getPageList() {
		return pageList;
	}

	public void setPageList(PageList pageList) {
		this.pageList = pageList;
	}

	@Override
	public CTable getModel() {
		return ctable;
	}

	@Override
	public String save() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
 
	//显示信息
	public String ChengJilist()throws Exception
	{
	  this.pageList=chengJiService.findByQuery(baseQuery);  
      putContext("allCnames", keChengService.getAll());
	  return "list";
	}
}

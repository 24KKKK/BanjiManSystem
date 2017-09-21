package com.dyf.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.dyf.model.KTable;
import com.dyf.query.KeChengQuery;
import com.dyf.query.PageList;
import com.dyf.service.IKeChengService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

public class KeChengAction  extends CRUDAction<KTable>{

	private IKeChengService keChengService;
	private KTable ktable;
	private List<KTable> kechenglist;
	private String kid;
	private KeChengQuery baseQuery=new KeChengQuery();
	private PageList pageList;
	
	public IKeChengService getKeChengService() {
		return keChengService;
	}

	public void setKeChengService(IKeChengService keChengService) {
		this.keChengService = keChengService;
	}

	public KTable getKtable() {
		return ktable;
	}

	public void setKtable(KTable ktable) {
		this.ktable = ktable;
	}

	public List<KTable> getKechenglist() {
		return kechenglist;
	}

	public void setKechenglist(List<KTable> kechenglist) {
		this.kechenglist = kechenglist;
	}

	public String getKid() {
		return kid;
	}

	public void setKid(String kid) {
		this.kid = kid;
	}
	
	public KeChengQuery getBaseQuery() {
		return baseQuery;
	}

	public void setBaseQuery(KeChengQuery baseQuery) {
		this.baseQuery = baseQuery;
	}

	public PageList getPageList() {
		return pageList;
	}

	public void setPageList(PageList pageList) {
		this.pageList = pageList;
	}

	@Override
	public KTable getModel() {
		return ktable;
	}
	//显示信息
	  public String KeChenglist()throws Exception
		{
		 //kechenglist =keChengService.getAll();
		  this.pageList=keChengService.findByQuery(baseQuery);
		 return "list";
		}
	//控制界面的跳转
	 @Override
      public String input() throws Exception {
		return INPUT;
	  }
	  public String actionUpdate() throws Exception {
		ktable=keChengService.get(kid);
		return "update" ;
	  }

	//在执行更新、添加修改后，执行RELOAD跳转到相应的信息界面；
	@Override
	@InputConfig(methodName = Action.INPUT)
	public String save() throws Exception {
		boolean bool=keChengService.findByName(ktable.getKid());
		if(bool)
		{
		keChengService.save(ktable);
		return RELOAD;
		}
		else
		return "false";
	}
	public String update() throws Exception {
		keChengService.update(ktable);
		return RELOAD;
	}
	@Override
	public String delete() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			
			if (kid != null) {
				keChengService.delete(kid);
				out.print("{\"success\":true,\"msg\":\"删除成功 \"}");
			} else {
				out.print("{\"success\":false,\"msg\":\"<font color='red'>删除失败</font>\"}");
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.print("{\"success\":false,\"msg\":\"<font color='red'>异常信息：" + e.getMessage() + "</font>\"}");
		}
		return NONE;
	}
	
}

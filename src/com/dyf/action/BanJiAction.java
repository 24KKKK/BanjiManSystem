package com.dyf.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.dyf.model.BTable;
import com.dyf.query.BanJiQuery;
import com.dyf.query.PageList;
import com.dyf.service.IBanJiService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

/*public class BanJiAction  extends BaseAction{
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
}*/
public class BanJiAction  extends CRUDAction<BTable>{

	private IBanJiService banJiService;
	private  List<BTable> btablelist;
	private BTable btable;
	private String bid;
	private BanJiQuery baseQuery = new BanJiQuery();
	private PageList pageList;
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public IBanJiService getBanJiService() {
		return banJiService;
	}
	public void setBanJiService(IBanJiService banJiService) {
		this.banJiService = banJiService;
	}
	public List<BTable> getBtablelist() {
		return btablelist;
	}
	public void setBtablelist(List<BTable> btablelist) {
		this.btablelist = btablelist;
	}
	public BTable getBtable() {
		return btable;
	}
	public void setBtable(BTable btable) {
		this.btable = btable;
	}
	
	public BanJiQuery getBaseQuery() {
		return baseQuery;
	}
	public void setBaseQuery(BanJiQuery baseQuery) {
		this.baseQuery = baseQuery;
	}
	
	public PageList getPageList() {
		return pageList;
	}
	public void setPageList(PageList pageList) {
		this.pageList = pageList;
	}
	@Override
	public BTable getModel() {
		return btable;
	}
    //显示信息
	public String Banlist()throws Exception
		{
			this.pageList = banJiService.findByQuery(baseQuery);
			return "list";
		}
	 //控制界面的跳转
		@Override
		public String input() throws Exception {
			return INPUT;
		}
		public String actionUpdate() throws Exception {
			btable=banJiService.get(bid);
			return "update" ;
		}
	//在执行更新、添加修改后，执行RELOAD跳转到相应的信息界面；
	@Override
	@InputConfig(methodName = Action.INPUT)
	public String save() throws Exception {
		boolean bool=banJiService.findByName(btable.getBid());
		if(bool)
		{
		  banJiService.save(btable);
		  return RELOAD;
		}
		else
		  return "false";
	}
	
	public String update() throws Exception {
		banJiService.update(btable);
		return RELOAD;
	}
	@Override
	public String delete() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		//System.out.println("获取的学生编号为：" +bid);
		try {
			
			if (bid != null) {
				banJiService.delete(bid);
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

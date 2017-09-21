package com.dyf.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.dyf.model.BTable;
import com.dyf.model.STable;
import com.dyf.query.PageList;
import com.dyf.query.StudentQuery;
import com.dyf.service.IBanJiService;
import com.dyf.service.IStudentService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

public class StudentAction extends  CRUDAction<STable>{
    
	private IBanJiService banJiService;
	private IStudentService studentService;	
	private  List<STable> studentlist;
	private  List<BTable> btablelist;
	private STable stable;
	private String sid;
	private StudentQuery baseQuery =new StudentQuery();
	private PageList pageList;
	
	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public IBanJiService getBanJiService() {
		return banJiService;
	}

	public void setBanJiService(IBanJiService banJiService) {
		this.banJiService = banJiService;
	}

	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}

	public List<STable> getStudentlist() {
		return studentlist;
	}

	public void setStudentlist(List<STable> studentlist) {
		this.studentlist = studentlist;
	}
	
	public List<BTable> getBtablelist() {
		return btablelist;
	}

	public void setBtablelist(List<BTable> btablelist) {
		this.btablelist = btablelist;
	}

	public STable getStable() {
		return stable;
	}

	public void setStable(STable stable) {
		this.stable = stable;
	}
	
	public PageList getPageList() {
		return pageList;
	}

	public void setPageList(PageList pageList) {
		this.pageList = pageList;
	}


	public StudentQuery getBaseQuery() {
		return baseQuery;
	}

	public void setBaseQuery(StudentQuery baseQuery) {
		this.baseQuery = baseQuery;
	}

	@Override
	public STable getModel() {
		return stable;
	}
	@Override
	@InputConfig(methodName = Action.INPUT)
	public String save() throws Exception {
		boolean bool=studentService.findByName(stable.getSid());
		if(bool)
		{
		studentService.save(stable);
		return RELOAD;
		}
		else
		return "false";
	}
	public String update() throws Exception {
		studentService.update(stable);
		return RELOAD;
	}
	@Override
	public String delete() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		System.out.println("获取的班级编号为：" +sid);
		try {
			
			if (sid != null) {
				studentService.delete(sid);
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
	//显示信息
	public String Studentlist()throws Exception
	 {
		 //studentlist =studentService.getAll();
		 //ActionContext.getContext().put("studentlist", studentlist);
		this.pageList=studentService.findByQuery(baseQuery);
		//ActionContext.getContext().put("pageList", this.pageList);
		return "list";
		}
	//输入
	@Override
	public String input() throws Exception {  
	  ActionContext.getContext().put("btablelist", banJiService.getAll());
	  return INPUT;
	}
	public String updateAction() throws Exception {
	  ActionContext.getContext().put("btablelist", banJiService.getAll());
	  stable =  studentService.get(sid);
	  return "update" ;
	}
}

package com.dyf.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.dyf.model.CTable;
import com.dyf.model.STable;
import com.dyf.query.ChengJiQuery;
import com.dyf.query.PageList;
import com.dyf.service.IChengJiService;
import com.dyf.service.IKeChengService;
import com.dyf.service.IStudentService;
import com.opensymphony.xwork2.ActionContext;


public class ChengJiAction  extends CRUDAction<CTable>{

	private IChengJiService chengJiService;
	private IStudentService studentService;
	private IKeChengService keChengService;
	private List<CTable> ctablelist;
	private CTable ctable;
	private STable stable;
	private String sid;
	private String kid;
	private Double ccj;
	private Long cid;
	private ChengJiQuery baseQuery = new ChengJiQuery();
	private PageList pageList;
	public IChengJiService getChengJiService() {
		return chengJiService;
	}
	
	public void setChengJiService(IChengJiService chengJiService) {
		this.chengJiService = chengJiService;
	}

	public List<CTable> getCtablelist() {
		return ctablelist;
	}

	public void setCtablelist(List<CTable> ctablelist) {
		this.ctablelist = ctablelist;
	}


	public CTable getCtable() {
		return ctable;
	}

	public void setCtable(CTable ctable) {
		this.ctable = ctable;
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

	public Double getCcj() {
		return ccj;
	}

	public void setCcj(Double ccj) {
		this.ccj = ccj;
	}

	public STable getStable() {
		return stable;
	}

	public void setStable(STable stable) {
		this.stable = stable;
	}

	public IStudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
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

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	@Override
	public CTable getModel() {
		return ctable;

	}
	
	@Override
	public String save() throws Exception {
		///==============================?
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		System.out.println(ccj);
		System.out.println(sid);
		System.out.println(kid);
		try {
			//ctable = chengJiService.findBystucou(stuNum, couName);
			//输入成绩
			ctable.setCcj(ccj);
			chengJiService.update(ctable);
			out.print("{\"success\":true,\"msg\":\"保存成功\"}");
			return RELOAD;
		} catch (Exception e) {
			e.printStackTrace();
			out.print("{\"success\":false,\"msg\":\"保存失败\"}");
		}
		return NONE;
		
		/*boolean bool=chengJiService.findByName(cid);
		if(bool)
		{
		chengJiService.save(ctable);
		return RELOAD;
		}
		else
		return "false";*/
	}	
	public String update() throws Exception {
		chengJiService.update(ctable);
		return RELOAD;
	}
	@Override
	public String delete() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		System.out.println("获取的学生编号为：" +cid);
		try {
			
			if (cid!= null) {
				chengJiService.delete(cid);
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
	public String ChengJilist()throws Exception
	{
	  this.pageList=chengJiService.findByQuery(baseQuery);  
	  putContext("allCnames", keChengService.getAll());
	  return "ChengJilist";
	}
	//控制跳转的方向
	@Override
	public String input() throws Exception {  
	  ActionContext.getContext().put("ctablelist", chengJiService.getAll());
	  return INPUT;
	}
	public String actionUpdate() throws Exception {
	  ActionContext.getContext().put("ctablelist", chengJiService.getAll());
	  stable =  studentService.get(sid);
	  return "update" ;
	}
	
	
}

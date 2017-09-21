package com.dyf.query;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 把查询后结果全部封装到PageList
 *
 */
public class PageList {
	// 当前页码
	private int currentPage = 1;
	// 一页显示条数
	private int pageSize = 10;
	// 总的条数
	private int totalCount;
	// 总的页数：计算出来
	private int totalPage;
	// 当前页需要显示的数据
	private List rows = new ArrayList();

	public PageList() {

	}

	public PageList(int currentPage, int pageSize, int totalCount) {
		// 1.判断是否传入负数
		this.currentPage = currentPage < 1 ? 1 : currentPage;
		this.pageSize = pageSize < 1 ? 10 : pageSize;
		this.totalCount = totalCount;
		// 2.计算总的页数
		// this.totalPage = (this.totalCount % this.pageSize) == 0 ?
		// this.totalCount / this.pageSize
		// : this.totalCount / this.pageSize + 1;
		// static double Math.ceil(double a) 返回最小的（最接近负无穷大）double
		// 值，该值大于等于参数，并等于某个整数。
		this.totalPage = (int) Math.ceil(this.totalCount * 1.0D / this.pageSize);
		// 3.判断当前页码是否大于总的页数
		this.currentPage = this.currentPage > this.totalPage ? this.totalPage : this.currentPage;
	}

	// 额外添加的方法
	public int getBegin() {
		return (currentPage - 1) * pageSize + 1;
	}

	public int getEnd() {
		int end = currentPage * pageSize;
		return end > totalCount ? totalCount : end;
	}

	public String getPage() {
		StringBuilder builder = new StringBuilder();
		// 处理首页
		if (this.currentPage == 1) {
			builder.append("<a href='javascript:;' class='nopage'>首页</a>&nbsp;");
			builder.append("<a href='javascript:;' class='nopage'>上一页</a>&nbsp;");
		} else {
			builder.append("<a href='javascript:;' class='page' onclick='go(1);'>首页</a>&nbsp;");
			builder.append("<a href='javascript:;' class='page' onclick='go(" + (currentPage - 1) + ");'>上一页</a>&nbsp;");
		}
		// 简单处理中间的分页条
		for (int i = 1; i <= this.totalPage; i++) {
			// 当前页码是否等于循环里面的i
			if (i == this.currentPage) {
				builder.append("<a href='javascript:;' class='curpage'>" + i + "</a>&nbsp;");
			} else {
				builder.append("<a href='javascript:;' class='page' onclick='go(" + i + ");'>" + i + "</a>&nbsp;");
			}
		}
		// 处理末页
		if (this.currentPage == this.totalPage) {
			builder.append("<a href='javascript:;' class='nopage'>下一页</a>&nbsp;");
			builder.append("<a href='javascript:;' class='nopage'>末页</a>&nbsp;");
		} else {
			builder.append("<a href='javascript:;' class='page' onclick='go(" + (currentPage + 1) + ");'>下一页</a>&nbsp;");
			builder.append("<a href='javascript:;' class='page' onclick='go(" + this.totalPage + ");'>末页</a>&nbsp;");
		}
		return builder.toString();
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "PageList [currentPage=" + currentPage + ", pageSize=" + pageSize + ", totalCount=" + totalCount
				+ ", totalPage=" + totalPage + ", rows=" + rows.size() + "]";
	}

}

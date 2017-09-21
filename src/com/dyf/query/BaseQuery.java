package com.dyf.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * 处理公共查询条件：一页显示条数，当前页码
 *
 */
public abstract class BaseQuery {
	// 当前页码
	private int currentPage = 1;
	// 一页显示条数
	private int pageSize = 10;
	// 处理2条hql
	// select count(o) from Employee o where o.name=? and o.email=?
	// select o from Employee o where o.name=? and o.email=? 不写limit ?,?
	private StringBuilder countHql;
	private StringBuilder limitHql;
	// 处理hql里面的?,参数的值
	private List paramList;

	public BaseQuery(String className) {
		countHql = new StringBuilder("select count(o) from " + className + " o");
		limitHql = new StringBuilder("select o from " + className + " o");
		paramList = new ArrayList();
	}

	// 必须让子类重写的方法：子类传入参数的条件和值
	protected abstract void addWhere();

	// 在提供一个方法，由子类直接调用，放入拼接的hql条件和值
	// select count(o) from Employee o where o.date between ? and ?
	protected void addCondition(String where, Object... objects) {
		// 怎样知道应该拼接where 还是and看paramList.size
		if (paramList.size() == 0) {
			countHql.append(" where ").append(where);
			limitHql.append(" where ").append(where);
		} else {
			countHql.append(" and ").append(where);
			limitHql.append(" and ").append(where);
		}
		// 把参数的值放入List paramList;
		// paramList.add(objects);//错误的
		// paramList.add(Arrays.asList(objects));//错误的
		paramList.addAll(Arrays.asList(objects));
	}

	// 保证addWhere子类重写的方法只能调用一次
	private boolean flag = false;
	private void buildWhere() {
		if (!flag) {
			addWhere();
			flag = true;
		}
	}

	// 提供一个get方法给dao使用
	public String getCountHql() {
		// 调用一个方法拼接hql
		buildWhere();
		return countHql.toString();
	}

	public String getLimitHql() {
		// 调用一个方法拼接hql
		buildWhere();
		return limitHql.toString();
	}

	public List getParamList() {
		// 调用一个方法拼接hql
		buildWhere();
		return paramList;
	}

	// 给struts使用
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

}

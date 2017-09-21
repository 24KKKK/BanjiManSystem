package com.dyf.action;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

/**
 * 
 * 高级查询+分页：CRUD需求的父类
 *
 */
public abstract class CRUDAction<T> extends BaseAction implements ModelDriven<T>, Preparable {

	// 列表的方法名称
	@Override
	// 如果出现了转换异常或者验证异常，改变默认的跳转视图名称,跳转到execute方法
	@InputConfig(methodName = "execute")
	public String execute() throws Exception {
		/*list();*/
		return SUCCESS;
	}

	// 不直接让外部(url地址)访问就不需要定义为public
	/*protected abstract void list() throws Exception;*/

	// 显示修改页面的方法名称,子类必须写此方法
	// @Override
	// public String input() throws Exception {
	// return INPUT;
	// }
	// 保存的方法名称
	public abstract String save() throws Exception;
	// 删除的方法名称
	public abstract String delete() throws Exception;

	// 规定prepare方法的名称，必须在input方法或者save之前自动调用
	/*public abstract void prepareInput() throws Exception;

	public abstract void prepareSave() throws Exception;*/

	@Override
	public void prepare() throws Exception {}

}

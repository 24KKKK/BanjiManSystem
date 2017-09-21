package com.dyf.service.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import com.dyf.dao.BaseDAO;
import com.dyf.query.BaseQuery;
import com.dyf.query.PageList;
import com.dyf.service.IBaseService;

public class BaseServiceImpl <T> implements IBaseService<T> {

	protected BaseDAO<T> baseDao;
	private Class<T> entityClass;
	
	public BaseDAO<T> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDAO<T> baseDao) {
		this.baseDao = baseDao;
	}
    
	public Class<T> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public void save(T t) {
		baseDao.save(t);
	}

	@Override
	public void update(T t) {
		baseDao.update(t);
	}

	@Override
	public void delete(Serializable id) {
		baseDao.delete(entityClass, id);
	}

	@Override
	public T get(Serializable id) {
		return baseDao.get(entityClass, id);
	}

	@Override
	public List<T> getAll() {
		return baseDao.getAll(entityClass);
	}

	@Override
	public PageList findByQuery(BaseQuery baseQuery) {
		return baseDao.findByQuery(baseQuery);
	}

	public BaseServiceImpl() {
		// getClass() 返回此 Object 的运行时类。
		// public final native Class<?> getClass();
		// new BaseServiceImpl 返回就是父类（如果把父类定义为抽象） new EmployeeServiceImpl返回就是子类
		Class clazz = getClass();// 因为父类是抽象的，决定返回子类的实例
		// System.out.println("BaseServiceImpl clazz:" + clazz);
		// getGenericSuperclass() 返回表示此 Class 所表示的实体的直接父类的 Type。
		// EmployeeServiceImpl extends BaseServiceImpl<Employee>
		// java.lang.reflect.Type标示接口，里面什么代码都没有
		Type type = clazz.getGenericSuperclass();// BaseServiceImpl<Employee>的类型Type
		// System.out.println("BaseServiceImpl type:" + type);
		if (type instanceof ParameterizedType) {
			// ParameterizedType 表示参数化类型，如 Collection<String>。
			ParameterizedType parameterizedType = (ParameterizedType) type;
			// getActualTypeArguments() 返回表示此类型实际类型参数的 Type 对象的数组。<Employee>
			entityClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
		}
		System.out.println("BaseServiceImpl entityClass:" + entityClass);
	}

	
}

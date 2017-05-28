package com.jzp.framework.service;

import java.util.List;

import com.jzp.framework.model.BaseEntity;

/**
 * 
 * @ClassName: BaseService
 * @Description: service基类
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年5月26日 上午11:18:35
 */
public interface BaseService<T extends BaseEntity> {
	
	public

	/**
	 * 
	 * @Title: getAll
	 * @Description: 获取所有的数据
	 * @return
	 * @return: List<T>
	 */
	public List<T> getAll();

	/**
	 * 
	 * @Title: get
	 * @Description: 根据id获取对象
	 * @param id
	 * @return
	 * @return: T
	 */
	public T get(Long id);

	/**
	 * 
	 * @Title: get
	 * @Description: 根据ids获取对象
	 * @param ids
	 * @return
	 * @return: List<T>
	 */
	public List<T> getList(List<Long> ids);

	/**
	 * 
	 * @Title: get
	 * @Description: 根据t获取数据
	 * @param t
	 * @return
	 * @return: T
	 */
	public T get(T t);

	/**
	 * 
	 * @Title: getList
	 * @Description: 根据t获取集合
	 * @param t
	 * @return
	 * @return: T
	 */
	public List<T> getList(T t);
	
	public Pager

}

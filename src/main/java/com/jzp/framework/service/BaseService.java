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
	/**
	 * 
	 * @Title: queryById
	 * @Description: 根据id进行查询
	 * @param id
	 * @return
	 * @return: T
	 */
	public T queryById(Long id);

	/**
	 * 
	 * @Title: queryByIds
	 * @Description: 根据ids进行查询
	 * @param ids
	 * @return
	 * @return: List<T>
	 */
	public List<T> queryByIds(Long ids);

	/**
	 * 
	 * @Title: queryAll
	 * @Description: 查询所有
	 * @return
	 * @return: List<T>
	 */
	public List<T> queryAll();

	/**
	 * 
	 * @Title: queryOne
	 * @Description: 根据条件查询一条数据，如果有多条数据会抛出异常
	 * @param t
	 * @return
	 * @return: T
	 */
	public T queryOne(T t);

	/**
	 * 
	 * @Title: queryList
	 * @Description: 根据条件查询数据列表
	 * @param t
	 * @return
	 * @return: T
	 */
	public List<T> queryList(T t);
	
	public Page
	/**
	 * 
	 * @Title: getNextId
	 * @Description: 获取下一条记录的id
	 * @return
	 * @return: Long
	 */
	public Long getNextId();

}

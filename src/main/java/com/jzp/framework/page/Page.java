package com.jzp.framework.page;

import java.util.List;

import com.github.pagehelper.PageInfo;

/**
 * 
 * @ClassName: Page
 * @Description: 分页主要继承了分页插件的pageINfo类
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年5月26日 下午1:56:36
 * @param <T>
 */
public class Page<T> extends PageInfo<T> {

	private static final long serialVersionUID = -5255811398198396881L;
	
	private List<Order> orders;
	
	private List
	
	
	public Page() {
		super();
		// 初始化设置
		this.setPageNum(1);// 设置当前页码
		this.setPageSize(20);// 设置每页的记录数
		this.setTotal(0);// 设置总记录数
		this.setPages(0);// 设置总页数
	}

}

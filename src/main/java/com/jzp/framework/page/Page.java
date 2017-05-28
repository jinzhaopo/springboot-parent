package com.jzp.framework.page;

import java.util.ArrayList;
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
	/**
	 * 排序集合
	 */
	private List<Order> orders;
	/**
	 * 字段搜索集合
	 */
	private List<SearchFilter> filters;

	public Page() {
		super();
		// 初始化设置
		this.setPageNum(1);// 设置当前页码
		this.setPageSize(20);// 设置每页的记录数
		this.setTotal(0);// 设置总记录数
		this.setPages(0);// 设置总页数
		
		orders = new ArrayList<Order>();
		filters = new ArrayList<SearchFilter>();
		
		//默认排序createDate
		Order order = new Order();
		order.setField("createDate");
		order.setOrderType(OrderTypeEnum.desc);
		orders.add(order);
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<SearchFilter> getFilters() {
		return filters;
	}

	public void setFilters(List<SearchFilter> filters) {
		this.filters = filters;
	}

	
	
}

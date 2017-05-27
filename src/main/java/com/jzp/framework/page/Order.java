package com.jzp.framework.page;

/**
 * 
 * @ClassName: Order
 * @Description: 排序
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年5月27日 下午2:20:54
 */
public class Order {
	/**
	 * 排序字段
	 */
	private String field;

	/**
	 * 排序方式
	 */
	private OrderType orderType;

	/*get and set*/
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public OrderType getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}

}

package com.fastsprings.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderSO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long orderId;

	private Date orderDate;

	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private List<OrderItemSO> orderItemsSO = new ArrayList<OrderItemSO>();

	public List<OrderItemSO> getOrderItemsSO() {
		return orderItemsSO;
	}

	public void setOrderItemsSO(List<OrderItemSO> orderItemsSO) {
		this.orderItemsSO = orderItemsSO;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

}

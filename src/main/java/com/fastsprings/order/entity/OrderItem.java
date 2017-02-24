package com.fastsprings.order.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import com.fastsprings.generics.GenericEntity;
import com.fastsprings.order.utilities.OrderItemState;

@Entity
public class OrderItem extends GenericEntity<OrderItem> {

	private static final long serialVersionUID = 1L;

	@Column
	private String itemName;

	@Column
	private double itemPrice;

	@Column
	private int itemQuantity;

	@Column
	@Enumerated(EnumType.ORDINAL)
	private OrderItemState orderItemState;

	@ManyToOne
	private Order order;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public OrderItemState getOrderItemState() {
		return orderItemState;
	}

	public void setOrderItemState(OrderItemState orderItemState) {
		this.orderItemState = orderItemState;
	}

}

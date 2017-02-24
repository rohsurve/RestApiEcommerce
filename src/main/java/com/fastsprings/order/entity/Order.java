package com.fastsprings.order.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fastsprings.customer.entity.Customer;
import com.fastsprings.generics.GenericEntity;
import com.fastsprings.order.utilities.OrderStatus;

@Entity
public class Order extends GenericEntity<Order> {

	private static final long serialVersionUID = 1L;

	@Column
	private Date createdDate;

	@Enumerated(EnumType.ORDINAL)
	private OrderStatus orderStatus;
	
	@ManyToOne
	private Customer customer;

	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<OrderItem> orderdItems = new ArrayList<OrderItem>();

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public List<OrderItem> getOrderdItems() {
		return orderdItems;
	}

	public void setOrderdItems(List<OrderItem> orderdItems) {
		this.orderdItems = orderdItems;
	}

}

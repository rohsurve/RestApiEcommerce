package com.fastsprings.order.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import com.fastsprings.generics.GenericDaoImpl;
import com.fastsprings.order.entity.Order;
import com.fastsprings.order.utilities.OrderStatus;

public class OrderDaoImpl extends GenericDaoImpl<Order> implements OrderDao {

	public List<Order> findOrdersByCustomerAndStatus(long customerId, OrderStatus orderStatus) {
		String queryStr = "SELECT o.* FROM Order o JOIN CUSTOMER c WHERE o.customer.id =:customerId AND o.orderStatus=:orderStatus";
		TypedQuery<Order> query = em.createQuery(queryStr, Order.class);
		query.setParameter("customerId", customerId);
		query.setParameter("orderStatus", orderStatus);
		return query.getResultList();
	}

}

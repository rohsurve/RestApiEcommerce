package com.fastsprings.order.dao;

import java.util.List;

import com.fastsprings.generics.GenericDao;
import com.fastsprings.order.entity.Order;
import com.fastsprings.order.utilities.OrderStatus;

public interface OrderDao extends GenericDao<Order>{
		
	List<Order> findOrdersByCustomerAndStatus(long customerId,OrderStatus orderStatus);

}

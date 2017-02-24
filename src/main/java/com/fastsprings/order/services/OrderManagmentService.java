package com.fastsprings.order.services;

import java.util.List;

import com.fastsprings.model.OrderSO;

public interface OrderManagmentService {

	long createOrder(OrderSO orderSO);

	String getOrderStatus(long orderId);

	OrderSO getOrder(long orderId);

	List<OrderSO> getSuccessfulOrders(long customerId);

	List<OrderSO> getFailedOrders(long customerId);

}

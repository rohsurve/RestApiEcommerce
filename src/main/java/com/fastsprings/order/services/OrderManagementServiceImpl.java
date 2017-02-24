package com.fastsprings.order.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fastsprings.model.OrderSO;
import com.fastsprings.model.ProductSO;
import com.fastsprings.order.dao.OrderDao;
import com.fastsprings.order.entity.Order;
import com.fastsprings.order.utilities.OrderStatus;
import com.fastsprings.order.utilities.OrderUtil;
import com.fastsprings.product.services.ProductManagmentService;

@Service("orderService")
public class OrderManagementServiceImpl implements OrderManagmentService {

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private ProductManagmentService productManagmentService;

	@Transactional()
	public long createOrder(OrderSO orderSO) {
		Order order = null;
		try {
			List<ProductSO> productItems = OrderUtil.orderItemSOToProductSO(orderSO.getOrderItemsSO());

			Map<String, ProductSO> validatedproductItems = productManagmentService.validateProducts(productItems);

			order = OrderUtil.orderSOToOrder(orderSO, validatedproductItems.values());

			orderDao.create(order);

			productManagmentService.updateProductStock(validatedproductItems.values());

		} catch (Exception exception) {

		}
		return order.getId();
	}

	public OrderSO getOrder(long orderId) {
		OrderSO orderSO = null;
		Order order = orderDao.find(orderId);
		if (order != null) {
			orderSO = OrderUtil.ordertoOrderSO(order);
		}
		return orderSO;
	}

	public String getOrderStatus(long orderId) {
		String status = null;
		Order order = orderDao.find(orderId);
		if (order != null) {
			status = order.getOrderStatus().name();
		}
		return status;
	}

	public List<OrderSO> getSuccessfulOrders(long customerId) {
		List<Order> orders = orderDao.findOrdersByCustomerAndStatus(customerId, OrderStatus.SUCCESS);
		List<OrderSO> orderSos = OrderUtil.getOrderSOs(orders);
		return orderSos;
	}

	public List<OrderSO> getFailedOrders(long customerId) {
		List<Order> orders = orderDao.findOrdersByCustomerAndStatus(customerId, OrderStatus.FAILED);
		List<OrderSO> orderSos = OrderUtil.getOrderSOs(orders);
		return orderSos;

	}

}

package com.fastsprings.order.utilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.fastsprings.model.OrderItemSO;
import com.fastsprings.model.OrderSO;
import com.fastsprings.model.ProductSO;
import com.fastsprings.order.entity.Order;
import com.fastsprings.order.entity.OrderItem;

public class OrderUtil {

	private OrderUtil() {
	}

	public static List<OrderSO> getOrderSOs(List<Order> orders) {
		List<OrderSO> orderSOs = new ArrayList<OrderSO>();
		for (Order order : orders) {
			orderSOs.add(ordertoOrderSO(order));
		}
		return orderSOs;
	}

	public static OrderSO ordertoOrderSO(Order order) {
		OrderSO orderSO = new OrderSO();
		orderSO.setOrderDate(order.getCreatedDate());
		orderSO.setStatus(order.getOrderStatus().name());

		for (OrderItem orderItem : order.getOrderdItems()) {
			OrderItemSO orderItemSO = new OrderItemSO();
			orderItemSO.setItemState(orderItem.getOrderItemState().name());
			orderItemSO.setItemName(orderItem.getItemName());
			orderItemSO.setItemPrice(orderItem.getItemPrice());
			orderItemSO.setItemQuantity(orderItem.getItemQuantity());
			orderSO.getOrderItemsSO().add(orderItemSO);
		}
		return orderSO;
	}

	public static Order orderSOToOrder(OrderSO orderSO, Collection<ProductSO> validatedproductItems) {
		Order order = new Order();
		order.setCreatedDate(orderSO.getOrderDate());

		// default state
		order.setOrderStatus(OrderStatus.SUCCESS);

		for (ProductSO productSO : validatedproductItems) {
			OrderItem orderItem = new OrderItem();
			if (!productSO.isValid()) {
				order.setOrderStatus(OrderStatus.FAILED);
				orderItem.setOrderItemState(OrderItemState.DECLINED);
			} else {
				orderItem.setOrderItemState(OrderItemState.PURCHASED);
			}
			orderItem.setItemName(productSO.getProductName());
			orderItem.setItemPrice(productSO.getProductPrice());
			orderItem.setItemQuantity(productSO.getProductQuantiy());

			orderItem.setOrder(order);
			order.getOrderdItems().add(orderItem);
		}
		return order;
	}

	public static List<ProductSO> orderItemSOToProductSO(List<OrderItemSO> orderItems) {
		List<ProductSO> products = new ArrayList<ProductSO>();
		for (OrderItemSO orderItemSO : orderItems) {
			if (orderItemSO != null) {
				ProductSO productSO = new ProductSO();
				productSO.setProductName(orderItemSO.getItemName());
				productSO.setProductPrice(orderItemSO.getItemPrice());
				productSO.setProductQuantiy(orderItemSO.getItemQuantity());
				products.add(productSO);
			}
		}
		return products;
	}
}

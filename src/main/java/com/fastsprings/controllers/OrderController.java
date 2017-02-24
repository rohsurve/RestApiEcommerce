package com.fastsprings.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fastsprings.model.OrderSO;
import com.fastsprings.order.services.OrderManagmentService;
import com.fastsprings.order.utilities.OrderStatus;

@RestController
public class OrderController {

	@Autowired
	OrderManagmentService orderManagmentService;

	@RequestMapping(value = "/order/{id}/", method = RequestMethod.GET)
	public ResponseEntity<OrderSO> getOrder(@PathVariable("id") long id) {
		OrderSO order = orderManagmentService.getOrder(id);
		if (order == null) {
			return new ResponseEntity<OrderSO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<OrderSO>(order, HttpStatus.OK);
	}

	@RequestMapping(value = "/order/status/{id}/", method = RequestMethod.GET)
	public ResponseEntity<String> getOrderStatus(@PathVariable("id") long id) {
		OrderSO order = orderManagmentService.getOrder(id);
		if (order == null) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(order.getStatus(), HttpStatus.OK);
	}

	@RequestMapping(value = "/orders/", method = RequestMethod.GET)
	public ResponseEntity<List<OrderSO>> getOrders(@RequestParam("cusId") long customerId,
			@RequestParam("status") String flag) {
		List<OrderSO> orders = new ArrayList<OrderSO>();
		if (OrderStatus.SUCCESS.name().equalsIgnoreCase(flag)) {
			orders = orderManagmentService.getSuccessfulOrders(customerId);
		} else if (OrderStatus.FAILED.name().equalsIgnoreCase(flag)) {
			orders = orderManagmentService.getFailedOrders(customerId);
		}
		return new ResponseEntity<List<OrderSO>>(orders, HttpStatus.OK);
	}

	@RequestMapping(value = "/order/placeOrder/", method = RequestMethod.POST)
	public ResponseEntity<Long> placeOrder(@RequestBody OrderSO orderSO) {
		long orderId = orderManagmentService.createOrder(orderSO);
		return new ResponseEntity<Long>(orderId, HttpStatus.OK);
	}

}

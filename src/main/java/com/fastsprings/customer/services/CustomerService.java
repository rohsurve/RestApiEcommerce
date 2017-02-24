package com.fastsprings.customer.services;

import javax.servlet.http.HttpServletRequest;

import com.fastsprings.model.CustomerSO;

public interface CustomerService {
	
	void addCustomer(HttpServletRequest httpServletRequest, CustomerSO  customerSO);

}

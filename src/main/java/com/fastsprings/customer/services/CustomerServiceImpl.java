package com.fastsprings.customer.services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastsprings.customer.dao.CustomerDao;
import com.fastsprings.customer.entity.Customer;
import com.fastsprings.model.CustomerSO;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	public void addCustomer(HttpServletRequest httpServletRequest, CustomerSO customerSO) {
		Customer customer = new Customer();
		customer.setCustomerName(customerSO.getCustomerName());
		
	}
}

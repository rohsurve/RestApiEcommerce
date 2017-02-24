package com.fastsprings.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.fastsprings.customer.services.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;


}

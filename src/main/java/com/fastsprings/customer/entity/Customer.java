package com.fastsprings.customer.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;

	@Column
	private String customerName;
	
	@Column
	private int customerMobile;

	@Column
	private String customerAddress;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(int customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

}

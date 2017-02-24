package com.fastsprings.model;

import java.io.Serializable;

public class CustomerSO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String customerName;

	private int customerMobile;

	private String customerAddress;

	private String clientApiId;

	private String clientSecretKey;

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

	public String getClientApiId() {
		return clientApiId;
	}

	public void setClientApiId(String clientApiId) {
		this.clientApiId = clientApiId;
	}

	public String getClientSecretKey() {
		return clientSecretKey;
	}

	public void setClientSecretKey(String clientSecretKey) {
		this.clientSecretKey = clientSecretKey;
	}
}

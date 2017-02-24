package com.fastsprings.model;

import java.io.Serializable;

public class ProductSO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String productName;

	private double productPrice;

	private int productQuantiy;
	
	private boolean isValid;

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQuantiy() {
		return productQuantiy;
	}

	public void setProductQuantiy(int productQuantiy) {
		this.productQuantiy = productQuantiy;
	}

}

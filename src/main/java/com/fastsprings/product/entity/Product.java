package com.fastsprings.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.fastsprings.generics.GenericEntity;

@Entity
public class Product extends GenericEntity<Product> {

	private static final long serialVersionUID = 1L;

	@Column(name="name")
	private String productName;

	@Column(name="price")
	private double productPrice;

	@Column(name="availableQuantity")
	private int productAvailableQuantity;

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

	public int getProductAvailableQuantity() {
		return productAvailableQuantity;
	}

	public void setProductAvailableQuantity(int productAvailableQuantity) {
		this.productAvailableQuantity = productAvailableQuantity;
	}

}

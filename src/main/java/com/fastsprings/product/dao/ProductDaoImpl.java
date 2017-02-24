package com.fastsprings.product.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.fastsprings.generics.GenericDaoImpl;
import com.fastsprings.product.entity.Product;

@Repository
public class ProductDaoImpl extends GenericDaoImpl<Product> implements ProductDao {

	public List<Product> getProducts(Set<String> productNames) {
		String queryStr = "SELECT p.* FROM Product p WHERE p.name IN :productNames";
		TypedQuery<Product> query = em.createQuery(queryStr, Product.class);
		query.setParameter("productNames", productNames);
		return query.getResultList();
	}

	public void update(String productName, int quantity) {
		String queryStr = "Update Product p SET p.availableQuantity = :quantity WHERE p.name :productName";
		Query query = em.createQuery(queryStr);
		query.setParameter("availableQuantity", quantity);
		query.setParameter("productName", productName);
		query.executeUpdate();

	}

}

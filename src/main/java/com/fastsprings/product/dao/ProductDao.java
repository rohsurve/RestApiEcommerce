package com.fastsprings.product.dao;

import java.util.List;
import java.util.Set;

import com.fastsprings.generics.GenericDao;
import com.fastsprings.product.entity.Product;

public interface ProductDao extends GenericDao<Product>{
    
	List<Product> getProducts(Set<String> productNames);
	
	void update(String productName,int quantity);
	
}

package com.fastsprings.product.services;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.fastsprings.model.ProductSO;

public interface ProductManagmentService {
	
	Map<String, ProductSO> validateProducts(List<ProductSO> productSOs);
	
	void updateProductStock(Collection<ProductSO> productSOs);

}

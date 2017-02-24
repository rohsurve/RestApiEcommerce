package com.fastsprings.product.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastsprings.model.ProductSO;
import com.fastsprings.product.dao.ProductDao;
import com.fastsprings.product.entity.Product;

@Service("productCatalogService")
public class ProductManagmentServiceImpl implements ProductManagmentService {

	@Autowired
	private ProductDao productDao;

	public Map<String, ProductSO> validateProducts(List<ProductSO> productSOs) {

		Map<String, ProductSO> validatedProducts = new HashMap<String, ProductSO>();

		if (!productSOs.isEmpty()) {
			for (ProductSO productSO : productSOs) {
				validatedProducts.put(productSO.getProductName(), productSO);
			}
		}

		List<Product> products = productDao.getProducts(validatedProducts.keySet());

		for (Product product : products) {
			if (validatedProducts.containsKey(product.getProductName())) {

				ProductSO productSO = validatedProducts.get(product.getProductName());

				if (productSO.getProductPrice() == product.getProductPrice()
						&& productSO.getProductQuantiy() <= product.getProductAvailableQuantity()) {

					productSO.setValid(true);
					validatedProducts.put(product.getProductName(), productSO);
				}

			}
		}

		return validatedProducts;
	}

	public void updateProductStock(Collection<ProductSO> productSOs) {
		
		for (ProductSO productSO : productSOs) {
			if(productSO.isValid()){
				productDao.update(productSO.getProductName(),productSO.getProductQuantiy()-1);
			}
		}
	}

}

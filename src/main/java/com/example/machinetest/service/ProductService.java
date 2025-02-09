package com.example.machinetest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.machinetest.entity.Product;

public interface ProductService {
	Page<Product> getAllProducts(Pageable pageable);
	Product	getProductById(Long id);
	Product createProduct(Product product);
	Product updateProduct(Long id, Product product);
	void deleteProductById(Long id);
}

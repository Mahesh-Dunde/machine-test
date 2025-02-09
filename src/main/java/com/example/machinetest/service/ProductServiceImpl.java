package com.example.machinetest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.machinetest.entity.Product;
import com.example.machinetest.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired	
	private ProductRepository productRepository;
	@Override
	public Page<Product> getAllProducts(Pageable pageable) {
		return productRepository.findAll(pageable);
	}

	@Override
	public Product getProductById(Long id) {
		return productRepository.findById(id).orElseThrow(()->new RuntimeException("Product not found"));
	}

	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Long id, Product product) {
		Product existingProduct =getProductById(id);
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setCategory(product.getCategory());
		return productRepository.save(existingProduct);
	}

	@Override
	public void deleteProductById(Long id) {
		productRepository.deleteById(id);
		
	}

}

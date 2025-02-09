package com.example.machinetest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.machinetest.entity.Product;
import com.example.machinetest.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductService productservice;
	
	@GetMapping
	public Page<Product> getAllProducts(@RequestParam(defaultValue = "0") int page,
										@RequestParam(defaultValue = "5") int size,
										@RequestParam(defaultValue = "price") String sortBy,
										@RequestParam(defaultValue = "true") boolean ascending) {
		Sort sort = ascending?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
		Pageable pageable =PageRequest.of(page,size,sort);
		return productservice.getAllProducts(pageable);
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id) {
		return productservice.getProductById(id);
	}
	
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productservice.createProduct(product);
	}
	
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable Long id,@RequestBody Product product) {
		return productservice.updateProduct(id, product);
	}

	@DeleteMapping("/{id}")
	public void deleteProductById(@PathVariable Long id) {
		productservice.deleteProductById(id);
		
	}
}

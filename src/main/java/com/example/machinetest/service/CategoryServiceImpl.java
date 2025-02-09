package com.example.machinetest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.machinetest.entity.Category;
import com.example.machinetest.repository.CategoryRepository;
@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Page<Category> getAllCategories(Pageable pageable) {
		return categoryRepository.findAll(pageable);
	}

	@Override
	public Category getCategoryById(Long id) {
		return categoryRepository.findById(id).orElseThrow(()->new RuntimeException("Category not found"));
	}

	@Override
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Long id, Category category) {
		Category existingCategory = getCategoryById(id);
		existingCategory.setName(category.getName());
		return categoryRepository.save(existingCategory);
	}

	@Override
	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
		
	}

}

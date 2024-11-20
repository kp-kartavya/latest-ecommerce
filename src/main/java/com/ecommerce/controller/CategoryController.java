package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.models.Category;
import com.ecommerce.repository.CategoryRepository;

@RestController
@RequestMapping("/api/")
public class CategoryController {
	@Autowired
	CategoryRepository categoryRepository;
	
	@GetMapping("category")
	public ResponseEntity<Object> getAllCategories() {
		List<Category> category = categoryRepository.findAll();
		return ResponseEntity.ok(category);
	}
	
	@PostMapping("category")
	public ResponseEntity<Object> addCategory(@RequestBody Category category) {
		Category categorydata = categoryRepository.findByCategoryName(category.getCategoryName()).orElse(null);
		if(categorydata != null) {
			return ResponseEntity.badRequest().body("Category Already Exists");
		}
		Category newCategory = new Category();
		newCategory.setCategoryName(category.getCategoryName());
		categoryRepository.save(newCategory);
		return ResponseEntity.status(HttpStatus.CREATED).body(newCategory);
	}
	
}

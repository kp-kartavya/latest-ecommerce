package com.ecommerce.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.models.Category;
import com.ecommerce.models.Product;
import com.ecommerce.repository.CategoryRepository;
import com.ecommerce.repository.ProductRepository;

@RestController
@RequestMapping("/api/")
public class ProductController {
	private static final Logger logger = LogManager.getLogger(ProductController.class);
	@Autowired
	ProductRepository productRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@GetMapping("product")
	public ResponseEntity<Object> getAllProducts() {
		List<Product> product = productRepository.findAll();
		return ResponseEntity.ok(product);
	}

	@PostMapping("product")
	public ResponseEntity<Object> addProduct(@RequestBody Product product) {
		logger.info("Inside addProduct");
		Product productdata = productRepository.findByProductName(product.getProductName()).orElse(null);
		Category category = categoryRepository.findByCategoryName(product.getCategory().getCategoryName()).orElse(null);
		if (category == null) {
			return ResponseEntity.badRequest().body("Category Does Not Exist!!");
		}
		if (productdata != null) {
			return ResponseEntity.badRequest().body("Product Already Exists!!");
		}
		Product newProduct = new Product();
		newProduct.setProductName(product.getProductName());
		newProduct.setPrice(product.getPrice());
		newProduct.setCategory(category);
		productRepository.saveAndFlush(newProduct);

		return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
	}

}

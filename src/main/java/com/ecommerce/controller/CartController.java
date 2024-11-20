package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.models.Cart;
import com.ecommerce.models.CartProduct;
import com.ecommerce.models.Product;
import com.ecommerce.repository.CartProductRepository;
import com.ecommerce.repository.CartRepository;
import com.ecommerce.repository.CategoryRepository;
import com.ecommerce.repository.ProductRepository;

@RestController
@RequestMapping("/api/kartavya/")
public class CartController {
	@Autowired
	CartProductRepository cpRepo;
	@Autowired
	CartRepository cartRepo;
	
	@Autowired
	ProductRepository productRepository;

	@Autowired
	CategoryRepository categoryRepository;
	
	@PostMapping("cart")
	public ResponseEntity<Object> addProductToCart(@RequestBody Product product) {
		Product prod = productRepository.findById(product.getProductId()).orElse(null);
		CartProduct cp = new CartProduct();
		cp.setProduct(product);
		cp.setQuantity(1);
		cpRepo.save(cp);
		Cart cart = new Cart();
		cart.getCartProducts().add(cp);
		cart.updateAmount(prod.getPrice() * cp.getQuantity());
		cartRepo.save(cart);
		return ResponseEntity.ok(cart);
	}
}

package com.roofiahmad.store;

import com.roofiahmad.store.services.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
//		var service =  context.getBean(UserService.class);
//		service.showRelatedEntities();
//		service.fetchAddress();
//		service.persistRelated();
//		service.deleteRelated();
		var productService = context.getBean(ProductService.class);
//		productService.createNewProduct();
//		productService.createNewProductWithCategory();
//		productService.addProductToWishlist();
		productService.deleteProduct();

	}
}

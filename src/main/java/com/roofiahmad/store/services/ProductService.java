package com.roofiahmad.store.services;

import com.roofiahmad.store.entities.Category;
import com.roofiahmad.store.entities.Product;
import com.roofiahmad.store.repositories.CategoryRepository;
import com.roofiahmad.store.repositories.ProductRepository;
import com.roofiahmad.store.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public ProductService(CategoryRepository categoryRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public void createNewProduct() {
        var category = Category.builder().name("fruits").build();
        var product = Product.builder().
                name("apple").
                price(BigDecimal.valueOf(100)).
                description("awesome product").
                category(category).
                build();
        category.getProducts().add(product);
//        categoryRepository.save(category);
        productRepository.save(product);
    }

    @Transactional
    public void createNewProductWithCategory() {
        var category = categoryRepository.findById((byte) 1).orElseThrow();
        System.out.println(category.getName());

        var product = Product.builder().
                name("mango").
                price(BigDecimal.valueOf(100)).
                description("awesome product").
                category(category).
                build();

        productRepository.save(product);
    }

    public void addProductToWishlist(){
        var user = userRepository.findById(3L).orElseThrow();
        var products = productRepository.findAll();
        var wishlist = user.getWishlist();

        products.forEach(wishlist::add);
        userRepository.save(user);

    }

    public void deleteProduct(){
        productRepository.deleteById(1L);
    }
}

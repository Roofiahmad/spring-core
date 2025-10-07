package com.roofiahmad.store.repositories;

import com.roofiahmad.store.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
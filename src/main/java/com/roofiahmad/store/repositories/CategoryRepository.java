package com.roofiahmad.store.repositories;

import com.roofiahmad.store.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Byte> {
}
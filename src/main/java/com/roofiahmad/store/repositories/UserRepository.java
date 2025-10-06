package com.roofiahmad.store.repositories;

import com.roofiahmad.store.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}

package com.roofiahmad.store.repositories;

import com.roofiahmad.store.dtos.UserSummaryDTO;
import com.roofiahmad.store.entities.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    @EntityGraph(attributePaths = {"tags", "addresses"})
    Optional<User> findByEmail(String email);


    @EntityGraph(attributePaths = "addresses")
    @Query("select u from User u")
    List<User> findAllWithAddresses();

    @EntityGraph(attributePaths = "profile")
    @Query("SELECT new com.roofiahmad.store.dtos.UserSummaryDTO(p.user.id, p.user.email) FROM Profile p WHERE p.loyaltyPoints > :points ORDER BY p.user.email ASC")
    List<UserSummaryDTO> findByMinimumPoints(@Param("points") int loyaltyPoints);
}

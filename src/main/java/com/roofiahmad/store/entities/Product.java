package com.roofiahmad.store.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private BigDecimal price;

    @Column(name="category_id")
    private byte categoryId;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @ToString.Exclude
    private Category category;
}

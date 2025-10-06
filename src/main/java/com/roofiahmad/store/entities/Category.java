package com.roofiahmad.store.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private byte id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "category")
    @Builder.Default
    private Set<Product> products = new HashSet<>();
}

package com.ijse.IjsePos.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Double qty;
    @Column(nullable = false)
    private Double price;

    @ManyToOne(cascade =  CascadeType.MERGE)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(mappedBy = "items")
    private Set<Order> orders = new HashSet<>();
}

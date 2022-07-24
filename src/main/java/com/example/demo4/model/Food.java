package com.example.demo4.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "food")
public class Food implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name",unique = true)
    private String name;
    @Column(name="quantity")
    private long quantity;
    @Column(name="available")
    private boolean available;

    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;

    public Food() {
    }
}

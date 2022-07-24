package com.example.demo4.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name",unique = true)
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<Food> foods;

    public Category(Set<Food> foods) {
        this.foods = foods;
    }

    public Category() {

    }
}

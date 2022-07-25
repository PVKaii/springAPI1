package com.example.demo4.model;

import com.example.demo4.model.pojo.FoodPrinciple;
import com.fasterxml.jackson.annotation.JsonIgnore;

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

//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;

    public Food() {
    }

    public Food(String name, long quantity, boolean available) {
        this.name = name;
        this.quantity = quantity;
        this.available = available;
    }
    public Food(FoodPrinciple foodPrinciple, Category category){
        this.name= foodPrinciple.getName();
        this.available= foodPrinciple.isAvailable();
        this.quantity= foodPrinciple.getQuantity();
        this.category=category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getCategory(String s) {
        if(this.category!=null) return category.getName();
        return null;
    }
    @JsonIgnore
    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

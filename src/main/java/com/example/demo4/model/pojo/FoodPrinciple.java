package com.example.demo4.model.pojo;

import com.example.demo4.model.Food;

public class FoodPrinciple {
    private int id;
    private String name;
    private long quantity;
    private boolean available;
    private int category;

    public FoodPrinciple(String name, long quantity, boolean available, int category) {
        this.name = name;
        this.quantity = quantity;
        this.available = available;
        this.category = category;
    }

    public FoodPrinciple(Food food){
        this.id=food.getId();
        this.name=food.getName();
        this.quantity= food.getQuantity();
        this.available= food.isAvailable();
        this.category=food.getCategory().getId();
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

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}

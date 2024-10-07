package com.food.food_order.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Food extends FoodBaseClass{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String foodId;

    @Column(unique = true)
    private String foodName;

    private String category;

    private String description;

    private double price;

}

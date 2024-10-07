package com.food.food_order.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class FoodDto {

    private String foodId;

    private String foodName;

    private String category;

    private String description;

    private double price;

}

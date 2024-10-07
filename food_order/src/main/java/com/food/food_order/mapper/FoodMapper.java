package com.food.food_order.mapper;

import com.food.food_order.Entity.Food;
import com.food.food_order.dto.FoodDto;

public class FoodMapper {

    // Corrected method to map Food entity to FoodDto
    public static FoodDto convertFoodToFoodDto(Food food, FoodDto foodDto) {

        foodDto.setFoodId(food.getFoodId());
        foodDto.setFoodName(food.getFoodName());
        foodDto.setCategory(food.getCategory());
        foodDto.setDescription(food.getDescription());
        foodDto.setPrice(food.getPrice());

        return foodDto;
    }

    // Another method to map FoodDto to Food entity if needed
    public static Food convertFoodDtoToFood(FoodDto foodDto, Food food) {
        food.setFoodId(foodDto.getFoodId());
        food.setFoodName(foodDto.getFoodName());
        food.setCategory(foodDto.getCategory());
        food.setDescription(foodDto.getDescription());
        food.setPrice(foodDto.getPrice());

        return food;
    }
}

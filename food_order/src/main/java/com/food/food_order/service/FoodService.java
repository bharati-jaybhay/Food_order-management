package com.food.food_order.service;

import com.food.food_order.dto.FoodDto;

import java.util.List;

public interface FoodService {

     FoodDto updateFoodItem(String foodId, FoodDto foodDto) ;

     FoodDto getFoodByFoodId(String foodId);

     FoodDto addFood(FoodDto foodDto);

     List<FoodDto> getAllFood();

     void deleteFoodItem(String foodId);
}

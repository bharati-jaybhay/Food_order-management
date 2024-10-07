package com.food.food_order.service;

import com.food.food_order.Entity.Food;
import com.food.food_order.dto.FoodDto;
import com.food.food_order.exception.FoodIdExistsException;
import com.food.food_order.mapper.FoodMapper;
import com.food.food_order.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;

    public FoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public FoodDto getFoodByFoodId(String foodId) {
        Food food = foodRepository.findByFoodId(foodId).orElseThrow(() -> new FoodIdExistsException(String.format("Food with ID %s does not exist", foodId), 400));

        return FoodMapper.convertFoodToFoodDto(food, new FoodDto());
    }

    @Override
    public FoodDto addFood(FoodDto foodDto) {

        // Check if the foodId or foodName already exists in the system
        foodRepository.findByFoodId(foodDto.getFoodId())
                .ifPresent(food -> {
                    throw new FoodIdExistsException("Food is already exists", 400);
                });

        // Convert FoodDto to Food entity
        Food food = new Food();
        food = convertFoodDtoToFood(foodDto, food);

        // Logic to generate unique foodId if not provided
        if (foodDto.getFoodId() == null || foodDto.getFoodId().isEmpty()) {
            food.setFoodId(generateFoodId(food.getFoodName()));
        }

        // Save the food entity to the repository
        foodRepository.save(food);

        // Set the generated foodId in the DTO for returning
        foodDto.setFoodId(food.getFoodId());

        return foodDto;
    }


    @Override
    public List<FoodDto> getAllFood() {

        return foodRepository.findAll()
                .stream()
                .map(food -> FoodMapper.convertFoodToFoodDto(food, new FoodDto()))
                .toList();

    }

    @Override
    public void deleteFoodItem(String foodId) {
        Food food = foodRepository.findByFoodId(foodId)
                .orElseThrow(() -> new FoodIdExistsException("Food with ID " + foodId + " does not exist"));
    }

    @Override
    public FoodDto updateFoodItem(String foodId, @org.jetbrains.annotations.NotNull FoodDto foodDto) {
        Food food=foodRepository.findByFoodId(foodId).orElseThrow(()->new FoodIdExistsException("Food is not found", 400));
        foodRepository.updateFood(foodDto.getFoodName(), foodDto.getCategory(), foodDto.getDescription(),foodDto.getPrice(), foodId);
        foodDto.setFoodId(foodId);
        return foodDto;
    }


    private Food convertFoodDtoToFood(FoodDto foodDto, Food food) {
        food.setFoodName(foodDto.getFoodName());
        food.setCategory(foodDto.getCategory());
        food.setDescription(foodDto.getDescription());
        food.setPrice(foodDto.getPrice());
        return food;
    }

    private String generateFoodId(String foodName) {
        String namePart = foodName.length() >= 3 ? foodName.substring(0, 3).toUpperCase() : foodName.toUpperCase();

        return namePart;
    }

}

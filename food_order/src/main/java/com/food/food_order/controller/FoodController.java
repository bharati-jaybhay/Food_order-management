package com.food.food_order.controller;

import com.food.food_order.dto.FoodDto;
import com.food.food_order.dto.ResponseDto;
import com.food.food_order.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FoodController {

    @Autowired
    private FoodService foodService;


    @PostMapping("/food")
    public ResponseEntity<ResponseDto<FoodDto>> addFoodItems(@RequestBody FoodDto foodDto) {
        FoodDto foodDto1 = foodService.addFood(foodDto);
        return ResponseEntity.ok(new ResponseDto("200", foodDto1));
    }

    @GetMapping("/food")
    public ResponseEntity<ResponseDto<List<FoodDto>>> getAllFoodItems(){
        List <FoodDto> foodDtoList= foodService.getAllFood();
                return ResponseEntity.ok(new ResponseDto<>("200", foodDtoList));
    }

    @GetMapping("/food/{foodId}")
    public ResponseEntity<ResponseDto<FoodDto>> getFoodByFoodId(@PathVariable String foodId) {
        FoodDto foodDto = foodService.getFoodByFoodId(foodId);
        return ResponseEntity.ok(new ResponseDto<>("200", foodDto));
    }

    @DeleteMapping("/food/{foodId}")
    public ResponseEntity<ResponseDto<String>> deleteFoodItem(@PathVariable String foodId){
        foodService.deleteFoodItem(foodId);

        return ResponseEntity.status(200).body(new ResponseDto("200", ("Food with foodId: " + foodId + " deleted successfully")));
    }

    @PutMapping("/food/{foodId}")
    public ResponseEntity<ResponseDto<FoodDto>> updateFoodItemByFoodId(@PathVariable String foodId, @RequestBody FoodDto foodDto){
        FoodDto foodDto1=foodService.updateFoodItem(foodId, foodDto);
        return ResponseEntity.ok(new ResponseDto<>("200",foodDto1));
    }
}
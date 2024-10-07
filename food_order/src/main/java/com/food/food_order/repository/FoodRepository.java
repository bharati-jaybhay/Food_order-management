package com.food.food_order.repository;

import com.food.food_order.Entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {

    Optional<Food> findByFoodId(String foodId);

    Optional<Food> deleteByFoodId(String foodId);

    @Transactional
    @Modifying
    @Query("update Food set foodName = :fName, category = :cat, description = :desc, price = :price where foodId = :foodId")
    void updateFood(String fName, String cat, String desc, double price, String foodId);
}

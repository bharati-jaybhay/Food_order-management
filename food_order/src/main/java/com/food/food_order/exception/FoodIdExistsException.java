package com.food.food_order.exception;


public class FoodIdExistsException extends ResourceNotFound {

    // Constructor with message and status code
    public FoodIdExistsException(String message, int statusCode) {
        super(message, statusCode);
    }

    // Constructor with only message
    public FoodIdExistsException(String message) {
        super(message);
    }
}


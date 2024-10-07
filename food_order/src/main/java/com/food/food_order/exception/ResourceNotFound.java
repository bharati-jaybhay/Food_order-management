package com.food.food_order.exception;

import lombok.Getter;

@Getter
public class ResourceNotFound extends RuntimeException {
    private int statusCode;

    public ResourceNotFound(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public ResourceNotFound(String message) {
        super(message);
    }

}

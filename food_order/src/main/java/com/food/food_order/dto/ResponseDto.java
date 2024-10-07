package com.food.food_order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDto <T>{

    private String statusCode;

    private T data;
}

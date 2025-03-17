package com.pontta.hardware_shopping.dto;

public record CreateProductDto(
    String name,
    String description,
    Integer quantity
) {
    
}

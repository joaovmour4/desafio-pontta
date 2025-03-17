package com.pontta.hardware_shopping.dto;

public record ProductDto(
    Long id,
    String name,
    String description,
    Integer quantity
) {
    
}

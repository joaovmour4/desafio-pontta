package com.pontta.hardware_shopping.mappers;

import org.mapstruct.Mapper;

import com.pontta.hardware_shopping.dto.ProductDto;
import com.pontta.hardware_shopping.entities.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
 
    ProductDto productToProductDto(Product product);

}

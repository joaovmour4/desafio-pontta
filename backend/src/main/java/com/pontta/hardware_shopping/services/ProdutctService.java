package com.pontta.hardware_shopping.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pontta.hardware_shopping.dto.CreateProductDto;
import com.pontta.hardware_shopping.dto.DecreaseStockDto;
import com.pontta.hardware_shopping.dto.ProductDto;
import com.pontta.hardware_shopping.entities.Product;
import com.pontta.hardware_shopping.exceptions.NegativeStockException;
import com.pontta.hardware_shopping.exceptions.ResourceNotFoundException;
import com.pontta.hardware_shopping.mappers.ProductMapper;
import com.pontta.hardware_shopping.repositories.ProductRepository;

@Service
public class ProdutctService {
    
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;

    public ProductDto findProductById(Long id){

        Product product = productRepository.findById(id)
                                           .orElseThrow(()-> new ResourceNotFoundException());

        return productMapper.productToProductDto(product);

    }

    public List<ProductDto> findProducts(String name){

        return productRepository.findByNameContainingIgnoreCase(name)
                                                 .stream()
                                                 .map(productMapper::productToProductDto)
                                                 .toList();

    }

    public ProductDto createProduct(CreateProductDto createProductDto){

        Product product = Product.builder()
                                 .name(createProductDto.name())
                                 .description(createProductDto.description())
                                 .quantity(createProductDto.quantity())
                                 .build();

        Product productSaved = productRepository.save(product);

        return productMapper.productToProductDto(productSaved);

    }

    public ProductDto updateProduct(Long id, CreateProductDto createProductDto){

        Product product = productRepository.findById(id)
                                           .orElseThrow(()-> new ResourceNotFoundException());

        product.setName(createProductDto.name());
        product.setDescription(createProductDto.description());
        product.setQuantity(createProductDto.quantity());

        return productMapper.productToProductDto(productRepository.save(product));

    }

    public void deleteProduct(Long id){

        Product product = productRepository.findById(id)
                                           .orElseThrow(()-> new ResourceNotFoundException());

        productRepository.delete(product);

    }

    public Integer decreaseStock(DecreaseStockDto decreaseStockDto){

        Product product = productRepository.findById(decreaseStockDto.idProduto())
                                           .orElseThrow(()-> new ResourceNotFoundException());

        if((product.getQuantity() - decreaseStockDto.quantity()) >= 0){
            product.setQuantity(product.getQuantity() - decreaseStockDto.quantity());
        } else{
            throw new NegativeStockException();
        }

        Product productSaved = productRepository.save(product);
        
        return productSaved.getQuantity();

    }

}

package com.pontta.hardware_shopping.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pontta.hardware_shopping.dto.CreateProductDto;
import com.pontta.hardware_shopping.dto.DecreaseStockDto;
import com.pontta.hardware_shopping.dto.ProductDto;
import com.pontta.hardware_shopping.services.ProdutctService;

@RestController
@RequestMapping
@CrossOrigin("*")
public class ProductController {
    
    @Autowired
    ProdutctService produtctService;

    public ResponseEntity<ProductDto> createProduct(@RequestBody CreateProductDto createProductDto){

        ProductDto product = produtctService.createProduct(createProductDto);

        return new ResponseEntity<>(product, HttpStatus.CREATED);

    }

    public ResponseEntity<ProductDto> findProductById(@PathVariable Long id){

        return new ResponseEntity<>(produtctService.findProductById(id), HttpStatus.OK);

    }

    public ResponseEntity<List<ProductDto>> findProducts(@RequestParam String name){

        return new ResponseEntity<>(produtctService.findProducts(name), HttpStatus.OK);

    }

    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id, @RequestBody CreateProductDto createProductDto){

        ProductDto productDto = produtctService.updateProduct(id, createProductDto);

        return new ResponseEntity<>(productDto, HttpStatus.OK);

    }

    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){

        produtctService.deleteProduct(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    public ResponseEntity<Integer> decreaseStock(@RequestBody DecreaseStockDto decreaseStockDto){

        Integer quantityRemaining = produtctService.decreaseStock(decreaseStockDto);

        return new ResponseEntity<>(quantityRemaining, HttpStatus.OK);

    }

}

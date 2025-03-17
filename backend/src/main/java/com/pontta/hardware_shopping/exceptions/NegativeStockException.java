package com.pontta.hardware_shopping.exceptions;

public class NegativeStockException extends RuntimeException {
    
    public NegativeStockException() {
        super("O estoque dos produtos não pode ser negativo.");
    }

    public NegativeStockException(String message){
        super(message);
    }

}

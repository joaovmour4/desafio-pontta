package com.pontta.hardware_shopping.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("O recurso solicitado não foi encontrado na base de dados");
    }

    public ResourceNotFoundException(String message){
        super(message);
    }
}

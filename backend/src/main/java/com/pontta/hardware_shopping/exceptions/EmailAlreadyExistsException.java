package com.pontta.hardware_shopping.exceptions;

public class EmailAlreadyExistsException extends RuntimeException {
    
    public EmailAlreadyExistsException() {
        super("Já existe um usuário com este email cadastrado");
    }

    public EmailAlreadyExistsException(String message){
        super(message);
    }

}

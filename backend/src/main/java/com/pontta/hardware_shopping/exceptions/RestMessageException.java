package com.pontta.hardware_shopping.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RestMessageException {
    
    private String message;

}

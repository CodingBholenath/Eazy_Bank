package com.eazyByte.loans.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String resouceName,String fieldName,String fieldValue) {
        super(String.format("%s not found with %s : '%s'",resouceName,fieldName,fieldValue));

    }
}

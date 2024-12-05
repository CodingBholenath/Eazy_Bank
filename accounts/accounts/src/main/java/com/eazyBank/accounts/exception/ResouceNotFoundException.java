package com.eazyBank.accounts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ResouceNotFoundException extends RuntimeException {
public ResouceNotFoundException(String resouceName,String fieldName,String fieldValue) {
  //super(message);
    super(String.format("%s not found with %s : '%s'",resouceName,fieldName,fieldValue));

}
}
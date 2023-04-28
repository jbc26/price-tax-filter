package com.inditex.price.content.domain.exception;

public class PriceTaxNotFoundException extends RuntimeException {

  public PriceTaxNotFoundException(String message){
    super(message);
  }
}

package com.inditex.price.content.infrastructure.rest.controller;

import com.inditex.price.content.domain.exception.PriceTaxNotFoundException;
import com.inditex.price.content.infrastructure.rest.dto.output.ErrorOutputDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class FindPriceControllerAdvice {

  @ResponseBody
  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  private ErrorOutputDto genericException(Exception e) {

    return ErrorOutputDto.builder()
        .message(e.getMessage())
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .exception(e)
        .build();
  }

  @ResponseBody
  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorOutputDto methodArgumentNotValidException(MethodArgumentNotValidException e) {

    return ErrorOutputDto.builder()
        .message(e.getMessage())
        .status(HttpStatus.BAD_REQUEST)
        .exception(e)
        .build();
  }

  @ResponseBody
  @ExceptionHandler(PriceTaxNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  private ErrorOutputDto notFoundException(PriceTaxNotFoundException e) {

    return ErrorOutputDto.builder()
        .message(e.getMessage())
        .status(HttpStatus.NOT_FOUND)
        .exception(e)
        .build();
  }

}
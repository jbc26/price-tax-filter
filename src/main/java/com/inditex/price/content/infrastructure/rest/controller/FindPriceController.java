package com.inditex.price.content.infrastructure.rest.controller;

import com.inditex.price.content.application.FindPriceUseCase;
import com.inditex.price.content.domain.entity.PriceFilter;
import com.inditex.price.content.domain.entity.PriceTax;
import com.inditex.price.content.infrastructure.mapper.PriceFilterInputDtoMapper;
import com.inditex.price.content.infrastructure.mapper.PriceOutputDtoMapper;
import com.inditex.price.content.infrastructure.rest.dto.input.PriceFilterInputDto;
import com.inditex.price.content.infrastructure.rest.dto.output.PriceOutputDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Prices")
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/prices")
public class FindPriceController {

  private final FindPriceUseCase findPriceUseCase;
  private final PriceOutputDtoMapper priceOutputDtoMapper;
  private final PriceFilterInputDtoMapper priceFilterInputDtoMapper;

  @GetMapping
  @Operation(summary = "Get final price according to input filters")
  public ResponseEntity<PriceOutputDto> getPricesByFilter(
      @Valid @ParameterObject PriceFilterInputDto filterDto
  ) {

    PriceFilter filter = priceFilterInputDtoMapper.toEntity(filterDto);
    PriceTax result = findPriceUseCase.filterFinalPrice(filter);
    return ResponseEntity.ok(priceOutputDtoMapper.toDto(result));
  }
}

package com.inditex.price.content.infrastructure.mapper;

import com.inditex.price.content.domain.entity.PriceTax;
import com.inditex.price.content.infrastructure.rest.dto.output.PriceOutputDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface PriceOutputDtoMapper {

  PriceOutputDto toDto(PriceTax source);
}

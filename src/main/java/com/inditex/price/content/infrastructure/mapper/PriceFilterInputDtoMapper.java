package com.inditex.price.content.infrastructure.mapper;

import com.inditex.price.content.domain.entity.PriceFilter;
import com.inditex.price.content.infrastructure.rest.dto.input.PriceFilterInputDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface PriceFilterInputDtoMapper {

  PriceFilter toEntity(PriceFilterInputDto source);
}

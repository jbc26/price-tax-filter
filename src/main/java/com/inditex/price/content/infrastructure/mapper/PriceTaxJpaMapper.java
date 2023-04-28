package com.inditex.price.content.infrastructure.mapper;

import com.inditex.price.content.domain.entity.PriceTax;
import com.inditex.price.content.infrastructure.repository.jpa.entity.PriceTaxJpa;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface PriceTaxJpaMapper {

  PriceTax toEntity(PriceTaxJpa source);

}

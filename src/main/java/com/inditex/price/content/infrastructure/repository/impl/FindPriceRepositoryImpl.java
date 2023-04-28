package com.inditex.price.content.infrastructure.repository.impl;

import com.inditex.price.content.domain.entity.PriceFilter;
import com.inditex.price.content.domain.entity.PriceTax;
import com.inditex.price.content.domain.exception.PriceTaxNotFoundException;
import com.inditex.price.content.domain.repository.FindPriceRepository;
import com.inditex.price.content.infrastructure.mapper.PriceTaxJpaMapper;
import com.inditex.price.content.infrastructure.repository.jpa.entity.PriceTaxJpa;
import com.inditex.price.content.infrastructure.repository.jpa.repository.PriceTaxRepositoryJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class FindPriceRepositoryImpl implements FindPriceRepository {

  private final PriceTaxRepositoryJpa priceTaxRepositoryJpa;
  private final PriceTaxJpaMapper priceTaxJpaMapper;

  @Override
  public PriceTax filterFinalPrice(PriceFilter filter) {

    PriceTaxJpa resultJpa = priceTaxRepositoryJpa.filterPrice(filter.getProductId(), filter.getBrandId(),
            filter.getApplicationDate())
        .orElseThrow(() -> new PriceTaxNotFoundException("Entity not found with params: " + filter));
    return priceTaxJpaMapper.toEntity(resultJpa);
  }
}

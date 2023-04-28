package com.inditex.price.content.application.impl;

import com.inditex.price.content.application.FindPriceUseCase;
import com.inditex.price.content.domain.entity.PriceFilter;
import com.inditex.price.content.domain.entity.PriceTax;
import com.inditex.price.content.domain.repository.FindPriceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindPriceUseCaseImpl implements FindPriceUseCase {

  private final FindPriceRepository findPriceRepository;

  @Override
  public PriceTax filterFinalPrice(PriceFilter filter) {

    return findPriceRepository.filterFinalPrice(filter);
  }
}

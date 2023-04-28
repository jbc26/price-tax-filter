package com.inditex.price.content.application;

import com.inditex.price.content.domain.entity.PriceFilter;
import com.inditex.price.content.domain.entity.PriceTax;

public interface FindPriceUseCase {

  PriceTax filterFinalPrice(PriceFilter filter);
}

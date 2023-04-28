package com.inditex.price.content.domain.repository;

import com.inditex.price.content.domain.entity.PriceFilter;
import com.inditex.price.content.domain.entity.PriceTax;

public interface FindPriceRepository {

  PriceTax filterFinalPrice(PriceFilter filter);
}

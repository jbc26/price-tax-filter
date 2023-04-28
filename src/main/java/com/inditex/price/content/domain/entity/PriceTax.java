package com.inditex.price.content.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class PriceTax {

  private Integer priceList;
  private Integer productId;
  private Integer brandId;
  private BigDecimal price;
  private String currency;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private Integer priority;
}

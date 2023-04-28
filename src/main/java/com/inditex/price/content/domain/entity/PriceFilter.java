package com.inditex.price.content.domain.entity;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PriceFilter {

  private Integer productId;
  private Integer brandId;
  private LocalDateTime applicationDate;
}

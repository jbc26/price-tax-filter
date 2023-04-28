package com.inditex.price.content.infrastructure.repository.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
@Table(name = "PRICES")
public class PriceTaxJpa {

  @Id
  @Column(name = "PRICE_LIST")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer priceList;

  @Column(name = "PRODUCT_ID")
  private Integer productId;

  @Column(name = "BRAND_ID")
  private Integer brandId;

  @Column(name = "PRICE")
  private BigDecimal price;

  @Column(name = "CURR")
  private String currency;

  @Column(name = "START_DATE")
  private LocalDateTime startDate;

  @Column(name = "END_DATE")
  private LocalDateTime endDate;

  @Column(name = "PRIORITY")
  private Integer priority;
}

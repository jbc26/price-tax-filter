package com.inditex.price.content.infrastructure.repository.jpa.repository;

import com.inditex.price.content.infrastructure.repository.jpa.entity.PriceTaxJpa;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceTaxRepositoryJpa extends JpaRepository<PriceTaxJpa, Integer> {

  @Query(value = "SELECT * FROM PRICES p "
      + " WHERE p.PRODUCT_ID = :productId AND p.BRAND_ID = :brandId"
      + " AND p.START_DATE <= :applicationDate AND p.END_DATE >= :applicationDate"
      + " ORDER BY PRIORITY DESC LIMIT 1", nativeQuery = true)
  Optional<PriceTaxJpa> filterPrice(
      @Param("productId") Integer productId,
      @Param("brandId") Integer brandId,
      @Param("applicationDate") LocalDateTime applicationDate);
}

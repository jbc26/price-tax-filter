package com.inditex.price.content.infrastructure.rest.dto.output;

import com.inditex.price.content.infrastructure.rest.constant.DateTimeFormatConstant;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Data
public class PriceOutputDto {

  @Schema(example = "2")
  private Integer priceList;

  @Schema(example = "35455")
  private Integer productId;

  @Schema(example = "1")
  private Integer brandId;

  @Schema(example = "20.23")
  private BigDecimal price;


  @Schema(example = "EUR")
  private String currency;

  @Schema(type = "string", pattern = DateTimeFormatConstant.DATE_TIME_PATTERN, example = "2020-06-14-10.00.00")
  @DateTimeFormat(pattern = DateTimeFormatConstant.DATE_TIME_FORMAT, iso = ISO.DATE_TIME)
  private LocalDateTime startDate;

  @Schema(type = "string", pattern = DateTimeFormatConstant.DATE_TIME_PATTERN, example = "2020-06-14-16.00.00")
  @DateTimeFormat(pattern = DateTimeFormatConstant.DATE_TIME_FORMAT, iso = ISO.DATE_TIME)
  private LocalDateTime endDate;
}

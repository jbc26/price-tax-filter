package com.inditex.price.content.infrastructure.rest.dto.input;

import com.inditex.price.content.infrastructure.rest.constant.DateTimeFormatConstant;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Data
public class PriceFilterInputDto {

  @NotNull
  @Schema(example = "35455")
  private Integer productId;

  @NotNull
  @Schema(example = "1")
  private Integer brandId;

  @NotNull
  @Parameter(
      description = "Date when the price is applied",
      schema =
      @Schema(type = "string", pattern = DateTimeFormatConstant.DATE_TIME_PATTERN, example = "2020-06-14-16.00.00"))
  @DateTimeFormat(pattern = DateTimeFormatConstant.DATE_TIME_FORMAT, iso = ISO.DATE_TIME)
  private LocalDateTime applicationDate;
}

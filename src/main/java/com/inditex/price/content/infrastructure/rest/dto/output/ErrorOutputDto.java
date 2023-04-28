package com.inditex.price.content.infrastructure.rest.dto.output;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ErrorOutputDto {

  @Default
  private LocalDateTime timestamp = LocalDateTime.now();
  private String message;
  private HttpStatus status;

  @JsonIgnore
  private Throwable exception;
}

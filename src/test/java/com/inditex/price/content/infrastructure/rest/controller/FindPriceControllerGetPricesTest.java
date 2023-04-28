package com.inditex.price.content.infrastructure.rest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@SpringBootTest
@AutoConfigureMockMvc
class FindPriceControllerGetPricesTest {

  private static final String URL_PATH = "/api/v1/prices";
  private static final Integer DEFAULT_PRODUCT_ID = 35455;
  private static final Integer DEFAULT_BRAND_ID = 1;

  private static final String PARAM_APPLICATION_DATE = "applicationDate";
  private static final String PARAM_PRODUCT_ID = "productId";
  private static final String PARAM_BRAND_ID = "brandId";

  private static final String JSON_PRICE_LIST = "$.priceList";
  private static final String JSON_PRODUCT_ID = "$.productId";
  private static final String JSON_BRAND_ID = "$.brandId";
  private static final String JSON_PRICE = "$.price";
  private static final String JSON_CURRENCY = "$.currency";
  private static final String JSON_START_DATE = "$.startDate";
  private static final String JSON_END_DATE = "$.endDate";

  private final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(
      "yyyy-MM-dd-HH.mm.ss");

  @Autowired
  private MockMvc mockMvc;

  // TEST 1
  @Test
  void getPricesByFilter_should_return_price_list_1_with_price_35_50_when_request_day_14_at_10()
      throws Exception {

    // GIVEN
    LocalDateTime applicationDate = LocalDateTime.of(2020, 06, 14, 10, 0, 0);

    // WHEN
    ResultActions result = sendRequest(DEFAULT_PRODUCT_ID, DEFAULT_BRAND_ID, applicationDate);

    // THEN
    checkValidResponse(result);
    result.andExpect(jsonPath(JSON_PRICE_LIST).value(1))
        .andExpect(jsonPath(JSON_PRICE).value(35.50));
  }

  // TEST 2
  @Test
  void getPricesByFilter_should_return_price_list_2_with_price_25_45_when_request_day_14_at_16()
      throws Exception {

    // GIVEN
    LocalDateTime applicationDate = LocalDateTime.of(2020, 06, 14, 16, 0, 0);

    // WHEN
    ResultActions result = sendRequest(DEFAULT_PRODUCT_ID, DEFAULT_BRAND_ID, applicationDate);

    // THEN
    checkValidResponse(result);
    result.andExpect(jsonPath(JSON_PRICE_LIST).value(2))
        .andExpect(jsonPath(JSON_PRICE).value(25.45));
  }

  // TEST 3
  @Test
  void getPricesByFilter_should_return_price_list_1_with_price_35_50_when_request_day_14_at_21()
      throws Exception {

    // GIVEN
    LocalDateTime applicationDate = LocalDateTime.of(2020, 06, 14, 21, 0, 0);

    // WHEN
    ResultActions result = sendRequest(DEFAULT_PRODUCT_ID, DEFAULT_BRAND_ID, applicationDate);

    // THEN
    checkValidResponse(result);
    result.andExpect(jsonPath(JSON_PRICE_LIST).value(1))
        .andExpect(jsonPath(JSON_PRICE).value(35.50));
  }

  // TEST 4
  @Test
  void getPricesByFilter_should_return_price_list_3_with_price_30_50_when_request_day_15_at_10()
      throws Exception {

    // GIVEN
    LocalDateTime applicationDate = LocalDateTime.of(2020, 06, 15, 10, 0, 0);

    // WHEN
    ResultActions result = sendRequest(DEFAULT_PRODUCT_ID, DEFAULT_BRAND_ID, applicationDate);

    // THEN
    checkValidResponse(result);
    result.andExpect(jsonPath(JSON_PRICE_LIST).value(3))
        .andExpect(jsonPath(JSON_PRICE).value(30.50));
  }

  // TEST 5
  @Test
  void getPricesByFilter_should_return_price_list_4_with_price_38_95_when_request_day_16_at_21()
      throws Exception {

    // GIVEN
    LocalDateTime applicationDate = LocalDateTime.of(2020, 06, 16, 21, 0, 0);

    // WHEN
    ResultActions result = sendRequest(DEFAULT_PRODUCT_ID, DEFAULT_BRAND_ID, applicationDate);

    // THEN
    checkValidResponse(result);
    result.andExpect(jsonPath(JSON_PRICE_LIST).value(4))
        .andExpect(jsonPath(JSON_PRICE).value(38.95));
  }

  @Test
  void getPricesByFilter_should_return_not_found_when_request_day_10_at_21()
      throws Exception {

    // GIVEN
    LocalDateTime applicationDate = LocalDateTime.of(2020, 06, 10, 21, 0, 0);

    // WHEN
    ResultActions result = sendRequest(DEFAULT_PRODUCT_ID, DEFAULT_BRAND_ID, applicationDate);

    // THEN
    result.andExpect(status().isNotFound());
  }

  @Test
  void getPricesByFilter_should_return_not_found_when_request_product_not_exist()
      throws Exception {

    // GIVEN
    LocalDateTime applicationDate = LocalDateTime.of(2020, 06, 16, 21, 0, 0);
    Integer productIdNotExist = 10;

    // WHEN
    ResultActions result = sendRequest(productIdNotExist, DEFAULT_BRAND_ID, applicationDate);

    // THEN
    result.andExpect(status().isNotFound());
  }

  @ParameterizedTest
  @ArgumentsSource(RequestParamWithSomeNull.class)
  void getPricesByFilter_should_return_bad_request_when_a_param_is_null(
      Integer productId, Integer brandId, LocalDateTime applicationDate)
      throws Exception {

    // GIVEN

    // WHEN
    ResultActions result = sendRequest(productId, brandId, applicationDate);

    // THEN
    result.andExpect(status().isBadRequest());
  }

  private ResultActions sendRequest(Integer productId, Integer brandId,
      LocalDateTime applicationDate) throws Exception {

    return this.mockMvc.perform(
        get(URL_PATH)
            .param(PARAM_PRODUCT_ID, Optional.ofNullable(productId)
                .map(Objects::toString)
                .orElse(null))
            .param(PARAM_BRAND_ID, Optional.ofNullable(brandId)
                .map(Objects::toString)
                .orElse(null))
            .param(PARAM_APPLICATION_DATE, Optional.ofNullable(applicationDate)
                .map(ad -> ad.format(DATE_TIME_FORMATTER))
                .orElse(null))
    );
  }

  private void checkValidResponse(ResultActions result) throws Exception {
    result.andExpect(status().isOk())
        .andExpect(jsonPath(JSON_CURRENCY).exists())
        .andExpect(jsonPath(JSON_START_DATE).exists())
        .andExpect(jsonPath(JSON_END_DATE).exists())
        .andExpect(jsonPath(JSON_PRICE).exists())
        .andExpect(jsonPath(JSON_PRICE_LIST).exists())
        .andExpect(jsonPath(JSON_BRAND_ID).exists())
        .andExpect(jsonPath(JSON_PRODUCT_ID).exists());
  }

  @NoArgsConstructor
  static class RequestParamWithSomeNull implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext)
        throws Exception {
      return Stream.of(
          Arguments.of(null, DEFAULT_BRAND_ID, LocalDateTime.of(2020, 06, 16, 21, 0, 0)),
          Arguments.of(DEFAULT_BRAND_ID, null, LocalDateTime.of(2020, 06, 16, 21, 0, 0)),
          Arguments.of(DEFAULT_BRAND_ID, DEFAULT_BRAND_ID, null)
      );

    }
  }
}
package com.inditex.price.content.infrastructure.rest.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DateTimeFormatConstant {

  public static final String DATE_TIME_FORMAT = "yyyy-MM-dd-HH.mm.ss";

  public static final String DATE_TIME_PATTERN = "^\\d{4}-\\d{2}-\\d{2}-\\d{2}\\.\\d{2}\\.\\d{2}$";
}

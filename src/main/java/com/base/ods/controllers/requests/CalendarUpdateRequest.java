package com.base.ods.controllers.requests;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CalendarUpdateRequest {
    @NotNull(message = "Id is required")
    Long id;
    @NotBlank(message = "Month information is required")
    String dateMonth;
    @NotBlank(message = "Year information is required")
    String dateYear;
    String days;
}

package com.base.ods.controllers.requests;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OutOfOfficeDayCreateRequest {
    @NotBlank(message = "Name is required")
    String displayName;
    @NotNull(message = "Date is required")
    Date date;
}

package com.base.ods.controllers.requests;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;
import java.util.Date;
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OutOfOfficeDayUpdateRequest {
    @NotNull(message = "Id is required")
    Long id;
    @NotNull(message = "Name is required")
    String displayName;
    @NotNull(message = "Date is required")
    Date date;
}

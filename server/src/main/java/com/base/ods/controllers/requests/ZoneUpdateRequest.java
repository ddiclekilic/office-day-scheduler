package com.base.ods.controllers.requests;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ZoneUpdateRequest {
    @NotNull(message = "Id is required")
    Long id;
    @NotBlank(message = "Zone name is required")
    String zoneName;
    @NotBlank(message = "Code is required")
    String code;
    @Min(value = 0, message = "Lower bound must be greater than or equal to 0")
    double lowerBound;
    @Min(value = 0, message = "Upper bound must be greater than or equal to 0")
    double upperBound;
    @Min(value = 0, message = "Price must be greater than or equal to 0")
    double price;
    @NotBlank(message = "Transport choice is required")
    String transportChoice;
}

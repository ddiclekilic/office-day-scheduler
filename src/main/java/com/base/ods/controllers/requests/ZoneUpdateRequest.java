package com.base.ods.controllers.requests;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ZoneUpdateRequest {
    Long id;
    String zoneName;
    String code;
    double lowerBound;
    double upperBound;
    double price;
    String transportChoice;
}

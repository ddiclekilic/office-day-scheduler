package com.base.ods.controllers.responses;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ZoneResponse {
    Long id;
    String zoneName;
    String code;
    double lowerBound;
    double upperBound;
    double price;
    String transportChoice;
}

package com.base.ods.services.requests;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ZoneCreateRequestDTO {
    String zoneName;
    String code;
    double lowerBound;
    double upperBound;
    double price;
    String transportChoice;
}

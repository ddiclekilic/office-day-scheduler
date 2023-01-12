package com.base.ods.services.responses;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ZoneResponseDTO {
    Long id;
    String zoneName;
    String code;
    double lowerBound;
    double upperBound;
    double price;
    String transportChoice;
}

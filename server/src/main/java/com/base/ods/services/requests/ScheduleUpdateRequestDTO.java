package com.base.ods.services.requests;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ScheduleUpdateRequestDTO {
    Long id;
    double officeDay;
    double vacation;
    double workFromHome;
    double totalDay;
    double report;
    String dateMonth;
    String dateYear;
}

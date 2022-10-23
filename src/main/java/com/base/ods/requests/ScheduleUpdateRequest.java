package com.base.ods.requests;

import lombok.Data;

@Data
public class ScheduleUpdateRequest {
    double officeDay;
    double vacation;
    double workFromHome;
    double totalDay;
    double report;
    String dateMonth;
    String dateYear;
}

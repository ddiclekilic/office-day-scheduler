package com.base.ods.requests;

import lombok.Data;

@Data
public class ScheduleCreateRequest {
    Long userId;
    double officeDay;
    double vacation;
    double workFromHome;
    double totalDay;
    double report;
    String dateMonth;
    String dateYear;
}

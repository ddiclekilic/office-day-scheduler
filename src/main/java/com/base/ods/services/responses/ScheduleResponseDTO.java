package com.base.ods.services.responses;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ScheduleResponseDTO {
    Long id;
    Long userId;
    String userFirstName;
    String userLastName;
    String registrationNumber;
    String userEmail;
    double officeDay;
    double vacation;
    double workFromHome;
    double totalDay;
    double report;
    String dateMonth;
    String dateYear;
}

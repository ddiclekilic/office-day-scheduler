package com.base.ods.controllers.responses;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CalendarResponse {
    Long id;
    Long userId;
    String registrationNumber;
    String userFirstName;
    String userLastName;
    String userEmail;
    String dateMonth;
    String dateYear;
    String days;
    String userStatus;
    int officeDay;
}

package com.base.ods.requests;

import lombok.Data;

@Data
public class CalendarCreateRequest {
    Long userId;
    String dateMonth;
    String dateYear;
    String days;
}

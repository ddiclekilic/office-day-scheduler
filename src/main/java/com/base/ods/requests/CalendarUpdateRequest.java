package com.base.ods.requests;

import lombok.Data;

@Data
public class CalendarUpdateRequest {
    String dateMonth;
    String dateYear;
    String days;
}

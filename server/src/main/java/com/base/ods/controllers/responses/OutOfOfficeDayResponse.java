package com.base.ods.controllers.responses;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OutOfOfficeDayResponse {
    Long id;
    String displayName;
    Date date;
}

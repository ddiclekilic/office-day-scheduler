package com.base.ods.services.requests;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OutOfOfficeDayUpdateRequestDTO {
    Long id;
    String displayName;
    Date date;
}

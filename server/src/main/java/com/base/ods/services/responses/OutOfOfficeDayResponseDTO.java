package com.base.ods.services.responses;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OutOfOfficeDayResponseDTO {
    Long id;
    String displayName;
    Date date;
}

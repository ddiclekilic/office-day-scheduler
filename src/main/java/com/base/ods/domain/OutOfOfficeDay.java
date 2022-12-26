package com.base.ods.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "out_of_office_day")
public class OutOfOfficeDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    @NotBlank(message = "Name is mandatory")
    String displayName;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull(message = "Date is mandatory")
    Date date;
}

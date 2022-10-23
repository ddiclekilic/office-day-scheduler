package com.base.ods.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="out_of_office_day")
public class OutOfOfficeDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String displayName;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    Date date;
}

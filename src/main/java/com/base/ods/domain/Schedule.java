package com.base.ods.domain;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="user_id", nullable = false)
    User user;
    @Column(nullable = false)
    @Min(value = 0)
    double officeDay;
    @Column(nullable = false)
    @Min(value = 0)
    double vacation;
    @Column(nullable = false)
    @Min(value = 0)
    double workFromHome;
    @Column(nullable = false)
    @Min(value = 0)
    double totalDay;
    @Column(nullable = false)
    @Min(value = 0)
    double report;
    @Column(nullable = false)
    @NotBlank(message = "Month information is mandatory")
    String dateMonth;
    @Column(nullable = false)
    @NotBlank(message = "Year information is mandatory")
    String dateYear;
}

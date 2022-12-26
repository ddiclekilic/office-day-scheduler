package com.base.ods.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "calendar")
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    User user;
    @Column(nullable = false)
    @NotBlank(message = "Month information is mandatory")
    String dateMonth;
    @Column(nullable = false)
    @NotBlank(message = "Year information is mandatory")
    String dateYear;
    @Column(nullable = false)
    @NotBlank(message = "Days are mandatory")
    String days;
}

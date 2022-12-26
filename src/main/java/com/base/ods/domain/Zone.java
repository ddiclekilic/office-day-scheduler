package com.base.ods.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "zone")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    @NotBlank(message = "Name is mandatory")
    String zoneName;
    @Column(nullable = false)
    @NotBlank(message = "Code is mandatory")
    String code;
    @Column(nullable = false)
    @Min(value = 0)
    double lowerBound;
    @Column(nullable = false)
    @Min(value = 0)
    double upperBound;
    @Column(nullable = false)
    @Min(value = 0)
    double price;
    @Column(nullable = false)
    @NotBlank(message = "Transport choice is mandatory")
    String transportChoice;
}

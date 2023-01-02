package com.base.ods.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Entity
@Table(name = "zone")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String zoneName;
    @Column(nullable = false)
    String code;
    @Column(nullable = false)
    double lowerBound;
    @Column(nullable = false)
    double upperBound;
    @Column(nullable = false)
    double price;
    @Column(nullable = false)
    String transportChoice;
}

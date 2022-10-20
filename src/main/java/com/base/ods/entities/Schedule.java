package com.base.ods.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    //ondelete action
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id", nullable = false)
    @JsonIgnore
    User user;
    //Long userId;
    @Column(nullable = false)
    double officeDay;
    @Column(nullable = false)
    double vacation;
    @Column(nullable = false)
    double workFromHome;
    @Column(nullable = false)
    double totalDay;
    @Column(nullable = false)
    double report;
    @Column(nullable = false)
    String dateMonth;
    @Column(nullable = false)
    String dateYear;
}

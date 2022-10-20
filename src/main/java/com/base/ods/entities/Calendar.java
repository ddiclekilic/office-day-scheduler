package com.base.ods.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="calendar")
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    //ondelete action
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id", nullable = false)
    @JsonIgnore
    User user;
    @Column(nullable = false)
    String dateMonth;
    @Column(nullable = false)
    String dateYear;
    @Column(nullable = false)
    String days;
}

package com.base.ods.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String departmentCode;
    @Column(nullable = false) //unique
    String groupCode;
    //ondelete action
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="department_manager_id", unique = true) // unique???? nullable = false kaldirildi
    @JsonIgnore
    User departmentManager;
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="group_manager_id", unique = true) //nullable = false kaldirildi
    @JsonIgnore
    User groupManager;
}

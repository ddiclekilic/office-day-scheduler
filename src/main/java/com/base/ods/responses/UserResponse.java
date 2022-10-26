package com.base.ods.responses;

import com.base.ods.domain.User;
import lombok.Data;

@Data
public class UserResponse {
    Long id;
    Long registrationNumber;
    String firstName;
    String lastName;
    String email;
    Long departmentId;
    Long zoneId;
    String transportChoice;
    Long roleId;
    public UserResponse(User entity){
        this.id=entity.getId();
        this.registrationNumber=entity.getRegistrationNumber();
        this.firstName=entity.getFirstName();
        this.lastName=entity.getLastName();
        this.email=entity.getEmail();
        this.departmentId=entity.getDepartment().getId();
        this.zoneId=entity.getZone().getId();
        this.transportChoice=entity.getTransportChoice();
        this.roleId=entity.getRole().getId();
    }
}

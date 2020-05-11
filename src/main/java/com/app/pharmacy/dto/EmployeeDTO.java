package com.app.pharmacy.dto;

import com.app.pharmacy.model.RoleEnum;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Chris Tzelis
 */
public class EmployeeDTO extends PersonDTO{

    @NotNull
    private RoleEnum role;

    public EmployeeDTO() {
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    
    
    
}

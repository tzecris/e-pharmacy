package com.app.pharmacy.dto;

import com.app.pharmacy.model.RoleEnum;

/**
 *
 * @author Chris Tzelis
 */
public class SecurityUser {

    private String username;
    private String password;
    private RoleEnum role;
    private String fullName;

    public SecurityUser() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}

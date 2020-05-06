package com.app.pharmacy.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PersonDTO {

    private Integer personId;

    private String firstName;

    private String lastName;

    @NotNull
    @Size(min = 1, max = 45)
    private String email;

    @NotNull
    @Size(min = 1, max = 45)
    private String username;

    private int phoneNumber;

    @NotNull
    @Size(min = 1, max = 45)
    private String password;

    private AddressDTO address;

    public PersonDTO() {
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

}

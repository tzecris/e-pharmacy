package com.app.pharmacy.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

    private Integer personId;

    @NotNull
    @Size(min = 1, max = 45)
    private String firstName;

    @NotNull
    @Size(min = 1, max = 45)
    private String lastName;

    @NotNull
    @Size(min = 1, max = 45)
    private String email;

    @NotNull
    @Size(min = 1, max = 45)
    private String username;

    @NotNull
    private int phoneNumber;

    @NotNull
    @Size(min = 1, max = 45)
    private String password;
}

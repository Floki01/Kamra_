package com.cb.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;

    @NotEmpty(message = "Please enter valid name.")
    private String name;

    @NotEmpty(message = "Please enter valid email.")
    @Email
    private String email;

    @NotEmpty(message = "Please enter valid password.")
    private String password;

    @NotEmpty
    private String fNacimiento;

    @NotEmpty
    private String telefono;

    public UserDto( String name,
            String email,
           String password,String fNacimiento,
            String telefono) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.fNacimiento = fNacimiento;
        this.telefono = telefono;
    }

    
}

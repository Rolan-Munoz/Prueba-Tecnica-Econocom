package com.prueba.econocom.application.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable
{
    private Long id;
    private String email;
    private String password; // Hash BCrypt


    public UserDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }
}

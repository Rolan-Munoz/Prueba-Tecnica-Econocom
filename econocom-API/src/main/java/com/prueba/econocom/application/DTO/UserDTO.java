// DTO de usuario
// Este DTO es utilizado para representar un usuario en la aplicación, incluyendo su ID, correo electrónico y contraseña.
// Este DTO es utilizado para prevenir problemas de seguridad al no exponer directamente la entidad User.

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
    private String password;


    public UserDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }
}

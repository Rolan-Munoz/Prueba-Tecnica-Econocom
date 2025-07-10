// DTO de autenticación
// Este DTO es utilizado para recibir las credenciales de autenticación del usuario, de esta manera nos prevenimos
// de diferentes problemas de seguridad al no mostrar directamente nuestra entidad User

package com.prueba.econocom.application.DTO;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class AuthRequestDTO implements Serializable{

    private String email;
    private String password;

    public AuthRequestDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

}

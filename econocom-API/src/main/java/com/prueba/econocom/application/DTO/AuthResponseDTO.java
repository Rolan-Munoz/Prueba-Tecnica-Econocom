// DTO de respuesta de autenticación
// Este DTO es utilizado para enviar la respuesta de autenticación al cliente, incluyendo el token de acceso y el tipo de token.
package com.prueba.econocom.application.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
public class AuthResponseDTO implements Serializable {
    private String accessToken;
    private String tokenType = "Bearer";
    private String email;

    public AuthResponseDTO(String accessToken, String email) {
        this.accessToken = accessToken;
        this.email = email;
    }
}

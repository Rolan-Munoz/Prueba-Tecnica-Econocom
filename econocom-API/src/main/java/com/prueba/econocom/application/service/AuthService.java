// Interfaz de servicio para la autenticación
// Esta interfaz define los métodos necesarios para autenticar a un usuario, validar un token y cerrar sesión.
// Será implementada por la clase AuthServiceImpl. De esta manera logramos tener un código más desacoplado, limpio y
// mantenible.
package com.prueba.econocom.application.service;

import com.prueba.econocom.application.DTO.AuthRequestDTO;
import com.prueba.econocom.application.DTO.AuthResponseDTO;

public interface AuthService {

    AuthResponseDTO authenticateUser(AuthRequestDTO authRequest);

    boolean validateToken(String token);

    void logout(String token);



}

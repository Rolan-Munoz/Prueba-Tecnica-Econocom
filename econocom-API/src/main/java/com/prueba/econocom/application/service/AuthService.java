package com.prueba.econocom.application.service;

import com.prueba.econocom.application.DTO.AuthRequestDTO;
import com.prueba.econocom.application.DTO.AuthResponseDTO;

public interface AuthService {

    AuthResponseDTO authenticateUser(AuthRequestDTO authRequest);

    boolean validateToken(String token);

    void logout(String token);



}

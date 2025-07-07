package com.prueba.econocom.application.service.impl;

import com.prueba.econocom.application.DTO.AuthRequestDTO;
import com.prueba.econocom.application.DTO.AuthResponseDTO;
import com.prueba.econocom.application.service.AuthService;
import com.prueba.econocom.config.JwtTokenUtil;
import com.prueba.econocom.domain.entity.User;
import com.prueba.econocom.domain.presistence.UserPersistence;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserPersistence userPersistence;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtTokenUtil;


    public AuthServiceImpl(UserPersistence userPersistence, PasswordEncoder passwordEncoder, JwtTokenUtil jwtTokenUtil) {
        this.userPersistence = userPersistence;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    public AuthResponseDTO authenticateUser(AuthRequestDTO authRequest) {
        User user = userPersistence.findByEmail(authRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found with email: " + authRequest.getEmail()));
        if (!passwordEncoder.matches(authRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password for user: " + authRequest.getEmail());
        }

        String token = jwtTokenUtil.generateToken(authRequest.getEmail());
        user.setToken(token);
        userPersistence.updateUserToken(user);

        return new AuthResponseDTO(token, user.getEmail());
    }

    @Override
    public boolean validateToken(String token) {
        boolean isTokenValid = jwtTokenUtil.validateToken(token);
        if (isTokenValid) {
            return userPersistence.findByToken(token).isPresent();
        }
        return false;
    }

    @Override
    public void logout(String token) {
        userPersistence.findByToken(token).ifPresent(user -> {
            user.setToken(null);
            userPersistence.updateUserToken(user);
        });
    }
}

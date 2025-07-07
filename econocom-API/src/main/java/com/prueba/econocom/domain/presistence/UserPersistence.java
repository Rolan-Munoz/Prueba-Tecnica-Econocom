package com.prueba.econocom.domain.presistence;

import com.prueba.econocom.domain.entity.User;

import java.util.Optional;

public interface UserPersistence {
    // Métodos esenciales para autenticación JWT
    Optional<User> findByEmail(String email);
    User save(User user);

}

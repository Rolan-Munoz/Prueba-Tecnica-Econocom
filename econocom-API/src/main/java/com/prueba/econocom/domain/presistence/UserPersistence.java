// Interfaz de persistencia para la entidad User
// Esta interfaz define los métodos necesarios para interactuar con la base de datos y además, la desacoplamos
// de su implementación, asi como del repositorio de Spring Data JPA.
package com.prueba.econocom.domain.presistence;

import com.prueba.econocom.domain.entity.User;

import java.util.Optional;

public interface UserPersistence {
    Optional<User> findByEmail(String email);
    User save(User user);

}

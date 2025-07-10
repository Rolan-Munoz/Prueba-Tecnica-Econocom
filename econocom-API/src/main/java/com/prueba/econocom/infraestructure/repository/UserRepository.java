// Interfaz de repositorio para la entidad User
// Esta interfaz extiende JpaRepository, lo que proporciona métodos CRUD básicos para la entidad User.

package com.prueba.econocom.infraestructure.repository;

import com.prueba.econocom.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByEmail(String email);

}

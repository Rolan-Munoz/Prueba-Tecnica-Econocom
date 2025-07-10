// Data Inizializer.java
// Esta clase se ejecuta al iniciar la aplicación y crea dos usuarios de prueba que sirve para testear la autenticación JWT.
// Funciona comprobandop en primer lugar la existencia de dichos registros y en caso de no existir los crea con un password encriptado.
package com.prueba.econocom.config;

import com.prueba.econocom.domain.entity.User;
import com.prueba.econocom.domain.presistence.UserPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserPersistence userPersistence;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        createUserIfNotExists("user1@test.com", "pass1");
        createUserIfNotExists("user2@test.com", "pass2");
    }

    private void createUserIfNotExists(String email, String password) {
        if (!userPersistence.findByEmail(email).isPresent()) {
            User user = new User();
            user.setEmail(email);
            user.setPassword(passwordEncoder.encode(password));
            userPersistence.save(user);
            System.out.println("Usuario creado: " + email);
        }
    }
}
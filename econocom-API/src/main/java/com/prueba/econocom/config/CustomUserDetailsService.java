// Clase para manejar la autenticación de usuarios en Spring Security
// Esta clase implementa la interfaz UserDetailsService de Spring Security
// EL objetivo de la misma es cargar los detalles del usuario por su email.

package com.prueba.econocom.config;

import com.prueba.econocom.domain.entity.User;
import com.prueba.econocom.domain.presistence.UserPersistence;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserPersistence userPersistence;

    public CustomUserDetailsService(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userPersistence.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .authorities("USER")
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}


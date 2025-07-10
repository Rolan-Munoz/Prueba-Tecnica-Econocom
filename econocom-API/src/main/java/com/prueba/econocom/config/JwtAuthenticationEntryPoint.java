// Clase para manejar la autenticación de usuarios y posicionar la respuesta de error en caso
// de token inválido o
// Esta clase implementa la interfaz AuthenticationEntryPoint de Spring Security y actúa como punto de
// entrada para manejar posibles excepciones

package com.prueba.econocom.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write(
                "{\"error\": \"Unauthorized\", \"message\": \"Token inválido o faltante\"}"
        );
    }
}

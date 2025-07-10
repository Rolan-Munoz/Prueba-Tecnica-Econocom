// Clase de entidad de USER
// Se usa una serie de anotaciones de lombok para simplificar el código, asi como anotaciones específicas para la
// creación de la tabla en la base de datos

package com.prueba.econocom.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@Entity
@Table(name = "USERS")
@Getter @Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 100)
    private String password;


    private String token;


}

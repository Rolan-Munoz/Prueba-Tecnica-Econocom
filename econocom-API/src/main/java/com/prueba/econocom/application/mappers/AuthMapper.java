// Mapper de autenticación
// Con este mapper buscamos convertir adecuadamente los DTO en entidad USER y viceversa.


package com.prueba.econocom.application.mappers;

import com.prueba.econocom.application.DTO.AuthRequestDTO;
import com.prueba.econocom.application.DTO.AuthResponseDTO;
import com.prueba.econocom.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "token", ignore = true)
    @Mapping(target = "password", ignore = true)
    User authRequestToUser(AuthRequestDTO authRequestDTO);

    @Mapping(source = "email", target = "email")
    @Mapping(source = "token", target = "accessToken")
    AuthResponseDTO toAuthResponseDTO(User user);
}

package com.prueba.econocom.application.mappers;

import com.prueba.econocom.application.DTO.UserDTO;
import com.prueba.econocom.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // De Entidad a DTO (ocultamos el password)
    @Mapping(target = "password", ignore = true)
    UserDTO toDto(User user);

    // De DTO a Entidad
    @Mapping(target = "token", ignore = true) // El token se genera después
    User toEntity(UserDTO userDTO);
}

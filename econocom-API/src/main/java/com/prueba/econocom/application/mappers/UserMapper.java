// Mapper de User
// Este mapper se usa para convertir entre la entidad User y el DTO UserDTO.

package com.prueba.econocom.application.mappers;

import com.prueba.econocom.application.DTO.UserDTO;
import com.prueba.econocom.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {


    @Mapping(target = "password", ignore = true)
    UserDTO toDto(User user);


    @Mapping(target = "token", ignore = true)
    User toEntity(UserDTO userDTO);
}

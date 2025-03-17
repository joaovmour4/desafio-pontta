package com.pontta.hardware_shopping.mappers;

import org.mapstruct.Mapper;

import com.pontta.hardware_shopping.dto.UserDto;
import com.pontta.hardware_shopping.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto userToUserDto(User user);
    
}

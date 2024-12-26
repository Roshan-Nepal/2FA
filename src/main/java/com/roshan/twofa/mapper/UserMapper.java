package com.roshan.twofa.mapper;

import com.roshan.twofa.dto.responsedto.UserResponseDto;
import com.roshan.twofa.entity.Users;

public class UserMapper {
    public static UserResponseDto userToUserDto(Users user){
        return  UserResponseDto.builder().id(user.getId()).username(user.getUsername()).roles(user.getRoles()).build();
    }
}

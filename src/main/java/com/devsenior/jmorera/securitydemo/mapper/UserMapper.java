package com.devsenior.jmorera.securitydemo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.devsenior.jmorera.securitydemo.model.dto.CreateUserDto;
import com.devsenior.jmorera.securitydemo.model.dto.RegisterRequestDto;
import com.devsenior.jmorera.securitydemo.model.dto.UpdateUserDto;
import com.devsenior.jmorera.securitydemo.model.dto.UserResponseDto;
import com.devsenior.jmorera.securitydemo.model.entity.RoleEntity;
import com.devsenior.jmorera.securitydemo.model.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target= "hireDate", ignore= true)
    @Mapping(target= "active", ignore= true)
    @Mapping(target= "roles", ignore= true)
    UserEntity toEntity(CreateUserDto dto);

    @Mapping(target= "password", ignore= true)
    @Mapping(target= "hireDate", ignore= true)
    @Mapping(target= "active", ignore= true)
    @Mapping(target= "roles", ignore= true)
    UserEntity toEntity(UpdateUserDto dto);

    @Mapping(target= "hireDate", ignore= true)
    @Mapping(target= "active", ignore= true)
    @Mapping(target= "roles", ignore= true)
    UserEntity toEntity(RegisterRequestDto dto);

    UserResponseDto toResponse(UserEntity entity);

    default String roleToString (RoleEntity role){
       return (role==null) ? "" : role.getName();


    }
}

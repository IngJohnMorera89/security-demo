package com.devsenior.jmorera.securitydemo.service;

import java.util.List;

import com.devsenior.jmorera.securitydemo.model.dto.CreateUserDto;
import com.devsenior.jmorera.securitydemo.model.dto.UpdateUserDto;
import com.devsenior.jmorera.securitydemo.model.dto.UserResponseDto;

public interface  UserService {

    List<UserResponseDto> getAll();

    UserResponseDto create(CreateUserDto dto);

    UserResponseDto update(UpdateUserDto dto);

    void active(String username);

    void deactive(String username);

    
}

package com.devsenior.jmorera.securitydemo.service;

import com.devsenior.jmorera.securitydemo.model.dto.LoginRequestDto;
import com.devsenior.jmorera.securitydemo.model.dto.LoginResponseDto;
import com.devsenior.jmorera.securitydemo.model.dto.RegisterRequestDto;



public interface AuthService {

    LoginResponseDto login(LoginRequestDto credentials);

    void register(RegisterRequestDto info);
    
}

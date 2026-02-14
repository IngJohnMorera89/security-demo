package com.devsenior.jmorera.securitydemo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsenior.jmorera.securitydemo.mapper.UserMapper;
import com.devsenior.jmorera.securitydemo.model.dto.LoginRequestDto;
import com.devsenior.jmorera.securitydemo.model.dto.LoginResponseDto;
import com.devsenior.jmorera.securitydemo.model.dto.RegisterRequestDto;
import com.devsenior.jmorera.securitydemo.model.entity.RoleEntity;
import com.devsenior.jmorera.securitydemo.repository.RoleRepository;
import com.devsenior.jmorera.securitydemo.repository.UserRepository;
import com.devsenior.jmorera.securitydemo.util.JwtUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;


    @Override
    @Transactional(readOnly = true)
    public LoginResponseDto login(LoginRequestDto credentials) {
        try{
        var auth =new UsernamePasswordAuthenticationToken(credentials.username(), credentials.password());
        authenticationManager.authenticate(auth);
        } catch(BadCredentialsException e) {
             throw new RuntimeException("Credenciales invalidas");

        }

        var user = userRepository.findById(credentials.username()).get();
        

        var token = jwtUtils.generateToken(credentials.username(), Map.of(
                "email", user.getEmail(),
                "name" , user.getName(),
                "hire_date",user.getHireDate().format(DateTimeFormatter.BASIC_ISO_DATE),
                "roles", user.getRoles().stream()
                        .map(RoleEntity::getName)
                        .toList()));
     
        return new LoginResponseDto(token, "JWT"); 
     }      
    @Override
    public void register(RegisterRequestDto info) {

        if(userRepository.existsById(info.username())){
            throw new RuntimeException(
               String.format ("El nombre de Usuario '%s' ya existe", info.username()));

        }
      
        var user = userMapper.toEntity(info);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        user.setHireDate(LocalDate.now());
        user.setActive(true);

        var role =roleRepository.findByName("admin")
        .orElseThrow(() -> new RuntimeException("El rol User no existe en el sistema"));
        user.setRoles(List.of(role));

        userRepository.save(user);
    }

}


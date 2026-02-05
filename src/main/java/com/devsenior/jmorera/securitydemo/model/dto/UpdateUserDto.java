package com.devsenior.jmorera.securitydemo.model.dto;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record UpdateUserDto(
    
    @NotEmpty(message= "El campo de Usuario es Obligatorio")
    String username, 
    
    @NotEmpty(message= "El email es Obligatorio")
    @Email(message= "El correo Electronico no es valido")
    String email, 
    
    String name,

    @NotEmpty(message="Los roles son obligatorios")
    List<String> roles){

}

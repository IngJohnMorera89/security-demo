package com.devsenior.jmorera.securitydemo.model.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record RegisterRequestDto(
    
    @NotEmpty(message= "El campo de Usuario es Obligatorio")
    String username, 
    
    @Size(min=6, message="La contraseña debe tener minimo 6 caracteres")
    @NotEmpty(message= "El campo de Contraseña es Obligatorio")
    String password, 

    @NotEmpty(message= "El email es Obligatorio")
    @Email(message= "El correo Electronico no es valido")
    String email, 
    
    String name) {



}

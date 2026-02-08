package com.devsenior.jmorera.securitydemo.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequestDto(

    @NotBlank(message = "El nombre de usuario es obligatorio")
    String username,

     @NotBlank(message = "La contraseña es Obligatoria")
     @Size(min= 6, message ="La contraseña debe contener minimo 6 caracteres")
    String password
) {
    
}

package com.devsenior.jmorera.securitydemo.model.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;


public record UserResponseDto(

    
    String username,

    String password,

    String email,

    String name,

    @JsonFormat(shape= Shape.STRING, pattern= "yyy-MM-dd")
    @JsonProperty("hire_date")
    LocalDate hireDate,

    Boolean active,

    List<String> roles) {

}

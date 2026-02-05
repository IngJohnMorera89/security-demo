package com.devsenior.jmorera.securitydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsenior.jmorera.securitydemo.model.entity.UserEntity;

public interface  UserRepository extends JpaRepository<UserEntity, String>{
    
}

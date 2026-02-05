package com.devsenior.jmorera.securitydemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsenior.jmorera.securitydemo.model.entity.RoleEntity;

public interface  RoleRepository extends JpaRepository<RoleEntity, Long> {

    Optional<RoleEntity> findByName(String  name);

}

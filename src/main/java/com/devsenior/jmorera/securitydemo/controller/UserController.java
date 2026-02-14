package com.devsenior.jmorera.securitydemo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.jmorera.securitydemo.model.dto.CreateUserDto;
import com.devsenior.jmorera.securitydemo.model.dto.UpdateUserDto;
import com.devsenior.jmorera.securitydemo.model.dto.UserResponseDto;
import com.devsenior.jmorera.securitydemo.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;




@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserResponseDto> getAll() {
        return userService.getAll();
    }
@PreAuthorize("hasRole('admin')") 
@ResponseStatus(code = HttpStatus.CREATED)
@PostMapping
public UserResponseDto create(@RequestBody @Valid CreateUserDto dto) {

    return userService.create(dto);
}

@PreAuthorize("hasRole('admin') or principal.username == #username")
@PutMapping("/{username}")
public UserResponseDto updatee(@PathVariable String username, @RequestBody @Valid UpdateUserDto dto) {

    return userService.update(dto);
}


@PreAuthorize("hasRole('admin')") 
@ResponseStatus(code =HttpStatus.NO_CONTENT)
@PatchMapping("/{username}/active")
public void active(@PathVariable String username){
    userService.active(username);

}

@PreAuthorize("hasRole('admin') or principal.username == #username")
@ResponseStatus(code =HttpStatus.NO_CONTENT)
@PatchMapping("/{username}/deactive")
public void dective(@PathVariable String username){
    userService.deactive(username);

}





}

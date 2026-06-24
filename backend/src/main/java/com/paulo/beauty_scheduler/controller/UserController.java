package com.paulo.beauty_scheduler.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.paulo.beauty_scheduler.dto.CreateUserDto;
import com.paulo.beauty_scheduler.dto.UpdateUserDto;
import com.paulo.beauty_scheduler.dto.UserResponseDto;
import com.paulo.beauty_scheduler.entity.User;
import com.paulo.beauty_scheduler.service.UserService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserResponseDto> getAllUsers() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public UserResponseDto getUserById(@PathVariable Long id) {
        return service.getByid(id);
    }

    @PostMapping
    public UserResponseDto createUser(@RequestBody @Valid CreateUserDto dto) {
        return service.create(dto);
    }
    
    @PatchMapping("/{id}")
    public UserResponseDto putUser(@PathVariable Long id, @RequestBody @Valid UpdateUserDto dto) {
        return service.patch(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

package com.paulo.beauty_scheduler.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

import com.paulo.beauty_scheduler.dto.CreateUserDto;
import com.paulo.beauty_scheduler.entity.User;
import com.paulo.beauty_scheduler.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<User> getAllUsers() {
        return service.getAll();
    }

    @PostMapping
    public User createUser(@RequestBody CreateUserDto dto) {
        return service.create(dto);
    }
    
    
}

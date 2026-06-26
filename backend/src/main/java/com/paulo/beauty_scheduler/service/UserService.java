package com.paulo.beauty_scheduler.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.paulo.beauty_scheduler.dto.CreateUserDto;
import com.paulo.beauty_scheduler.dto.UpdateUserDto;
import com.paulo.beauty_scheduler.dto.UserResponseDto;
import com.paulo.beauty_scheduler.entity.User;
import com.paulo.beauty_scheduler.enums.UserRole;
import com.paulo.beauty_scheduler.mapper.UserMapper;
import com.paulo.beauty_scheduler.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository repository;
    private final UserMapper mapper;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, UserMapper mapper, BCryptPasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserResponseDto> getAll() {
        // get all users
        List<User> users = repository.findAll();

        // all user response dtos
        List<UserResponseDto> responseUsers = new ArrayList<>();

        for (User user : users) {
            responseUsers.add(mapper.toResponseDto(user));
        }

        return responseUsers;
    }

    public UserResponseDto getByid(Long id) {
        // get user by id
        User user = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("user not found"));

        return mapper.toResponseDto(user);
    }

    public UserResponseDto create(CreateUserDto dto) {
        User user = createUser(dto, Set.of(UserRole.CUSTOMER));

        return mapper.toResponseDto(user);
    }

    public User createUser(CreateUserDto dto, Set<UserRole> roles) {
        if (repository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email already exists.");
        }

        // tranform dto to object
        User user = mapper.toEntity(dto);

        // set crypted password
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        // set user role
        user.setRoles(roles);

        // save user in database
        return repository.save(user);
    }

    public UserResponseDto patch(Long id, UpdateUserDto dto) {
        // get user by id
        User user = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("user not found"));
        
        // it use mapper to set all dto attributes in the user object
        mapper.updateUserFromDto(dto, user);
        
        return mapper.toResponseDto(user);
    }

    public void delete(Long id) {
        // delete user by id
        repository.deleteById(id);
    }
}
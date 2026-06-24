package com.paulo.beauty_scheduler.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.paulo.beauty_scheduler.dto.CreateUserDto;
import com.paulo.beauty_scheduler.dto.UpdateUserDto;
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

    public List<User> getAll() {
        // getting all users
        return repository.findAll();
    }

    public Optional<User> getByid(Long id) {
        return repository.findById(id);
    }

    public User create(CreateUserDto dto) {
        // dto to object
        User user = mapper.toEntity(dto);

        // setting crypted password
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        // setting user role
        user.setRole(UserRole.CUSTOMER);

        // saving user in database
        return repository.save(user);
    }

    public User patch(Long id, UpdateUserDto dto) {
        User user = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));

        mapper.updateUserFromDto(dto, user);

        return user;
    }
}

package com.paulo.beauty_scheduler.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.paulo.beauty_scheduler.dto.CreateUserDto;
import com.paulo.beauty_scheduler.entity.User;
import com.paulo.beauty_scheduler.mapper.UserMapper;
import com.paulo.beauty_scheduler.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    public UserService(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    public User create(CreateUserDto dto) {
        User user = mapper.toEntity(dto);

        return repository.save(user);
    }
}

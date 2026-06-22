package com.paulo.beauty_scheduler.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.paulo.beauty_scheduler.entity.User;
import com.paulo.beauty_scheduler.repository.UserRepository;

@Service
public class UserService {
    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAll() {
        return repository.findAll();
    }
}

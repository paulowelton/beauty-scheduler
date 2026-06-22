package com.paulo.beauty_scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paulo.beauty_scheduler.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {    
}

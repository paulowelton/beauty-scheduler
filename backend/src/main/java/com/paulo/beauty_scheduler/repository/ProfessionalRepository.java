package com.paulo.beauty_scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paulo.beauty_scheduler.entity.Professional;
import com.paulo.beauty_scheduler.entity.User;

public interface ProfessionalRepository extends JpaRepository<Professional, Long> {
    boolean existsByUser(User user);
}

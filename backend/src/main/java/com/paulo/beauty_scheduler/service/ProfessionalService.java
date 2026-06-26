package com.paulo.beauty_scheduler.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.paulo.beauty_scheduler.dto.CreateUserDto;
import com.paulo.beauty_scheduler.dto.UserResponseDto;
import com.paulo.beauty_scheduler.entity.Professional;
import com.paulo.beauty_scheduler.entity.User;
import com.paulo.beauty_scheduler.enums.UserRole;
import com.paulo.beauty_scheduler.mapper.UserMapper;
import com.paulo.beauty_scheduler.repository.ProfessionalRepository;
import com.paulo.beauty_scheduler.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProfessionalService {
    
    private final ProfessionalRepository professionalRepository;
    private final UserRepository userRepository;
    private final UserService userService;
    private final UserMapper userMapper;

    @Transactional
    public UserResponseDto create(CreateUserDto dto) {
        // create user with professional role
        User user = userService.createUser(dto, Set.of(UserRole.PROFESSIONAL));

        // instantiate a new professional
        Professional professional = new Professional();

        // set a user in professional
        professional.setUser(user);
        
        // save in database
        professionalRepository.save(professional);
        
        // return the user response dto
        return userMapper.toResponseDto(user);
    }

    @Transactional
    public UserResponseDto promoteUserToProfessional(Long id) {
        // find user
        User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("user not found"));

        // if user is already professional throw a exception
        if (user.getRoles().contains(UserRole.PROFESSIONAL)) {
            throw new RuntimeException("user is already a professional ");
        }

        // add role professional to the user
        user.getRoles().add(UserRole.PROFESSIONAL);

        // create a new professional
        Professional professional = new Professional();

        // set user to professional
        professional.setUser(user);

        // save professional in database 
        professionalRepository.save(professional);

        // return user response dto
        return userMapper.toResponseDto(user);
    }
}

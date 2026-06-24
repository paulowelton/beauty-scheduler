package com.paulo.beauty_scheduler.dto;

import lombok.Data;

@Data
public class UserResponseDto{
    Long id;
    String name;
    String cpf;
    String email;
    String phone;
    String role;
}
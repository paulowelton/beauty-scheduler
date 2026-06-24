package com.paulo.beauty_scheduler.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UpdateUserDto {
    
    private String name;

    @Pattern(regexp = "\\d{11}")
    private String cpf;
    
    @Email
    private String email;
    
    private String phone;
}

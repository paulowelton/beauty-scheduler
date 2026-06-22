package com.paulo.beauty_scheduler.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
public class CreateUserDto {
    
    @NotBlank
    private String name;

    @NotBlank
    @Pattern(regexp = "\\d{11}")
    private String cpf;
    
    @NotBlank
    @Email
    private String email;
    
    @NotBlank
    private String phone;

    @NotBlank
    @Size(min = 6)
    private String password;
}

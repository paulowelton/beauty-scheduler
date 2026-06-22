package com.paulo.beauty_scheduler.mapper;

import org.mapstruct.Mapper;

import com.paulo.beauty_scheduler.dto.CreateUserDto;
import com.paulo.beauty_scheduler.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(CreateUserDto dto);

}

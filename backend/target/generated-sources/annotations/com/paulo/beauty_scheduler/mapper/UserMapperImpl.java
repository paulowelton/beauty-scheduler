package com.paulo.beauty_scheduler.mapper;

import com.paulo.beauty_scheduler.dto.CreateUserDto;
import com.paulo.beauty_scheduler.dto.UpdateUserDto;
import com.paulo.beauty_scheduler.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-24T14:34:06-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(CreateUserDto dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setName( dto.getName() );
        user.setCpf( dto.getCpf() );
        user.setEmail( dto.getEmail() );
        user.setPhone( dto.getPhone() );
        user.setPassword( dto.getPassword() );

        return user;
    }

    @Override
    public User toEntity(UpdateUserDto dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setName( dto.getName() );
        user.setCpf( dto.getCpf() );
        user.setEmail( dto.getEmail() );
        user.setPhone( dto.getPhone() );

        return user;
    }

    @Override
    public void updateUserFromDto(UpdateUserDto dto, User user) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getName() != null ) {
            user.setName( dto.getName() );
        }
        if ( dto.getCpf() != null ) {
            user.setCpf( dto.getCpf() );
        }
        if ( dto.getEmail() != null ) {
            user.setEmail( dto.getEmail() );
        }
        if ( dto.getPhone() != null ) {
            user.setPhone( dto.getPhone() );
        }
    }
}

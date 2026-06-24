package com.paulo.beauty_scheduler.mapper;

import com.paulo.beauty_scheduler.dto.CreateUserDto;
import com.paulo.beauty_scheduler.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-24T11:20:58-0300",
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
}

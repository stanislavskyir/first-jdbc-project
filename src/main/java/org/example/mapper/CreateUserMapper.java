package org.example.mapper;

import org.example.dto.CreateUserDto;
import org.example.dto.UserDto;
import org.example.entity.Gender;
import org.example.entity.Role;
import org.example.entity.User;
import org.example.utils.LocalDateFormatter;

public class CreateUserMapper implements Mapper<User, CreateUserDto> {

    private static final CreateUserMapper INSTANCE = new CreateUserMapper();

    private CreateUserMapper() {}

    public static CreateUserMapper getInstance() {
        return INSTANCE;
    }

    @Override
    public User mapFrom(CreateUserDto object) {
        return User.builder()
                .name(object.getName())
                .birthday(LocalDateFormatter.format(object.getBirthday()))
                .email(object.getEmail())
                .password(object.getPassword())
                .gender(Gender.valueOf(object.getGender()))
                .role(Role.valueOf(object.getRole()))
                .build();
    }
}

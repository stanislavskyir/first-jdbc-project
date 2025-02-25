package org.example.dto;

import lombok.*;
import org.example.entity.Gender;
import org.example.entity.Role;

import java.time.LocalDate;

//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
//@NoArgsConstructor(access = AccessLevel.PRIVATE)
//@AllArgsConstructor
@Value
@Builder
public class UserDto {
    Integer id;
    String name;
    LocalDate birthday;
    String email;
    Role role;
    Gender gender;
}

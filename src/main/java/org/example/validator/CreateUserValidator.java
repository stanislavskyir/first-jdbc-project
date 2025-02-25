package org.example.validator;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.dto.CreateUserDto;
import org.example.entity.Gender;
import org.example.entity.Role;
import org.example.utils.LocalDateFormatter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateUserValidator implements Validator<CreateUserDto> {
    private final static CreateUserValidator INSTANCE = new CreateUserValidator();

    public ValidationResult isValid(CreateUserDto userDto){
        var validationResult = new ValidationResult();
        if(!LocalDateFormatter.isValid(userDto.getBirthday())){
            validationResult.add(Error.of("invalid.birthday", "Birthday is invalid"));
        }

        if(Gender.find(userDto.getGender()).isEmpty()){
            validationResult.add(Error.of("invalid.gender", "Gender is invalid"));
        }

        if (Role.find(userDto.getRole()).isEmpty()){
            validationResult.add(Error.of("invalid.role", "Role is invalid"));
        }
        //также добавить для остальных poley
        return validationResult;
    }

    public static CreateUserValidator getInstance() {
        return INSTANCE;
    }
}

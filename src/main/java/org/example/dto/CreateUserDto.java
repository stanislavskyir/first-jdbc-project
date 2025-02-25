package org.example.dto;

import lombok.Builder;
import lombok.Value;

@Value // value генерит только файнал класс, геттеры. менять через сеттеры мы не сможем
@Builder //Всегда актуален когда больше чем 5 полей+
public class CreateUserDto {
    String name;
    String birthday;
    String email;
    String password;
    String role;
    String gender;
}

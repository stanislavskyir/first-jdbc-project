package org.example.entity;

import java.util.Arrays;
import java.util.Optional;

public enum Role {
    ADMIN, USER;

    public static Optional<Role> find(String role){ //Чтобы вернулся опшинал налл
        return Arrays.stream(values())
                .filter(it -> it.name().equals(role))
                .findFirst();
    }
}

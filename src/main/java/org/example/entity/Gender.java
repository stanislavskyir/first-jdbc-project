package org.example.entity;

import java.util.Arrays;
import java.util.Optional;

public enum Gender {
    MALE, FEMALE;

    public static Optional<Gender> find(String gender){ //Чтобы вернулся опшинал налл
        return Arrays.stream(values())
                .filter(it -> it.name().equals(gender))
                .findFirst();
    }
}

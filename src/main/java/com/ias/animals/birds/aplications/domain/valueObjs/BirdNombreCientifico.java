package com.ias.animals.birds.aplications.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class BirdNombreCientifico {

    private final String value ;

    public BirdNombreCientifico(String value) {
        Validate.notNull(value,"NombreCientifico not null");
        if (value != null) {
            Validate.isTrue(value.length() <= 30, "Bird NombreCientifico not be longer than 30 characters");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}

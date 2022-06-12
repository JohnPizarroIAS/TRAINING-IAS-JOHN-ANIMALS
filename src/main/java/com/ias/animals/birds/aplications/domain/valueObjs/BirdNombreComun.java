package com.ias.animals.birds.aplications.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class BirdNombreComun {

    private final String value;

    public BirdNombreComun(String value) {
        Validate.notNull(value,"NombreComun not null");
        if (value != null) {
            Validate.isTrue(value.length() <= 30, "Bird NombreComun not be longer than 30 characters");
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

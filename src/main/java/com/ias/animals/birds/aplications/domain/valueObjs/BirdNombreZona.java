package com.ias.animals.birds.aplications.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class BirdNombreZona {

    public final String value;

    public BirdNombreZona(String value) {
        Validate.notNull(value,"NombreZona not null");
        if (value != null) {
            Validate.isTrue(value.length() <= 20, "Bird NombreZona can not be longer than 20 characters");
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

package com.ias.animals.birds.aplications.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class BirdCantidadConfirmada {

    private final Integer value;

    public BirdCantidadConfirmada(Integer value) {
        Validate.inclusiveBetween(1.0,100000,value);
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}

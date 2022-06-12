package com.ias.animals.birds.aplications.domain;

import com.ias.animals.birds.aplications.domain.valueObjs.*;

public class Bird {
    private final BirdId id;
    private final BirdNombreComun nombreComun;
    private final BirdNombreCientifico nombreCientifico;
    private final BirdNombreZona nombreZona;
    private final BirdCantidadConfirmada cantidadConfirmada;

    public Bird(BirdId id, BirdNombreComun nombreComun, BirdNombreCientifico nombreCientifico, BirdNombreZona nombreZona, BirdCantidadConfirmada cantidadConfirmada) {
        this.id = id;
        this.nombreComun = nombreComun;
        this.nombreCientifico = nombreCientifico;
        this.nombreZona = nombreZona;
        this.cantidadConfirmada = cantidadConfirmada;
    }


    public BirdId getId() {
        return id;
    }

    public BirdNombreComun getNombreComun() {
        return nombreComun;
    }

    public BirdNombreCientifico getNombreCientifico() {
        return nombreCientifico;
    }

    public BirdNombreZona getNombreZona() {
        return nombreZona;
    }

    public BirdCantidadConfirmada getCantidadConfirmada() {
        return cantidadConfirmada;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "id=" + id +
                ", nombreComun=" + nombreComun +
                ", nombreCientifico=" + nombreCientifico +
                ", nombreZona=" + nombreZona +
                ", cantidadConfirmada=" + cantidadConfirmada +
                '}';
    }
}

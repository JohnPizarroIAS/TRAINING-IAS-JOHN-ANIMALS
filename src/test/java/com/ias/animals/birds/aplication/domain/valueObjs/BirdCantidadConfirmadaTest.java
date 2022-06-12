package com.ias.animals.birds.aplication.domain.valueObjs;
import com.ias.animals.birds.aplications.domain.valueObjs.BirdCantidadConfirmada;
import com.ias.animals.birds.aplications.domain.valueObjs.BirdNombreCientifico;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class BirdCantidadConfirmadaTest {

    @Test
    @DisplayName("valid bird cantidadConfirmada should throw an error")
    void valid_cantidadConfirmada(){
        Integer valid_cantidadConfirmada=1;
        BirdCantidadConfirmada resultado = new BirdCantidadConfirmada(valid_cantidadConfirmada);
        assertTrue(valid_cantidadConfirmada >=1 && valid_cantidadConfirmada <=100000 );

    }
}

package com.ias.animals.birds.aplication.domain.valueObjs;
import com.ias.animals.birds.aplications.domain.valueObjs.BirdNombreComun;
import com.ias.animals.birds.aplications.domain.valueObjs.BirdNombreZona;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class BirdNombreZonaTest {
    @Test
    @DisplayName("Null bird NombreZona should throw an error")
    void null_bird_nombreZona(){
        String invalidNombreZona = null;

        assertThrows(NullPointerException.class, () -> {
            new BirdNombreZona(invalidNombreZona);
        });
    }

    @Test
    @DisplayName("Length NombreZona should throw an error")
    void length_invalid_nombreZona(){
        String responseMessage = "Bird NombreZona can not be longer than 20 characters";
        String invalidName = "este texto es mucho mayor del que se requiere para la zona";
        try{
            new BirdNombreZona(invalidName);

        }catch (Exception e){
            assertEquals(responseMessage, e.getMessage());
        }
    }

    @Test
    @DisplayName("valid Bird NombreZona,type,length ")
    void valid_bird_nombreZona(){
        String validNombreZona = "todosLados";

        BirdNombreZona resultado = new BirdNombreZona(validNombreZona);

        assertInstanceOf(BirdNombreZona.class,resultado);  //validar tipo
        assertEquals(validNombreZona,resultado.getValue());
        assertTrue(validNombreZona.length() <=20 );
    }
}

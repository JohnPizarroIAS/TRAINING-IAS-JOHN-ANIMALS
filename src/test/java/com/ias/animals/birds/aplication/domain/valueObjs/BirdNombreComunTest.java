package com.ias.animals.birds.aplication.domain.valueObjs;
import com.ias.animals.birds.aplications.domain.valueObjs.BirdId;
import com.ias.animals.birds.aplications.domain.valueObjs.BirdNombreComun;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BirdNombreComunTest {
    @Test
    @DisplayName("Null bird NombreComun should throw an error")
    void null_bird_NombreComun(){
        String invalidNombreComun = null;

        assertThrows(NullPointerException.class, () -> {
            new BirdNombreComun(invalidNombreComun);
        });
    }

    @Test
    @DisplayName("Length NombreComun should throw an error")
    void length_invalid_nombreComun(){
        String responseMessage = "Bird NombreComun not be longer than 30 characters";
        String invalidName = "este texto es mucho mas mayor del que se requiere para el nombreComun";
        try{
            new BirdNombreComun(invalidName);

        }catch (Exception e){
            assertEquals(responseMessage, e.getMessage());
        }
    }

    @Test
    @DisplayName("valid Bird NombreComun,type,length ")
    void valid_bird_nombreComun(){
        String validNombreComun = "Pajarito";

        BirdNombreComun resultado = new BirdNombreComun(validNombreComun);

        assertInstanceOf(BirdNombreComun.class,resultado);  //validar tipo
        assertEquals(validNombreComun,resultado.getValue());
        assertTrue(validNombreComun.length() <=30 );
    }


}

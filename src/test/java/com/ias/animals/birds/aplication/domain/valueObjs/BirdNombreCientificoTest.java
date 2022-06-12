package com.ias.animals.birds.aplication.domain.valueObjs;

import com.ias.animals.birds.aplications.domain.valueObjs.BirdNombreCientifico;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class BirdNombreCientificoTest {
    @Test
    @DisplayName("Bird NombreCientifico should throw error")
    void null_nombreCientifico() {
        String invalidNombreCientifico = null;

        assertThrows(NullPointerException.class, () -> {
            new BirdNombreCientifico(invalidNombreCientifico);
        });

    }

    @Test
    @DisplayName("Length NombreCientifico should throw an error")
    void length_invalid_nombreCientifico() {
        String responseMessage = "Bird NombreCientifico not be longer than 30 characters";
        String invalidName = "este texto es mucho mas largo del que se puede usar";
        try {
            new BirdNombreCientifico(invalidName);
        } catch (Exception e) {
            assertEquals(responseMessage, e.getMessage());
        }
    }

    @Test
    @DisplayName("Valid Bird NombreCientifico,type,length")
    void valid_bird_nombreCientifico() {
        String validNombreCientifico = "Bird";

        BirdNombreCientifico resultado =new BirdNombreCientifico(validNombreCientifico);

        assertInstanceOf(BirdNombreCientifico.class,resultado);
        assertTrue(validNombreCientifico.length() <=30);
        assertEquals(validNombreCientifico,resultado.getValue());

    }

}

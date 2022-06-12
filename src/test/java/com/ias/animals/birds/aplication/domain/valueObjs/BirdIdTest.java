package com.ias.animals.birds.aplication.domain.valueObjs;

import com.ias.animals.birds.aplications.domain.valueObjs.BirdId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BirdIdTest {
    @Test
    @DisplayName("Null bird id should throw an error")
    void null_bird_id() {
        Long invalidId = null;

        assertThrows(NullPointerException.class, () -> {
            new BirdId(invalidId);
        });

    }

    @Test
    @DisplayName("Valid bird id should not throw an error")
    void valid_bird_id(){
        Long validId = 1L;

        assertDoesNotThrow(()->{
            new BirdId(validId);
        });
    }

}

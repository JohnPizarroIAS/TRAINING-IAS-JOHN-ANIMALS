package com.ias.animals;

import com.ias.animals.birds.aplications.domain.Bird;
import com.ias.animals.birds.aplications.domain.valueObjs.*;
import com.ias.animals.infrastructure.models.BirdDTO;

public class test {

    public static void main(String[] args){
        try{
            Bird bird = new Bird(
                    new BirdId(1L),
                    new BirdNombreComun("pajarito"),
                    new BirdNombreCientifico("parrot"),
                    new BirdNombreZona("Todos lados"),
                    new BirdCantidadConfirmada(10)
            );

            System.out.println(bird);

        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


        BirdDTO birdDTO = new BirdDTO(1L, "pajarito", "parrot", "Todos lados",10);
        Bird bird = birdDTO.toDomain();
        System.out.println("dto example" + bird);

        BirdDTO birdDTO1 = BirdDTO.fromDomain(bird);
        System.out.println("from domain" + birdDTO1);

    }

}

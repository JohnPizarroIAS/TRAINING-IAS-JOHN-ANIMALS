package com.ias.animals.birds.aplications.services;

import com.ias.animals.birds.aplications.domain.Bird;
import com.ias.animals.birds.aplications.domain.valueObjs.*;
import com.ias.animals.birds.aplications.ports.input.CreateBirdUseCase;
import com.ias.animals.birds.aplications.ports.output.BirdRepository;
import com.ias.animals.infrastructure.models.BirdDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateBirdService implements CreateBirdUseCase {

    private final BirdRepository birdRepository;

    public CreateBirdService(BirdRepository birdRepository) {
        this.birdRepository = birdRepository;
    }

    @Override
    public BirdDTO execute(BirdDTO birdDTO) {
        // Auth -- login
        // validation of domain
        // bussines rules

        Bird bird = new Bird(null,
                new BirdNombreComun(birdDTO.getNombreComun()),
                new BirdNombreCientifico(birdDTO.getNombreCientifico()),
                new BirdNombreZona(birdDTO.getNombreZona()),
                new BirdCantidadConfirmada(birdDTO.getCantidadConfirmada())
        );


        ///logic store
        birdRepository.store(bird);

        birdDTO.setStatus("Created");
        return birdDTO;
    }


}

package com.ias.animals.birds.aplications.services;

import com.ias.animals.birds.aplications.domain.Bird;
import com.ias.animals.birds.aplications.ports.input.UpdateBirdUseCase;
import com.ias.animals.birds.aplications.ports.output.BirdRepository;
import com.ias.animals.infrastructure.models.BirdDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateBirdService implements UpdateBirdUseCase {
    private  final BirdRepository birdRepository;

    public UpdateBirdService(BirdRepository birdRepository) {
        this.birdRepository = birdRepository;
    }

    @Override
    public BirdDTO execute(BirdDTO birdDTO){

        Bird bird = birdDTO.toDomain();

        Optional<Bird> birdBD = birdRepository.get(bird.getId());

        if(birdBD.isPresent()){
            birdRepository.update(bird);
            birdDTO.setStatus("Updated");
        }
        else {
            birdDTO.setStatus("No Updated");
        }
        return birdDTO;
    }
}

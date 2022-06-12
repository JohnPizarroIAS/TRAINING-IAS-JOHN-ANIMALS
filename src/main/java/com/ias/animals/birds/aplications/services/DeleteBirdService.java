package com.ias.animals.birds.aplications.services;

import com.ias.animals.birds.aplications.domain.Bird;
import com.ias.animals.birds.aplications.domain.valueObjs.BirdId;
import com.ias.animals.birds.aplications.ports.input.DeleteBirdUseCase;
import com.ias.animals.birds.aplications.ports.output.BirdRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteBirdService implements DeleteBirdUseCase {

    private final BirdRepository birdRepository;

    public DeleteBirdService(BirdRepository birdRepository) {
        this.birdRepository = birdRepository;
    }

    @Override
    public Boolean execute(Long id){
        BirdId birdId = new BirdId(id);

        Optional<Bird> bird = birdRepository.get(birdId);

        if(bird.isPresent()){
            birdRepository.delete(birdId);
        }
        return bird.isPresent();

    }
}

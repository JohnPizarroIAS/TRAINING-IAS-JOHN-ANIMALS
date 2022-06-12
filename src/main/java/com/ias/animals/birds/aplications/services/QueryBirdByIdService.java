package com.ias.animals.birds.aplications.services;

import com.ias.animals.birds.aplications.domain.Bird;
import com.ias.animals.birds.aplications.domain.valueObjs.BirdId;
import com.ias.animals.birds.aplications.ports.input.QueryBirdByIdUseCase;
import com.ias.animals.birds.aplications.ports.output.BirdRepository;
import com.ias.animals.infrastructure.models.BirdDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QueryBirdByIdService implements QueryBirdByIdUseCase {
    private final BirdRepository birdRepository;

    public QueryBirdByIdService(BirdRepository birdRepository) {
        this.birdRepository = birdRepository;
    }

    @Override
    public Optional<BirdDTO> execute(Long id){
        BirdId birdId = new BirdId(id);

        Optional<Bird> birdOptionald = birdRepository.get(birdId);

        return birdOptionald.map(bird -> {
            BirdDTO birdDTO = BirdDTO.fromDomain(bird);
            return birdDTO;
        });
    }
}

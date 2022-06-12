package com.ias.animals.birds.aplications.ports.input;

import com.ias.animals.commons.UseCase;
import com.ias.animals.infrastructure.models.BirdDTO;

import java.util.Optional;

public interface QueryBirdByIdUseCase extends UseCase<Long, Optional<BirdDTO>> {
}

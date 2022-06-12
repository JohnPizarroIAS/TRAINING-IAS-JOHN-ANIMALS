package com.ias.animals.birds.aplications.ports.output;

import com.ias.animals.birds.aplications.domain.Bird;
import com.ias.animals.birds.aplications.domain.valueObjs.BirdId;

import java.util.Optional;

public interface BirdRepository {
    void store(Bird bird);

    Optional<Bird> get(BirdId birdId);

    void update(Bird bird);

    Boolean delete(BirdId birdId);


}

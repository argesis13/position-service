package com.orange.k8s.positionservice.repository;

import com.orange.k8s.positionservice.model.Position;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PositionRepository extends ReactiveMongoRepository<Position, String> {

    @Tailable
    Flux<Position> findWithTailableBy();
}

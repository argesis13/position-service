package com.orange.k8s.positionservice.service;

import com.orange.k8s.positionservice.model.Position;
import com.orange.k8s.positionservice.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PositionService {

    private PositionRepository positionRepository;

    @Autowired
    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public Mono<Position> addPosition(Position position) {
        return this.positionRepository.save(position);
    }

    public Flux<Position> getPositions() {
        return this.positionRepository.findWithTailableBy();
    }

    public Mono<Void> deleteAll() {
        return this.positionRepository.deleteAll();
    }

}

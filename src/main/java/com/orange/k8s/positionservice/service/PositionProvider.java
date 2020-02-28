package com.orange.k8s.positionservice.service;

import com.orange.k8s.positionservice.model.Position;
import com.orange.k8s.positionservice.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PositionProvider {

    private PositionRepository positionRepository;

    @Autowired
    public PositionProvider(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Scheduled(fixedRate = 5000)
    public void addAlarms() {
        Mono.just(Position.random())
                .flatMap(positionRepository::save)
                .subscribe(position -> System.out.println("saved " + position.toString()));
    }

}

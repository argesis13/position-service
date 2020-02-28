package com.orange.k8s.positionservice.controller;

import com.orange.k8s.positionservice.model.Position;
import com.orange.k8s.positionservice.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/positions")
public class PositionController {

    private PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @PostMapping()
    public Mono<Position> addPosition(@RequestBody Position position) {
        return positionService.addPosition(position);
    }

    @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Position> getPositions() {
        return positionService.getPositions();
    }
}

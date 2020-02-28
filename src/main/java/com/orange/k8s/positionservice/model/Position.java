package com.orange.k8s.positionservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Random;

@Document(collection = "positions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Position {

    private double longitude;
    private double latitude;

    public static Position random() {
        return new Position(51 + new Random().nextDouble() ,-2 + new Random().nextDouble());
    }


}

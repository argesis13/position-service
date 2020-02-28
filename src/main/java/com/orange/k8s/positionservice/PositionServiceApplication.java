package com.orange.k8s.positionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableReactiveMongoRepositories
public class PositionServiceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext application = SpringApplication.run(PositionServiceApplication.class, args);

        final MongoOperations mongoOperations = application.getBean(MongoOperations.class);

        // Capped collections need to be created manually
        if(mongoOperations.collectionExists("positions")) {
            mongoOperations.dropCollection("positions");
        }

        mongoOperations.createCollection("positions", CollectionOptions.empty().capped().size(9999999L).maxDocuments(100L));
    }

}

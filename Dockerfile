FROM openjdk:8-jdk-alpine

COPY target/*.jar /position-service.jar

ENTRYPOINT ["java", "-jar","/position-service.jar"]

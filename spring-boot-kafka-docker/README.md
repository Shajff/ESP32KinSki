# Spring Boot Kafka Docker

A demo application of tutorial: [Setup Kafka for development](https://dev.to/fabiothiroki/setup-kafka-for-development-44cd) using Spring Boot and Spring Kafka.

# Run
1. On Mac OS/Windows you may need to start a previously created `docker-machine`:
```
docker-machine start <machine-name>
eval $(docker-machine env)
```

2. Start kafka:
```
docker-compose up
```

3. Edit [docker-compose.yml](docker-compose.yml) file to set your Kafka IP exposed through Docker:
```
- ADV_HOST=192.168.99.100
```

4. Edit [application.properties](src/main/resources/application.properties) file to set your Kafka IP exposed through Docker:
```
spring.kafka.bootstrap-servers=192.168.99.100:9092
```


5. Start Spring Boot application:
```
./mvnw spring-boot:run
```

# Publish a message
To publish a message, access the endpoint `http://localhost:8080/publish` passing a `message` query parameter with your content. Example: `http://localhost:8080/publish?message=sample_message`
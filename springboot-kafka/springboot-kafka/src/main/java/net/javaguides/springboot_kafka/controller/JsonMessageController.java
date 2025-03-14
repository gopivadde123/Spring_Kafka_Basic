package net.javaguides.springboot_kafka.controller;

import net.javaguides.springboot_kafka.kafka.JsonKafkaProducer;
import net.javaguides.springboot_kafka.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {
    // Declaring the field private JsonKafkaProducer kafkaProducer; is a way for Spring to inject the
    // dependency into the class and make it available for the lifetime of the class.
    private JsonKafkaProducer kafkaProducer;
  // Since it has one parameter spring automatically injects the parameter
    public JsonMessageController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }
    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        kafkaProducer.sendMessage(user);
        return ResponseEntity.ok("JSON Message sent to kafka topic");
    }
}

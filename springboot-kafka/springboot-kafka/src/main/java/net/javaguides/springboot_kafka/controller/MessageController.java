package net.javaguides.springboot_kafka.controller;

import net.javaguides.springboot_kafka.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // This makes spring MVC Rest Controller
@RequestMapping("/api/v1/kafka")// Define the base URl
public class MessageController {
    // inject kafka producer
    private KafkaProducer kafkaProducer;
   // @Autowire only used if contain only parametirized constructor if not we use
    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }
    // http://localhost:8096/api/v1/kafka/publish?message=hello word
    @GetMapping("/publish")
   public ResponseEntity<String> publish(@RequestParam("message") String message){
        // kafka producer internally uses kafka template to send topic
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the topic");
   }

}

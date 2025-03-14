package net.javaguides.springboot_kafka.kafka;

import net.javaguides.springboot_kafka.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
// we have created kafka producer to produce the json message and send message to the kafka topic
public class JsonKafkaProducer {
    private static final Logger LOGGER= LoggerFactory.getLogger(JsonKafkaProducer.class);
    private KafkaTemplate<String, User> kafkaTemplate;
    @Value("${spring.kafka.topic-json.name}")
    private String topicJsonName;
    // here no need @Autowire because spring injects based on the below single parameterized
    //
    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(User data){
        LOGGER.info(String.format("Message sent -> %s",data.toString()));
        Message<User> message= MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC,topicJsonName) // javaguides_json in config class
                .build();
        kafkaTemplate.send(message);

    }
}

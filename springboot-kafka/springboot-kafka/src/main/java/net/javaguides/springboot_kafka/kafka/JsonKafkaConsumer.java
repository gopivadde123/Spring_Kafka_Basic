package net.javaguides.springboot_kafka.kafka;

import net.javaguides.springboot_kafka.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);
    @Value("${spring.kafka.topic-json.name}")
    private String topicJsonName;
    @KafkaListener(topics = "${spring.kafka.topic-json.name}",groupId = "${spring.kafka.consumer.group-id}")
    // springDeserializer provided by kafka convert User JSON Object to Java User Object
    public void consume(User user){
        LOGGER.info(String.format("Json message recieved -> %s", user.toString()));

    }
}

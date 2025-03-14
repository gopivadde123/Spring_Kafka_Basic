package net.javaguides.springboot_kafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class kafkaConsumer {
    @Value("${spring.kafka.topic.name}")
    private String topicName;
    private static final Logger LOGGER= LoggerFactory.getLogger(kafkaConsumer.class);
    // This annotation helps to subscribe the topic
    // "javaguides" passing this
    // we externalize the topic name
    // allow only constant no variable topics="${spring.kafka.topic.name}"
    @KafkaListener(topics="${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message){
        LOGGER.info(String.format("Message received -> %s",message));

    }
}

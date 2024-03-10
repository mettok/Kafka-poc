package no.zare.kmd.kafka;

import lombok.extern.slf4j.Slf4j;
import no.zare.kmd.domain.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@Configuration
@Slf4j
public class KafkaConfig {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;
    @KafkaListener(id = "fooGroup", topics = "topic1")
    public void listen(Greeting greeting) {
        log.info("Received: " + greeting.getContent());
        simpMessagingTemplate.convertAndSend("/topic/greetings",greeting.getContent());
    }
}

package no.zare.kmp;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.kafka.support.converter.RecordMessageConverter;

@SpringBootApplication
public class KafkaMessageProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaMessageProducerApplication.class, args);
    }

}

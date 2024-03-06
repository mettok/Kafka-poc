package no.zare.kmp.controller;

import no.zare.kmp.domain.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

        @Autowired
        private KafkaTemplate<Object, Object> template;
        @GetMapping(path = "/send/greeting/{who}")
        public void sendFoo(@PathVariable String who) {
            this.template.send("topic1", new Greeting(who));
        }

}

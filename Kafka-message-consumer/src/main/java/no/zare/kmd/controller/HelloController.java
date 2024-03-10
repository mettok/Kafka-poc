package no.zare.kmd.controller;


import no.zare.kmd.domain.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

@RestController
@RequestMapping("hello")
public class HelloController {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;
    @GetMapping("{name}")
    @SendTo("/topic/greetings")
    public Greeting sendHello(@PathVariable String name) throws InterruptedException {

        simpMessagingTemplate.convertAndSend("/topic/greetings", new Greeting("Hello, " + HtmlUtils.htmlEscape(name)));

        return new Greeting("Hello, " + HtmlUtils.htmlEscape(name) + "!");
    }
}

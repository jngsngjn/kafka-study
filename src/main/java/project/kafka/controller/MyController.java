package project.kafka.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.kafka.producer.MyProducer;

@RestController
@AllArgsConstructor
public class MyController {

    private final MyProducer myProducer;

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
        myProducer.sendMessage("my-topic", message);
        return "Message sent to Kafka: " + message;
    }
}
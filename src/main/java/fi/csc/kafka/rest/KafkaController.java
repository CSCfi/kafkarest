package fi.csc.kafka.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

private final Producer producer;

@Autowired
public KafkaController(Producer producer) {
this.producer = producer;
}

@PostMapping(value = "/publish/{topic}")
public void sendMessageToKafkaTopic(@PathVariable(name="topic") String topic, @RequestBody String message){
this.producer.sendMessage(topic, message);
}

}

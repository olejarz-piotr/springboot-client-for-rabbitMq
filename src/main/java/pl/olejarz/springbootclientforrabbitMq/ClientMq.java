package pl.olejarz.springbootclientforrabbitMq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientMq {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @GetMapping("/receive")
    public String get(){
        Object message = rabbitTemplate.receiveAndConvert("first");
        return message.toString();
    }
    @RabbitListener(queues = "first")
    public void rabbitListener(String s){
        System.out.println(s);
    }
}

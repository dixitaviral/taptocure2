package com.stackroute.emailservice.rabbitmq.consumer;


import com.stackroute.emailservice.rabbitmq.configuration.MessageConfiguration;
import com.stackroute.emailservice.rabbitmq.dto.Appointment;
import com.stackroute.emailservice.rabbitmq.dto.EmailDTO;
import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class Consumer {

    @RabbitListener(queues = MessageConfiguration.A_QUEUE)
    public void patientConsumer(Appointment appointment) {
        System.out.println("Consumed: Appointment "+appointment);
    }
    @RabbitListener(queues = MessageConfiguration.E_QUEUE)
    public void emailDTO (EmailDTO emailDTO) {
        System.out.println("Consumed: Email "+emailDTO);
    }

}
package com.example.notificationservice.listener;

import com.example.demo.models.Prescription;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PrescriptionListener {
    @Bean
    @RabbitListener(queues = "prescription.queue")
    public void listenPrescriptionQueue(Prescription prescription) {
            log.warn("Medicines are empty");
            log.warn("Prescription ID: {}", prescription.getId());
            log.warn("Prescription Date: {}", prescription.getIssuedDate());
    }
}


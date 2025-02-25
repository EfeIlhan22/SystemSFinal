package com.example.demo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue prescriptionQueue() {
        return new Queue("prescriptionQueue", true); // Kalıcı bir kuyruk oluştur
    }
}

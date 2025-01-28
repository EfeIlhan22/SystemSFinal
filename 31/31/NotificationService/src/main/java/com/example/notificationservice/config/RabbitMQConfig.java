package com.example.notificationservice.config;


import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String PRESCRIPTION_QUEUE = "prescriptionQueue";

    @Bean
    public Queue prescriptionQueue() {
        return new Queue(PRESCRIPTION_QUEUE, true); // Kalıcı kuyruk
    }
    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}


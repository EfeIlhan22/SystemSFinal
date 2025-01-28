package com.example.notificationservice.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DailyNotificationScheduler {

    @Scheduled(cron = "0 0 1 * * ?") // Her gün saat 1'de çalışır
    public void sendDailyNotifications() {
        System.out.println("Running daily notification check...");
        // Ek kontroller veya başka bir işlem eklenebilir
    }
}

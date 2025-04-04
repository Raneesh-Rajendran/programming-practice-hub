package main.java.low_code.notify_service;

public class SmsSender implements NotificationSender {
    @Override
    public void send(User user, String message) {
        System.out.println(message);
    }
}

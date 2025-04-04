package main.java.low_code.notify_service;

public interface NotificationSender {
  void send(User user, String message);
}

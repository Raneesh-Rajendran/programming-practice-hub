package main.java.low_code.notify_service;

public class NotificationService {
  public void sendNotification(User user, String message) {
    NotificationSender sender =
        switch (user.getNotificationType()) {
          case EMAIL -> new EmailSender();
          case SMS -> new SmsSender();
        };

    sender.send(user, message);
  }
}

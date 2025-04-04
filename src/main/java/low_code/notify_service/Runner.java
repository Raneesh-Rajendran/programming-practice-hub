package main.java.low_code.notify_service;

public class Runner {
  public static void main(String[] args) {
    User user1 =
        new User("Raneesh", "raneesh@example.com", "+441234567890", NotificationType.EMAIL);
    User user2 = new User("Raj", "raj@example.com", "+449876543210", NotificationType.SMS);

    NotificationService notificationService = new NotificationService();

    notificationService.sendNotification(user1, "Hello Raneesh via Email!");
    notificationService.sendNotification(user2, "Hello Raj via SMS!");
  }
}

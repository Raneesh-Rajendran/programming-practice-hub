package main.java.low_code.notify_service;

public class User {
  String name;
  String email;
  String phoneNumber;
  NotificationType notificationType;

  public User(String name, String email, String phoneNumber, NotificationType notificationType) {
    this.name = name;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.notificationType = notificationType;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public NotificationType getNotificationType() {
    return notificationType;
  }

  public void setNotificationType(NotificationType notificationType) {
    this.notificationType = notificationType;
  }
}

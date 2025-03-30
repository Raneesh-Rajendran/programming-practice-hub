package main.java.multithreading;

public class Customer {
  int amount = 10000;

  synchronized void withdraw() {
    System.out.println("going to withdraw...");

    if (this.amount < 5000) {
      System.out.println("Less balance; waiting for deposit...");
      try {
        wait();
      } catch (Exception e) {
      }
    }
    this.amount -= 5000;
    System.out.println("withdraw completed...");
  }

  synchronized void deposit(int amount) {
    System.out.println("going to deposit...");
    this.amount += amount;
    System.out.println("deposit completed... ");
    notify();
  }
}

class Test {
  public static void main(String[] args) {
    final Customer c = new Customer();
    new Thread(c::withdraw).start();
    new Thread(() -> c.deposit(10000)).start();
  }
}

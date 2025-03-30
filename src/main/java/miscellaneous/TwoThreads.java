package main.java.miscellaneous;

public class TwoThreads {

  public static void main(String[] args) throws InterruptedException {
    Thread t1 =
        new Thread(
            () -> {
              System.out.println("Google");
            });

    Thread t2 =
        new Thread(
            () -> {
              System.out.println("Amazon");
            });

    t1.start();
    t2.start();

    t1.join();
    t2.join();
  }
}

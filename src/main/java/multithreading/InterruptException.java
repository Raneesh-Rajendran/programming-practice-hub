package main.java.multithreading;

public class InterruptException {
  public static void main(String[] args) {

    yes y = new yes();
    y.start();
  }
}

class Ie extends Thread {

  public Ie() {
    super("Ie");
  }

  public void run() {
    for (int i = 0; i < 2; i++) {
      System.out.print(Thread.currentThread().getName());
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        System.out.println("Interrupted Exception");
      }
    }
  }
}

class yes extends Thread {

  public yes() {
    super("yes");
  }

  public void run() {
    for (int i = 0; i < 5; i++) {

      System.out.print(Thread.currentThread().getName());
      Ie t1 = new Ie();

      t1.start();
      t1.interrupt();
    }
  }
}

package main.java.multithreading.synchronization;

public class Dependent implements Runnable {

  Boolean flag;

  public Dependent(Boolean flag) {
    this.flag = flag;
  }

  public void run() {

    synchronized (flag) {
      if (!flag) {
        try {
          System.out.println("Dependent wait..");
          flag.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      System.out.println("Dependent code..");
      flag.notifyAll();
    }
  }
}

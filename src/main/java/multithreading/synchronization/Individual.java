package main.java.multithreading.synchronization;

public class Individual implements Runnable {

  Boolean flag;

  public Individual(Boolean flag) {
    this.flag = flag;
  }

  public void run() {

    synchronized (flag) {
      if (flag) {
        try {
          System.out.println("Individual wait..");
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

      System.out.println("Individual code..");
      flag.notifyAll();
    }
  }
}

package main.java.miscellaneous;

import java.util.concurrent.Semaphore;

public class OddEvenIncrement {

  public static void main(String[] args) throws InterruptedException {

    Integer counter = 1;
    Semaphore odd = new Semaphore(1);
    Semaphore even = new Semaphore(0);

    Thread t1 = new Thread(new OddIncrement(counter, odd, even));
    Thread t2 = new Thread(new EvenIncrement(counter, odd, even));

    t1.start();
    t2.start();
  }
}

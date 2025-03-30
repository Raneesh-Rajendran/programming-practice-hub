package main.java.miscellaneous;

import java.util.concurrent.Semaphore;

public class EvenIncrement implements Runnable {

  Semaphore odd;
  Semaphore even;
  private Integer counter;

  public EvenIncrement(Integer counter, Semaphore odd, Semaphore even) {
    this.counter = counter;
    this.odd = odd;
    this.even = even;
  }

  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      try {
        even.acquire();
        if (counter % 2 == 0) {
          System.out.println(counter);
        }
        counter++;
        odd.release();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}

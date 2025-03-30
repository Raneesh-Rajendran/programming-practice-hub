package main.java.miscellaneous;

import java.util.concurrent.Semaphore;

public class OddIncrement implements Runnable {

  Semaphore odd;
  Semaphore even;
  private Integer counter;

  public OddIncrement(Integer counter, Semaphore odd, Semaphore even) {
    this.counter = counter;
    this.odd = odd;
    this.even = even;
  }

  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      try {
        odd.acquire();
        if (counter % 2 == 1) {
          System.out.println(counter);
        }
        counter++;
        even.release();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}

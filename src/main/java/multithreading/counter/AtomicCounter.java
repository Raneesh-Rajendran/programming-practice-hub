package main.java.multithreading.counter;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter implements Runnable {
  private static final int limit = 100;
  private final AtomicInteger integer = new AtomicInteger(0);

  @Override
  public void run() {
    while (integer.get() < limit) {
      increaseCounter();
    }
  }

  private void increaseCounter() {
    System.out.println(Thread.currentThread().getName() + " : " + integer.getAndIncrement());
  }
}

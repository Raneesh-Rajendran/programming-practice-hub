package main.java.multithreading.counter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCounter implements Runnable {

  private static final int limit = 100;
  private final Lock lock = new ReentrantLock();
  private int integer = 0;

  @Override
  public void run() {
    while (integer < limit) {
      lock.lock();
      increaseCounter();
    }
  }

  private void increaseCounter() {
    try {
      System.out.println(Thread.currentThread().getName() + " : " + integer++);
    } finally {
      lock.unlock();
    }
  }
}

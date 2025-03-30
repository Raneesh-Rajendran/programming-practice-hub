package main.java.multithreading.counter;

public class SynchronizedCounter implements Runnable {

  private static final int limit = 100;
  private final Object lock = new Object();
  private int integer = 0;

  @Override
  public void run() {
    while (integer < limit) {
      synchronized (lock) {
        increaseCounter();
      }
    }
  }

  private void increaseCounter() {
    synchronized (lock) {
      System.out.println(Thread.currentThread().getName() + " : " + integer++);
    }
  }
}

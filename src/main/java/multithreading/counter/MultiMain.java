package main.java.multithreading.counter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiMain {
  private static final int threadPoolSize = 5;

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);
    for (int i = 0; i < threadPoolSize; i++) {
      // executorService.submit(new AtomicCounter());
      // executorService.submit(new SynchronizedCounter());
      executorService.submit(new LockCounter());
    }
    executorService.shutdown();
  }
}

package main.java.multithreading.producer_consumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockBasedRunner {

  private final Queue<String> queue = new LinkedList<>();

  private final Lock lock = new ReentrantLock();
  private final Condition notFull = lock.newCondition(); // Condition to wait when queue is full
  private final Condition notEmpty = lock.newCondition(); // Condition to wait when queue is empty

  public static void main(String[] args) {
    LockBasedRunner runner = new LockBasedRunner();

    Runnable producerTask =
        () -> {
          for (int i = 1; i <= 20; i++) {
            try {
              runner.publish("Msg-" + i);
              Thread.sleep(100); // simulate processing
            } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
            }
          }
        };

    Runnable consumerTask =
        () -> {
          for (int i = 1; i <= 20; i++) {
            try {
              runner.consume();
              Thread.sleep(150); // simulate processing
            } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
            }
          }
        };

    Thread t1 = new Thread(producerTask, "Producer-1");
    Thread t2 = new Thread(producerTask, "Producer-2");
    Thread t3 = new Thread(consumerTask, "Consumer-1");
    Thread t4 = new Thread(consumerTask, "Consumer-2");

    t1.start();
    t2.start();
    t3.start();
    t4.start();
  }

  public void publish(String message) throws InterruptedException {
    lock.lock();
    try {
      int MAX_CAPACITY = 5;
      while (queue.size() == MAX_CAPACITY) {
        System.out.println(
            Thread.currentThread().getName() + " waiting to publish. Buffer is full.");
        notFull.await(); // wait until not full
      }

      queue.add(message);
      System.out.println(Thread.currentThread().getName() + " Published: " + message);
      notEmpty.signalAll(); // notify consumers
    } finally {
      lock.unlock();
    }
  }

  public void consume() throws InterruptedException {
    lock.lock();
    try {
      while (queue.isEmpty()) {
        System.out.println(
            Thread.currentThread().getName() + " waiting to consume. Buffer is empty.");
        notEmpty.await(); // wait until not empty
      }

      String message = queue.poll();
      System.out.println(Thread.currentThread().getName() + " Consumed: " + message);
      notFull.signalAll(); // notify producers
    } finally {
      lock.unlock();
    }
  }
}

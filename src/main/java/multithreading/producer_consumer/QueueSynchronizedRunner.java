package main.java.multithreading.producer_consumer;

import java.util.LinkedList;
import java.util.Queue;

public class QueueSynchronizedRunner {

  private final Queue<String> queue = new LinkedList<>();

  public static void main(String[] args) {
    QueueSynchronizedRunner runner = new QueueSynchronizedRunner();

    Runnable producerTask =
        () -> {
          for (int i = 1; i <= 20; i++) {
            try {
              runner.publish("Msg-" + i);
              Thread.sleep(100);
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
              Thread.sleep(150);
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

  private void publish(String message) throws InterruptedException {
    synchronized (queue) {
      int MAX_CAPACITY = 5;
      while (queue.size() == MAX_CAPACITY) {
        System.out.println(
            Thread.currentThread().getName() + " waiting to publish. Buffer is full.");
        queue.wait();
      }
      queue.add(message);
      System.out.println(Thread.currentThread().getName() + " Published: " + message);
      queue.notifyAll();
    }
  }

  private void consume() throws InterruptedException {
    synchronized (queue) {
      while (queue.isEmpty()) {
        System.out.println(
            Thread.currentThread().getName() + " waiting to consume. Buffer is empty.");
        queue.wait();
      }
      String message = queue.poll();
      System.out.println(Thread.currentThread().getName() + " Consumed: " + message);
      queue.notifyAll();
    }
  }
}

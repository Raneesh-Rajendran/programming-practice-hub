package main.java.multithreading.producer_consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueRunner {

  private final BlockingQueue<String> queue = new ArrayBlockingQueue<>(5); // bounded buffer

  public static void main(String[] args) {
    BlockingQueueRunner runner = new BlockingQueueRunner();

    Runnable producerTask =
        () -> {
          for (int i = 1; i <= 20; i++) {
            try {
              runner.publish("Msg-" + i);
              Thread.sleep(100); // simulate delay
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
              Thread.sleep(150); // simulate delay
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
    queue.put(message); // blocks if queue is full
    System.out.println(Thread.currentThread().getName() + " Published: " + message);
  }

  public void consume() throws InterruptedException {
    String message = queue.take(); // blocks if queue is empty
    System.out.println(Thread.currentThread().getName() + " Consumed: " + message);
  }
}

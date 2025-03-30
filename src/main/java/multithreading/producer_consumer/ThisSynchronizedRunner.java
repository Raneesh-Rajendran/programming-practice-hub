package main.java.multithreading.producer_consumer;

import java.util.LinkedList;
import java.util.Queue;

public class ThisSynchronizedRunner {

  private final Queue<String> queue = new LinkedList<>();

  public static void main(String[] args) {
    ThisSynchronizedRunner runner = new ThisSynchronizedRunner();

    Runnable producerTask =
        () -> {
          for (int i = 1; i <= 20; i++) {
            try {
              runner.publish("Msg-" + i);
              Thread.sleep(100); // simulate processing time
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
              Thread.sleep(150); // simulate processing time
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

  // synchronized on 'this', so wait/notify must be on 'this'
  private synchronized void publish(String message) throws InterruptedException {
    int MAX_CAPACITY = 5;
    while (queue.size() == MAX_CAPACITY) {
      System.out.println(Thread.currentThread().getName() + " waiting to publish. Buffer is full.");
      wait(); // waiting on 'this'
    }

    queue.add(message);
    System.out.println(Thread.currentThread().getName() + " Published: " + message);
    notifyAll(); // notifying threads waiting on 'this'
  }

  private synchronized void consume() throws InterruptedException {
    while (queue.isEmpty()) {
      System.out.println(
          Thread.currentThread().getName() + " waiting to consume. Buffer is empty.");
      wait(); // waiting on 'this'
    }

    String message = queue.poll();
    System.out.println(Thread.currentThread().getName() + " Consumed: " + message);
    notifyAll(); // notifying threads waiting on 'this'
  }
}

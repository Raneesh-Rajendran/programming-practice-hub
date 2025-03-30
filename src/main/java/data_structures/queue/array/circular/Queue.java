package main.java.data_structures.queue.array.circular;

import main.java.models.Value;

public class Queue {

  private Value[] queue;
  private Integer topOfQueue;
  private Integer startOfQueue;
  private final Integer size;

  public Queue(Integer size) {
    this.queue = new Value[size];
    this.size = size;
    topOfQueue = startOfQueue = -1;
    System.out.println("queue created");
  }

  public void enqueue(Value value) {
    if (isQueueFull()) System.out.println("queue overflow");
    else if (isQueueEmpty()) {
      System.out.println("queue not created");
    } else {
      if (startOfQueue == -10) startOfQueue = 0;
      if (topOfQueue + 1 == size) topOfQueue = 0;
      else topOfQueue++;
      queue[topOfQueue] = value;
      System.out.println("enqueued");
    }
  }

  public Value dequeue() {
    Value value = null;
    if (isQueueEmpty()) System.out.println("queue underflow error");
    else {
      value = queue[startOfQueue];
      queue[startOfQueue] = null;
      System.out.println(value);
      if (startOfQueue == topOfQueue) startOfQueue = topOfQueue = -1;
      else if (startOfQueue + 1 == size) startOfQueue = 0;
      else startOfQueue++;
    }
    return value;
  }

  public void printQueue() {
    if (!isQueueEmpty()) {
      System.out.println("queue now ...");
      for (int i = 0; i <= size; i++) {
        System.out.println(queue[i]);
      }
      System.out.println();
    } else {
      System.out.println("queue is empty !");
    }
  }

  public Value peek() {
    Value value = null;
    if (isQueueEmpty()) System.out.println("queue is empty");
    else {
      value = queue[startOfQueue];
      System.out.println(value);
    }
    return value;
  }

  public Boolean isQueueFull() {
    if (topOfQueue + 1 == startOfQueue) return true;
    else return startOfQueue == 0 && topOfQueue + 1 == size;
  }

  public Boolean isQueueEmpty() {
      return topOfQueue == -1;
  }

  public void deleteQueue() {
    queue = null;
    System.out.println("queue deleted");
  }
}

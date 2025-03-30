package main.java.data_structures.queue.array.linear;

import main.java.models.Value;

public class Queue {

  private Value[] queue;
  private Integer topOfQueue;
  private Integer beginningOfQueue;

  public Queue(Integer size) {
    this.queue = new Value[size];
    topOfQueue = beginningOfQueue = -1;
    System.out.println("queue created");
  }

  public void enqueue(Value value) {
    if (isQueueFull()) System.out.println("queue overflow");
    else {
      if (isQueueEmpty()) beginningOfQueue = 0;
      queue[topOfQueue + 1] = value;
      topOfQueue++;
    }
  }

  public Value dequeue() {
    Value value = null;
    if (isQueueEmpty()) System.out.println("queue is empty");
    else {
      value = queue[beginningOfQueue + 1];
      beginningOfQueue++;
      System.out.println(value);
      if (beginningOfQueue > topOfQueue) beginningOfQueue = topOfQueue = -1;
    }
    return value;
  }

  public void printQueue() {
    if (!isQueueEmpty()) {
      System.out.println("Queue now ...");
      for (int i = beginningOfQueue; i <= topOfQueue; i++) {
        System.out.println(queue[i]);
      }
      System.out.println();
    } else {
      System.out.println("Queue is empty !");
    }
  }

  public Value peek() {
    Value value = null;
    if (isQueueEmpty()) System.out.println("queue is empty");
    else {
      value = queue[beginningOfQueue + 1];
      System.out.println(value);
    }
    return value;
  }

  public Boolean isQueueFull() {
      return topOfQueue == queue.length - 1;
  }

  public Boolean isQueueEmpty() {
      return beginningOfQueue == -1 || (beginningOfQueue == queue.length);
  }

  public void deleteQueue() {
    queue = null;
    System.out.println("queue deleted");
  }
}

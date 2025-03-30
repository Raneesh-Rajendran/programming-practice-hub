package main.java.data_structures.queue.linkedlist;

import main.java.data_structures.linkedlist.linear.one.SingleLinkedList;
import main.java.models.Value;

public class Queue {

  private final SingleLinkedList linkedList;

  public Queue() {
    linkedList = new SingleLinkedList();
  }

  public void enqueue(Value value) {
    if (linkedList.getHead() == null) linkedList.createLinkedList(value);
    else linkedList.insertNode(value, 0);
  }

  public Value dequeue() {
    Value value = null;
    if (isQueueEmpty()) System.out.println("stack is empty");
    else {
      value = linkedList.getTail().getValue();
      linkedList.deleteNode(value);
      System.out.println(value);
    }
    return value;
  }

  public Value peek() {
    Value value = null;
    if (isQueueEmpty()) System.out.println("queue is empty");
    else {
      value = linkedList.getTail().getValue();
      System.out.println(value);
    }
    return value;
  }

  public Boolean isQueueEmpty() {
      return linkedList.getHead() == null;
  }

  public void deleteQueue() {
    linkedList.setHead(null);
  }
}

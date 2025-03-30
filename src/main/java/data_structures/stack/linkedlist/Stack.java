package main.java.data_structures.stack.linkedlist;

import main.java.data_structures.linkedlist.linear.one.SingleLinkedList;
import main.java.models.Value;

public class Stack {
  private final SingleLinkedList linkedList;

  public Stack() {
    linkedList = new SingleLinkedList();
  }

  public void push(Value value) {
    if (linkedList.getHead() == null) linkedList.createLinkedList(value);
    else linkedList.insertNode(value, 0);
  }

  public Value pop() {
    Value value = null;
    if (isStackEmpty()) System.out.println("stack is empty");
    else {
      value = linkedList.getHead().getValue();
      linkedList.deleteNode(value);
      System.out.println(value);
    }
    return value;
  }

  public Value peek() {
    Value value = null;
    if (isStackEmpty()) System.out.println("stack is empty");
    else {
      value = linkedList.getHead().getValue();
      System.out.println(value);
    }
    return value;
  }

  public Boolean isStackEmpty() {
      return linkedList.getHead() == null;
  }

  public void deleteStack() {
    linkedList.setHead(null);
  }
}

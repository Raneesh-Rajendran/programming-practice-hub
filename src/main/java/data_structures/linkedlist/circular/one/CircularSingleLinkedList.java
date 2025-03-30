package main.java.data_structures.linkedlist.circular.one;

import main.java.models.SingleNode;
import main.java.models.Value;

public class CircularSingleLinkedList {

  private SingleNode head;
  private SingleNode tail;
  private Integer size;

  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public SingleNode getHead() {
    return head;
  }

  public void setHead(SingleNode head) {
    this.head = head;
  }

  public SingleNode getTail() {
    return tail;
  }

  public void setTail(SingleNode tail) {
    this.tail = tail;
  }

  public SingleNode createLinkedList(Value nodeValue) {
    SingleNode node = new SingleNode(nodeValue, null);
    head = tail = node;
    size = 1;
    System.out.println("Created");
    return head;
  }

  public void insertNode(Value nodeValue, Integer location) {
    SingleNode node = new SingleNode(nodeValue, null);
    if (!isListExists()) System.out.println("List not exists");
    else if (location == 0) {
      node.setNext(head);
      head = node;
      tail.setNext(head);
    } else if (location >= size) {
      tail.setNext(node);
      tail = node;
      tail.setNext(head);
    } else {
      SingleNode tempNode = head;
      int idx = 0;
      while (idx < location - 1) {
        tempNode = tempNode.getNext();
        idx++;
      }
      SingleNode nextNode = tempNode.getNext();
      tempNode.setNext(node);
      node.setNext(nextNode);
    }
    size++;
    System.out.println("Inserted");
  }

  public void deleteNode(Value nodeValue) {
    if (!isListExists()) System.out.println("List not exist");
    else {
      SingleNode tempNode = head;
      Integer location = null;
      for (int idx = 0; idx < size; idx++) {
        if (nodeValue.getInteger() != null
            && tempNode.getValue().getInteger() != null
            && nodeValue.getInteger().equals(tempNode.getValue().getInteger())) {
          location = idx;
          break;
        }
        if (nodeValue.getString() != null
            && tempNode.getValue().getString() != null
            && nodeValue.getString().equalsIgnoreCase(tempNode.getValue().getString())) {
          location = idx;
          break;
        }
        tempNode = tempNode.getNext();
      }
      if (location == 0) {
        head = head.getNext();
        tail.setNext(head);
        size--;
        if (size == 0) tail = null;
        System.out.println("Deleted");
      } else if (location >= size - 1) {
        tempNode = head;
        for (int idx = 0; idx < getSize() - 1; idx++) {
          tempNode = tempNode.getNext();
        }
        tempNode.setNext(null);
        tail = tempNode;
        size--;
      } else if (location < size - 1) {
        tempNode = head;
        for (int idx = 0; idx < location - 1; idx++) {
          tempNode = tempNode.getNext();
        }
        tempNode.setNext(tempNode.getNext().getNext());
        size--;
        System.out.println("Deleted");
      } else {
        System.out.println("Value not exist");
      }
    }
  }

  public boolean searchList(Value nodeValue) {
    if (isListExists()) {
      SingleNode tempNode = head;
      for (int idx = 0; idx < size; idx++) {
        if (nodeValue.getInteger() != null
            && tempNode.getValue().getInteger() != null
            && nodeValue.getInteger().equals(tempNode.getValue().getInteger())) {
          System.out.println("Location : " + idx + 1);
          return true;
        }
        if (nodeValue.getString() != null
            && tempNode.getValue().getString() != null
            && nodeValue.getString().equalsIgnoreCase(tempNode.getValue().getString())) {
          System.out.println("Location : " + idx + 1);
          return true;
        }
        tempNode = tempNode.getNext();
      }
    }
    System.out.println("Value not exist");
    return false;
  }

  public void traverseList() {
    if (isListExists()) {
      SingleNode tempNode = head;
      for (int idx = 0; idx < getSize(); idx++) {
        System.out.println((idx + 1) + ") " + tempNode.getValue().toString());
        tempNode = tempNode.getNext();
      }
    } else System.out.println("List not exist");
  }

  public void deleteList() {
    tail.setNext(null);
    head = tail = null;
    System.out.println("List deleted");
  }

  public Boolean isListExists() {
    return head != null;
  }
}

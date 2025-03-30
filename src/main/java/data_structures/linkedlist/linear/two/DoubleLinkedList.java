package main.java.data_structures.linkedlist.linear.two;

import main.java.models.DoubleNode;
import main.java.models.Value;

public class DoubleLinkedList {

  private DoubleNode head;
  private DoubleNode tail;
  private Integer size;

  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public DoubleNode getHead() {
    return head;
  }

  public void setHead(DoubleNode head) {
    this.head = head;
  }

  public DoubleNode getTail() {
    return tail;
  }

  public void setTail(DoubleNode tail) {
    this.tail = tail;
  }

  public DoubleNode createLinkedList(Value nodeValue) {
    DoubleNode node = new DoubleNode(nodeValue);
    node.setPrev(node);
    node.setNext(node);
    head = tail = node;
    size = 1;
    System.out.println("Created");
    return head;
  }

  public void insertNode(Value nodeValue, Integer location) {
    DoubleNode node = new DoubleNode(nodeValue);
    if (!isListExists()) System.out.println("List not exists");
    else if (location == 0) {
      node.setNext(head);
      head.setPrev(node);
      head = node;
    } else if (location >= size) {
      tail.setNext(node);
      node.setPrev(tail);
      tail = node;
    } else {
      DoubleNode tempNode = head;
      int idx = 0;
      while (idx < location - 1) {
        tempNode = tempNode.getNext();
        idx++;
      }
      DoubleNode nextNode = tempNode.getNext();
      node.setNext(nextNode);
      node.setPrev(tempNode);
      tempNode.setNext(node);
      nextNode.setPrev(node);
    }
    size++;
    System.out.println("Inserted");
  }

  public void deleteNode(Value nodeValue) {
    if (!isListExists()) System.out.println("List not exist");
    else {
      DoubleNode tempNode = head;
      Integer location = null;
      for (int idx = 0; idx < getSize(); idx++) {
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
      if (location == 0 && getSize() == 1) {
        head.setPrev(null);
        tail = head = null;
        System.out.println("List Deleted");
      } else if (location == 0) {
        head = head.getNext();
        head.setPrev(null);
        setSize(getSize() - 1);
        System.out.println("Deleted");
      } else if (location >= size - 1) {
        tempNode = tail.getPrev();
        tail.setNext(null);
        tail = tempNode;
        setSize(getSize() - 1);
        System.out.println("Deleted");
      } else if (location < size - 1) {
        tempNode = head;
        for (int idx = 0; idx < location - 1; idx++) {
          tempNode = tempNode.getNext();
        }
        tempNode.setNext(tempNode.getNext().getNext());
        tempNode.getNext().setPrev(tempNode);
        setSize(getSize() - 1);
        System.out.println("Deleted");
      } else {
        System.out.println("Value not exist");
      }
    }
  }

  public boolean searchList(Value nodeValue) {
    if (isListExists()) {
      DoubleNode tempNode = head;
      for (int idx = 0; idx < getSize(); idx++) {
        if (nodeValue.getInteger() != null
            && tempNode.getValue().getInteger() != null
            && nodeValue.getInteger().equals(tempNode.getValue().getInteger())) {
          System.out.println("Location : " + idx);
          return true;
        }
        if (nodeValue.getString() != null
            && tempNode.getValue().getString() != null
            && nodeValue.getString().equalsIgnoreCase(tempNode.getValue().getString())) {
          System.out.println("Location : " + idx);
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
      DoubleNode tempNode = head;
      for (int idx = 0; idx < getSize(); idx++) {
        System.out.println((idx + 1) + ") " + tempNode.getValue().toString());
        tempNode = tempNode.getNext();
      }
    } else {
      System.out.println("List not exist");
    }
  }

  public void reverseTraverseList() {
    if (isListExists()) {
      DoubleNode tempNode = tail;
      for (int idx = 0; idx < getSize(); idx++) {
        System.out.println((idx + 1) + ") " + tempNode.getValue().toString());
        tempNode = tempNode.getPrev();
      }
    } else {
      System.out.println("List not exist");
    }
  }

  public void deleteList() {
    DoubleNode tempNode = head;
    for (int idx = 0; idx < getSize(); idx++) {
      tempNode.setPrev(null);
      tempNode = tempNode.getNext();
    }
    head = tail = null;
    System.out.println("List deleted");
  }

  public Boolean isListExists() {
    return head != null;
  }
}

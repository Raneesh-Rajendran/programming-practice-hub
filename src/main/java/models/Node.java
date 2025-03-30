package main.java.models;

public class Node {

  public Integer data;
  public Node next;

  public Node(Integer data) {
    this.data = data;
    this.next = null;
  }

  public Node(Integer data, Node next) {
    this.data = data;
    this.next = next;
  }

  public Node() {}

  public Integer getData() {
    return data;
  }

  public void setData(Integer data) {
    this.data = data;
  }

  public Node getNext() {
    return next;
  }

  public void setNext(Node next) {
    this.next = next;
  }
}

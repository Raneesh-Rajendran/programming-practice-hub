package main.java.models;

public class DoubleNode {
  private Value value;
  private DoubleNode prev;
  private DoubleNode next;

  public DoubleNode(Value value) {
    this.value = value;
    this.prev = null;
    this.next = null;
  }

  public DoubleNode getPrev() {
    return prev;
  }

  public void setPrev(DoubleNode prev) {
    this.prev = prev;
  }

  public DoubleNode getNext() {
    return next;
  }

  public void setNext(DoubleNode next) {
    this.next = next;
  }

  public Value getValue() {
    return value;
  }

  public void setValue(Value value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "DoubleNode{" + "value=" + value + ", prev=" + prev + ", next=" + next + '}';
  }
}

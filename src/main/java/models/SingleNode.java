package main.java.models;

public class SingleNode {

  private Value value;
  private SingleNode next;

  public SingleNode(Value value, SingleNode link) {
    this.value = value;
    this.next = link;
  }

  public SingleNode() {}

  public Value getValue() {
    return value;
  }

  public void setValue(Value value) {
    this.value = value;
  }

  public SingleNode getNext() {
    return next;
  }

  public void setNext(SingleNode next) {
    this.next = next;
  }

  @Override
  public String toString() {
    return "SingleNode{" + "value='" + value + '\'' + ", next=" + next + '}';
  }
}

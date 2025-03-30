package main.java.models;

public class BinaryNode {
  private BinaryNode left;
  private BinaryNode right;
  private Value value;
  private Integer value1;
  private Integer height;

  public BinaryNode(BinaryNode left, BinaryNode right, Value value, Integer height) {
    this.left = left;
    this.right = right;
    this.value = value;
    this.height = height;
  }

  public BinaryNode(BinaryNode left, BinaryNode right, Integer value, Integer height) {
    this.left = left;
    this.right = right;
    this.value1 = value;
    this.height = height;
  }

  public BinaryNode() {}

  public BinaryNode getLeft() {
    return left;
  }

  public void setLeft(BinaryNode left) {
    this.left = left;
  }

  public BinaryNode getRight() {
    return right;
  }

  public void setRight(BinaryNode right) {
    this.right = right;
  }

  public Value getValue() {
    return value;
  }

  public void setValue(Value value) {
    this.value = value;
  }

  public Integer getValue1() {
    return value1;
  }

  public void setValue1(Integer value1) {
    this.value1 = value1;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  @Override
  public String toString() {
    return "BinaryNode{" + "value=" + value + '}';
  }
}

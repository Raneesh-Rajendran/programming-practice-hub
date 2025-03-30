package main.java.data_structures.tree.bt.array;

import main.java.models.Value;

public class Tree {

  private Value[] array;
  private Integer lastUsedIndex;

  public Tree(Integer size) {
    this.array = new Value[size];
    this.lastUsedIndex = 0;
    System.out.println("tree created");
  }

  public void insertNode(Value value) {
    if (isFull()) {
      System.out.println("tree is full");
      return;
    }
    array[lastUsedIndex] = value;
    lastUsedIndex += 1;
  }

  public Boolean isFull() {
      return lastUsedIndex == array.length;
  }

  public void deleteNode(Value value) {
    for (Value node : array) {
      if (node == value) {
        node = array[lastUsedIndex];
        lastUsedIndex -= 1;
        System.out.println("deleted");
        return;
      }
    }
    System.out.println("Not exists");
  }

  public void searchNode(Value value) {
    for (Value node : array) {
      if (node == value) {
        node = array[lastUsedIndex];
        System.out.println("height" + node);
        return;
      }
    }
    System.out.println("Not exists");
  }

  public void levelOrder() {
    for (Value value : array) {
      System.out.println(value);
    }
  }

  public void preOrder(Integer index) {
    if (index > lastUsedIndex) return;
    System.out.println(array[index]);
    preOrder(index * 2);
    preOrder(index * 2 + 1);
  }

  public void inOrder(Integer index) {
    if (index > lastUsedIndex) return;
    inOrder(index * 2);
    System.out.println(array[index]);
    inOrder(index * 2 + 1);
  }

  public void postOrder(Integer index) {
    if (index > lastUsedIndex) return;
    postOrder(index * 2);
    postOrder(index * 2 + 1);
    System.out.println(array[index]);
  }

  public void deleteTree() {
    array = null;
    System.out.println("tree deleted");
  }
}

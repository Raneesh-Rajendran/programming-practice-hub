package main.java.data_structures.stack.array;

import main.java.models.Value;

public class Stack {

  Value[] stack;
  private Integer topOfStack;

  public Stack(Integer size) {
    this.stack = new Value[size];
    this.topOfStack = -1;
  }

  public void push(Value value) {
    if (isStackFull()) System.out.println("stack is full");
    else if (topOfStack == -1) {
      stack[topOfStack + 1] = value;
      topOfStack++;
      System.out.println("pushed");
    }
  }

  public Value pop() {
    Value value = null;
    if (isStackEmpty()) System.out.println("stack is empty");
    else {
      value = stack[topOfStack];
      System.out.println(stack[topOfStack]);
      topOfStack--;
    }
    return value;
  }

  public Value peek() {
    Value value = null;
    if (isStackEmpty()) System.out.println("stack is empty");
    else {
      value = stack[topOfStack];
      System.out.println(stack[topOfStack]);
    }
    return value;
  }

  public Boolean isStackFull() {
      return topOfStack == stack.length - 1;
  }

  public Boolean isStackEmpty() {
      return topOfStack == -1;
  }

  public void deleteStack() {
    stack = null;
  }
}

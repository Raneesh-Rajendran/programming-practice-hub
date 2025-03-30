package main.java.miscellaneous;

import java.util.*;

public class StackExample {

  public static void main(String[] args) {

    Stack<Integer> stack = new Stack<>();
    Queue<Integer> queue = new LinkedList<>();
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

    stack.add(1);
    stack.add(2);

    queue.add(1);
    queue.remove();

    priorityQueue.add(1);
    priorityQueue.add(2);
    priorityQueue.add(3);
    priorityQueue.remove();

    arrayDeque.add(1);
    arrayDeque.add(2);
    arrayDeque.add(3);
    arrayDeque.removeFirst();
    arrayDeque.removeLast();

    System.out.println(stack.pop());
    System.out.println(queue.poll());
    System.out.println(priorityQueue.poll());
    System.out.println(arrayDeque.poll());
  }
}

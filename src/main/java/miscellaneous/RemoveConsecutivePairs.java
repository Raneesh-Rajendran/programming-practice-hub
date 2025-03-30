package main.java.miscellaneous;

import java.util.Stack;

public class RemoveConsecutivePairs {

  public static void main(String[] args) {
    System.out.println(solve("abba"));
  }

  public static String solve(String A) {
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < A.length(); i++) {
      if (!stack.isEmpty() && stack.peek() == A.charAt(i)) {
        stack.pop();
      } else {
        stack.push(A.charAt(i));
      }
    }

    StringBuilder builder = new StringBuilder();
    while (!stack.isEmpty()) {
      builder.append(stack.pop());
    }

    return builder.reverse().toString();
  }
}

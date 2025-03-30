package main.java.miscellaneous;

import java.util.Stack;

public class EvaluateExpression {

  public static void main(String[] args) {}

  public int evalRPN(String[] A) {
    Stack<Integer> stack = new Stack<>();
    for (String element : A) {
      if (element.equals("+")
          || element.equals("-")
          || element.equals("*")
          || element.equals("/")) {
        int num1 = stack.pop();
        int num2 = stack.pop();
        switch (element) {
          case "+":
            stack.push(num2 + num1);
            break;
          case "-":
            stack.push(num2 - num1);
            break;
          case "*":
            stack.push(num2 * num1);
            break;
          case "/":
            stack.push(num2 / num1);
            break;
          default:
            break;
        }
      } else stack.push(Integer.parseInt(element));
    }
    return stack.peek();
  }
}

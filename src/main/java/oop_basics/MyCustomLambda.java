package main.java.oop_basics;

public class MyCustomLambda {

  @FunctionalInterface // just informational annotation
  interface CustomLambda {
    String performOperation(int a, String b);
  }

  public static void main(String[] args) {
    CustomLambda additionLambda = (a, b) -> a + b;
    System.out.println(additionLambda.performOperation(5, "2"));
  }
}

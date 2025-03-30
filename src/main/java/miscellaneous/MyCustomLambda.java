package main.java.miscellaneous;

public class MyCustomLambda {
  public static void main(String[] args) {
    CustomLambda additionLambda = (a, b) -> a + b;
    System.out.println(additionLambda.performOperation(5, "2"));
  }

  @FunctionalInterface
  interface CustomLambda {
    String performOperation(int a, String b);
  }
}

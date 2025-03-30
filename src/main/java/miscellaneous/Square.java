package main.java.miscellaneous;

public interface Square {

  int calculate(int x);

  default void factor(int x) {
    System.out.println("default method");
  }
}

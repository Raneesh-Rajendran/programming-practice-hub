package main.java.miscellaneous;

public class FunctionalProgramming {

  public static void main(String[] args) {
    Square s = (int x) -> x * x;
    int ans = s.calculate(10);
    System.out.println(ans);
  }
}

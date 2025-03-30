package main.java.miscellaneous;

public class SwapWithVariables {

  public static void main(String[] args) {

    String str = "My name is Raneesh";
    int count = 0;

    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == 'e') count++;
    }

    System.out.println(count);
  }

  public void swapWithVariables() {
    int a = 20;
    int b = 10;

    a = a + b;
    b = a - b;
    a = a - b;

    System.out.println(a + " " + b);
  }
}

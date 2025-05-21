package main.java.miscellaneous;

public class StringMethods {

  public static void main(String[] args) {
    String tester = "3HF";
    tester =
        ""
            + tester.charAt(0)
            + tester.charAt(0)
            + tester.charAt(1)
            + tester.charAt(1)
            + tester.charAt(2)
            + tester.charAt(2);
    System.out.println(tester);


    tester = "3HF";
    StringBuilder builer = new StringBuilder();
    builer.append(tester.charAt(0));
    builer.append(tester.charAt(0));
    builer.append(tester.charAt(1));
    builer.append(tester.charAt(2));
    builer.append(tester.charAt(2));
    builer.append(tester.charAt(2));
    System.out.println(builer);

    tester = "66FFGG";
    System.out.println(tester.substring(0, 2));
    System.out.println(tester.substring(2, 4));
    System.out.println(tester.substring(4, 6));
  }
}

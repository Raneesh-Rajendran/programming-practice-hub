package main.java.miscellaneous;

public class PassByValue {

  public static void main(String[] args) {

    PassByValue solution = new PassByValue();
    solution.run();
  }

  public void run() {
    Integer x = 5;
    Integer y = 9;
    System.out.println("Before Swap x: " + x + " y: " + y);
    swap(x, y);
    System.out.println("After Swap x: " + x + " y: " + y);

    String str = "raneesh";
    String str1 = str;
    str1 = "abc";

    System.out.println(str + " " + str1);
  }

  private void swap(Integer a, Integer b) {
    Integer temp = a;
    a = b;
    b = temp;
  }

  public void stringUnderscore() {
    String str = "welcome to bangalore Raneesh";
    String output = "";

    String[] strArray = str.split(" ");

    for (int i = 0; i < strArray.length; i++) {
      if (i == strArray.length - 1) output = output + strArray[i];
      else output = output + strArray[i] + "_";
    }

    System.out.println(output);
  }
}

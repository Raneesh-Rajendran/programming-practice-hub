package main.java.miscellaneous;

import java.util.List;

public class StrictlyPassByValue {
  public static void main(String[] args) {
    Person p1 = new Person();
    p1.age = 10;
    p1.name = "ABC";
    Person p2 = new Person();
    p2.age = 20;
    p2.name = "DEF";

    fun(p1, p2);
    System.out.println(p1.age + p1.name);
    System.out.println(p2.age + p2.name);
  }

  static void fun(Person p1dash, Person p2dash) {
    Person temp = p1dash;
    p1dash = p2dash;
    p2dash = temp;
  }

  public static class Person {
    String name;
    int age;
  }

  public static class Singleton {

    private static Singleton single_instance = null;

    public static Singleton getInstance() {
      if (single_instance == null) single_instance = new Singleton();
      return single_instance;
    }
  }

  /*
  ["hello", "hell", "heal", "heat"]
  output = "he"

  ["hello", "hell", "hel", ]
  output = "hel"

  ["hello", "hell", "heal", "heat", "high"]
  output = "h"

  ["hello", "hell", "heal", "fight", "high"]
  output = ""

  O(n * m)
  n = min length of the string
  m = length of the array
   */
  public static class StringManipulation {

    public static void main(String[] args) {
      List<String> stringList = List.of("hello");
      String result = StringManipulation.commonPrefix(stringList);
      System.out.println(result);
    }

    public static String commonPrefix(List<String> stringList) {

      if (stringList.size() == 1) return stringList.get(0);

      StringBuilder result = new StringBuilder();

      int minLength = Integer.MAX_VALUE;
      for (String element : stringList) {
        minLength = Math.min(minLength, element.length());
      }

      for (int i = 0; i < minLength; i++) {
        char ch = stringList.get(0).charAt(i);
        for (int j = 1; j < stringList.size(); j++) {
          if (ch != stringList.get(j).charAt(i)) return result.toString();
        }
        result.append(ch);
      }

      return result.toString();
    }
  }
}

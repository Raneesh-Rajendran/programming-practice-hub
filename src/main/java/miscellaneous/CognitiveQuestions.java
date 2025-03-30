package main.java.miscellaneous;

import java.util.HashSet;

public class CognitiveQuestions {

  public static void main(String[] args) {
    String str = "Raneessh";
    duplicateCharaters(str);

    int number = 5;
    System.out.println(factorial(number));
  }

  private static Integer factorial(int number) {
    if (number < 2) return 1;
    return number * factorial(number - 1);
  }

  private static void duplicateCharaters(String str) {

    char[] array = str.toCharArray();
    HashSet<Character> set = new HashSet<>();
    for (char element : array) {
      if (!(set.add(element))) System.out.println(element);
    }
  }
}

package main.java.miscellaneous;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
Given a list of integers, find out all the numbers starting with 1 using Stream functions?
Input : {56, 23, 78, 14, 98, 11, 876, 45, 234, 101, 9876, 17, 87, 1}
Output : {1, 11, 14, 17, 101}
 */
public class Coforge {

  public static void main(String[] args) {

    List<Integer> array1 =
        Arrays.asList(56, 23, 78, 14, 98, 11, 876, 45, 234, 101, 9876, 17, 87, 1);

    array1.stream()
        .map(String::valueOf)
        .filter(e -> e.startsWith("1"))
        .sorted(Comparator.naturalOrder())
        .forEach(System.out::println);
  }
}

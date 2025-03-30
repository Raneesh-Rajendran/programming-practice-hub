package main.java.miscellaneous; /*
                                 Write a java code to find out the most frequent element in below array
                                 //{ 40, 50, 30, 40, 50, 30, 30 }
                                 //{ 40, 50, 30, 40, 40, 50, 30, 30 }
                                  */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Frequency {
  public static void main(String[] args) {
    System.out.println(Frequency.generateFrequency(List.of(40, 50, 30, 40, 50, 30, 30)));
    System.out.println(Frequency.generateFrequency(List.of(40, 50, 30, 40, 40, 50, 30, 30)));
    String name = "John";
    String anotherName = "John";
    String newName = "John";

    System.out.println(name == newName); // line 1
    System.out.println(name == anotherName); // line 2
  }

  public static Integer generateFrequency(List<Integer> input) {
    Map<Integer, Integer> frequency = new HashMap<>();
    int ans = Integer.MIN_VALUE;
    int maxFrequency = Integer.MIN_VALUE;

    for (Integer element : input) {
      frequency.put(element, frequency.getOrDefault(element, 0) + 1);
    }

    for (Map.Entry<Integer, Integer> element : frequency.entrySet()) {
      maxFrequency = Math.max(maxFrequency, element.getValue());
    }

    for (Map.Entry<Integer, Integer> element : frequency.entrySet()) {
      if (element.getValue() == maxFrequency) ans = Math.max(ans, element.getKey());
    }
    return ans;
  }
}

package main.java.miscellaneous;

import java.util.*;
import java.util.stream.Collectors;

public class IntelligenceQuestions {

  public static void main(String[] args) {

    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);

    Integer result =
        list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).get(2 - 1);
    System.out.println(result);

    Map<Integer, Integer> map = new HashMap<>();
    map.put(1, 4);
    map.put(3, 7);
    map.put(9, 7);
    map.put(2, 8);

    List<Integer> valuesList =
        map.entrySet().stream()
            .filter(data -> data.getValue() == 7)
            .map(element -> element.getKey())
            .collect(Collectors.toList());

    valuesList.forEach(System.out::println);
  }
}

package main.java.miscellaneous;

import java.io.*;
import java.util.*;

class MostActive {

  /*
   * Complete the 'mostActive' function below.
   *
   * The function is expected to return a STRING_ARRAY.
   * The function accepts STRING_ARRAY customers as parameter.
   */

  public static List<String> mostActive(List<String> customers) {
    // Write your code here
    List<String> list = new ArrayList<>();
    Float percentage = (float) (100 / customers.size());
    ListIterator<String> iterator = customers.listIterator();
    Map<String, Float> map = new HashMap<>();
    while (iterator.hasNext()) {
      String key = iterator.next();
      Float temp = map.get(key);
      if (temp == null) temp = 0.0f;
      map.put(key, temp + percentage);
    }

    for (Map.Entry<String, Float> entry : map.entrySet()) {
      if (entry.getValue() >= 5.0f) list.add(entry.getKey());
    }

    Comparator<String> comparator = Comparator.naturalOrder();
    list.sort(comparator);
    return list;
  }

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);

    int customersCount = Integer.parseInt(scanner.nextLine().trim());

    List<String> customers = new ArrayList<>();

    for (int i = 0; i < customersCount; i++) {
      String customersItem = scanner.nextLine();
      customers.add(customersItem);
    }

    List<String> result = MostActive.mostActive(customers);

    for (int i = 0; i < result.size(); i++) {
      System.out.println(result.get(i));

      if (i != result.size() - 1) {
        System.out.println("\n");
      }
    }
  }
}

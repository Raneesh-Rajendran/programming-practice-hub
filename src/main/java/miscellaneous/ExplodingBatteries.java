package main.java.miscellaneous;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExplodingBatteries {

  public static void main(String[] args) {

    List<Integer> list = new ArrayList<>();
    list.add(0);
    list.add(0);
    int i = 1;

    while (list.size() < 4711) {
      int temp = i;
      while (temp > 0) {
        list.add(i);
        temp--;
      }
      i += 1;
    }

    System.out.println(list);

    Scanner in = new Scanner(System.in);
    while (in.hasNextLine()) {
      int threshold = Integer.parseInt(in.nextLine().trim());
      if (threshold == 0) break;
      System.out.println(list.get(threshold));
    }
  }
}

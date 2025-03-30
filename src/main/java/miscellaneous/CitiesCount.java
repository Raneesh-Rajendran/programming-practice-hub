package main.java.miscellaneous;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CitiesCount {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int noOfTestCases = Integer.parseInt(in.nextLine().trim());
    while (noOfTestCases > 0) {

      int noOfTestCities = Integer.parseInt(in.nextLine().trim());
      Set<String> set = new HashSet<>();
      while (noOfTestCities > 0) {
        set.add(in.nextLine().trim());
        noOfTestCities--;
      }
      System.out.println(set.size());
      noOfTestCases--;
    }
  }
}

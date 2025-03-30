package main.java.miscellaneous;

import java.util.Arrays;
import java.util.Date;

public class SumPattern {

  public static void main(String[] args) {

    int[] array = new int[] {1, 2, 3, 4, 5};

    sumPattern(array);
  }

  public static void sumPattern(int[] array) {
    if (array.length < 1) return;

    int[] temp = new int[array.length - 1];
    for (int i = 0; i < array.length - 1; i++) {
      int sum = array[i] + array[i + 1];
      temp[i] = sum;
    }
    sumPattern(temp);
    System.out.println(Arrays.toString(array));
  }
}

final class Emp {
  final String name;
  final int id;
  final Date date;

  public Emp(String name, int id, Date date) {
    this.name = name;
    this.id = id;
    this.date = date;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  public Date getDate() {
    return date;
  }
}

final class Address {
  final String city;
  final String name;

  public Address(String city, String name) {
    this.city = city;
    this.name = name;
  }
}

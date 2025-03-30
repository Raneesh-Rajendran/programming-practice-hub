package main.java.miscellaneous;

import java.util.Scanner;

public class CountArray {

  public static void main(String[] args) {

    int[][] array = new int[4][4];
    Scanner in = new Scanner(System.in);

    for (int i = 0; i < 4; i++) {
      String[] row = in.nextLine().split(" ");
      for (int j = 0; j < row.length; j++) {
        array[i][j] = Integer.parseInt(row[j]);
      }
    }
    int[][] countArray = new int[4][4];
    countArray[3][0] = 1;
    for (int i = 3; i >= 0; i--) {
      for (int j = 0; j <= 3; j++) {

        if (i - 1 >= 0 && array[i - 1][j] == 1) countArray[i - 1][j] = 0;

        if (i - 1 >= 0 && array[i - 1][j] == 0) countArray[i - 1][j] = 1;

        if (j + 1 < 4 && array[i][j + 1] == 1) countArray[i][j + 1] = 0;

        if (j + 1 < 4 && array[i][j + 1] == 0) countArray[i][j + 1] = 1;

        if (countArray[i][j] > 0) {
          if (i + 1 < 4
              && i + 1 >= 0
              && j - 1 < 4
              && j - 1 >= 0
              && countArray[i][j - 1] >= 1
              && countArray[i + 1][j] >= 1) countArray[i][j] = 2;
          else if (i + 1 < 4 && i + 1 >= 0 && countArray[i + 1][j] >= 1) countArray[i][j] = 1;
          else if (j - 1 >= 0 && j - 1 < 4 && countArray[i][j - 1] >= 1) countArray[i][j] = 1;
        }
      }
    }

    for (int i = 0; i < 4; i++) {
      System.out.println("\n");
      for (int j = 0; j < 4; j++) {
        System.out.print(countArray[i][j] + " ");
      }
    }

    System.out.println(countArray[0][3]);
  }
}

package main.java.algorithms;

public class Bubble {

  public static void main(String[] args) {
    int[] array = {2, 3, 10, 5, 8, 4, 3, 1, 2, 9, 7, 8};

    bubbleSort(array);

    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + "  ");
    }
  }

  private static int[] bubbleSort(int[] array) {

    for (int i = 0; i < array.length - 1; i++) {
      for (int j = 0; j < array.length - i - 1; j++) {
        if (array[j] > array[j + 1]) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
      }
    }
    return array;
  }
}

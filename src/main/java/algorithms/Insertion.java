package main.java.algorithms;

public class Insertion {

  public static void main(String[] args) {
    int[] array = {2, 3, 10, 5, 8, 4, 3, 1, 2, 9, 7, 8};

    insertionSort(array);

    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + "  ");
    }
  }

  private static int[] insertionSort(int[] array) {

    for (int i = 1; i < array.length; i++) {
      int temp = array[i], j = i;
      while (j > 0 && array[j - 1] > temp) {
        array[j] = array[j - 1];
        j--;
      }
      array[j] = temp;
    }
    return array;
  }
}

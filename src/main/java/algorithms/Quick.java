package main.java.algorithms;

public class Quick {

  public static void main(String[] args) {
    int[] array = {2, 3, 10, 5, 8, 4, 3, 1, 2, 9, 7, 8};
    quickSort(array, 0, array.length - 1);

    String str = "malayalam";
    System.out.println(palindrome(str, 0, str.length() - 1));

    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + "  ");
    }
  }

  private static void quickSort(int[] array, int start, int end) {
    if (start < end) {
      int pivot = pivotPartition(array, start, end);
      quickSort(array, start, pivot - 1);
      quickSort(array, pivot + 1, end);
    }
  }

  private static int pivotPartition(int[] array, int start, int end) {
    int pivot = end;
    int i = start - 1;
    for (int j = start; j <= end; j++) {
      if (array[j] <= array[pivot]) {
        i++;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
      }
    }
    return i;
  }

  public static String palindrome(String str, int start, int length) {
    if (start != length) {
      if (str.charAt(start) == str.charAt(length)) palindrome(str, start + 1, length - 1);
      else return "Not a palindrome";
    }
    return "palindrome";
  }
}

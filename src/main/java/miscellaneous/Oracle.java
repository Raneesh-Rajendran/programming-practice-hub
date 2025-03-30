package main.java.miscellaneous;

import java.util.Arrays;

/*
Write a function that takes a non-empty array of integers that are sorted in ascending order and returns the new array
of same length with the squares of original integers also in ascending order.

[-10, -4, 2, 3, 5, 6, 8, 9]
[4, 9, 16, 25, 36, 64, 81, 100]

Time Complexity = O(n)

 */
public class Oracle {

  public static void main(String[] args) {

    int[] array = new int[] {-10, -4, 2, 3, 5, 6, 8, 9};
    System.out.println(Arrays.toString(squareAndSort(array)));
  }

  public static int[] squareAndSort(int[] arr) {
    int n = arr.length;
    int[] result = new int[n];
    //        int resultIdx = n - 1;

    int first = 0, last = n - 1;

    //        while(first <= last){
    //            int firstSquare = arr[first] * arr[first];
    //            int lastSquare = arr[last] * arr[last];
    //
    //            if(firstSquare < lastSquare){
    //                result[resultIdx--] = lastSquare;
    //                last--;
    //            } else {
    //                result[resultIdx--] = firstSquare;
    //                first++;
    //            }
    //        }

    for (int i = n - 1; i >= 0; i--) {
      if (Math.abs(arr[first]) < Math.abs(arr[last])) {
        result[i] = arr[last] * arr[last];
        last--;
      } else {
        result[i] = arr[first] * arr[first];
        first++;
      }
    }
    return result;
  }
}

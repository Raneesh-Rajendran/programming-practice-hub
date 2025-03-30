package main.java.miscellaneous;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class PrintLargest {
  static void printLargest(Vector<String> arr) {

    // A comparison function which is used by sort() in printLargest()
    arr.sort(
        (X, Y) -> {

          // first append Y at the end of X
          String XY = X + Y;

          // then append X at the end of Y
          String YX = Y + X;

          // Now see which of the two formed numbers is greater
          return XY.compareTo(YX) > 0 ? -1 : 1;
        });

    for (String s : arr) System.out.print(s);
  }

  public static String largestNumber(int[] nums) {
    List<String> arr =
        Arrays.stream(nums)
            .mapToObj(String::valueOf)
            .sorted(
                (X, Y) -> {
                  String XY = X + Y;
                  String YX = Y + X;
                  return XY.compareTo(YX) > 0 ? -1 : 1;
                })
            .collect(Collectors.toList());

    StringBuilder builder = new StringBuilder();
    for (String s : arr) {
      builder.append(s);
    }
    String result = builder.toString();

    int i = 0;
    while (i < result.length())
      if (result.charAt(i) == '0') i++;
      else break;

    if (i == result.length()) return "0";

    return result.substring(i);
  }

  // Driver code
  public static void main(String[] args) {

    //        Vector<String> arr;
    //        arr = new Vector<>();
    //
    //        // output should be 6054854654
    //        arr.add("54");
    //        arr.add("546");
    //        arr.add("548");
    //        arr.add("60");
    //        printLargest(arr);

    //        int[] arr = new int[]{0,0};
    int[] arr = new int[] {54, 546, 548, 60};
    System.out.println(largestNumber(arr));
  }
}

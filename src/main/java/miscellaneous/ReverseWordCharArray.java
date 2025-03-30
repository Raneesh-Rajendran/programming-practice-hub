package main.java.miscellaneous;

import java.util.Arrays;

public class ReverseWordCharArray {

  public static char[] reverseWords(char[] input) {
    int start = 0;
    int end = 0;

    for (int i = 0; i < input.length; i++) {
      while (i < input.length && input[i] == ' ') {
        i++;
      }
      start = i;

      while (i < input.length && input[i] != ' ') {
        i++;
      }
      end = i - 1;

      while (end > start) {
        char temp = input[start];
        input[start] = input[end];
        input[end] = temp;
        start++;
        end--;
      }
    }

    return input;
  }

  public static void main(String[] args) {
    char[] input =
        new char[] {
          'I', ' ', 'd', 'r', 'i', 'v', 'e', ' ', 'w', 'i', 't', 'h', ' ', 'B', 'o', 'l', 't'
        };
    char[] output =
        new char[] {
          'I', ' ', 'e', 'v', 'i', 'r', 'd', ' ', 'h', 't', 'i', 'w', ' ', 't', 'l', 'o', 'B'
        };

    if (Arrays.equals(output, reverseWords(input))) System.out.println("Both character are equal.");
  }
}

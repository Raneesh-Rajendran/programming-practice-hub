package main.java.miscellaneous;

public class PrintPattern {

  public static void main(String[] args) {
    String str1 = "javaraneeshtourist";
    String str2 = "javatravellerraneesh";

    int startIdx = 0, endIdx = 0, len = 0;
    for (int i = 0; i < str2.length(); i++) {
      if (len < endIdx - startIdx) len = endIdx - startIdx;
      for (int j = 0; j < str1.length(); j++) {
        if (str1.charAt(i) == str2.charAt(j)) {
          startIdx = i;
          int k = i, l = j;
        }
      }
    }
  }

  static void printPattern(int n) {
    // Variable initialization
    // Line count
    int line_no = 1;

    // Loop to print desired pattern
    int curr_star = 0;
    for (line_no = 1; line_no <= n; ) {
      // If current star count is less than
      // current line number
      if (curr_star < line_no) {
        System.out.print("* ");
        curr_star++;
        continue;
      }

      // Else time to print a new line
      if (curr_star == line_no) {
        System.out.println();
        line_no++;
        curr_star = 0;
      }
    }
  }
}

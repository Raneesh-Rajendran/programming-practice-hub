package main.java.miscellaneous;

public class Longest_common_substr {

  public static void main(String[] args) {
    String X = "javaraneeshtourist";
    String Y = "javatravellerraneesh";
    String resultStr = "";

    int m = X.length();
    int n = Y.length();
    int[][] indexMap = new int[m + 1][n + 1];
    int len = 0;
    int row = 0, col = 0;

    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == 0 || j == 0) indexMap[i][j] = 0;
        else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
          indexMap[i][j] = indexMap[i - 1][j - 1] + 1;
          if (len < indexMap[i][j]) {
            len = indexMap[i][j];
            row = i;
            col = j;
          }
        } else indexMap[i][j] = 0;
      }
    }

    while (indexMap[row][col] != 0) {
      resultStr = X.charAt(row - 1) + resultStr;
      --len;
      row--;
      col--;
    }
    System.out.println(resultStr);
  }
}

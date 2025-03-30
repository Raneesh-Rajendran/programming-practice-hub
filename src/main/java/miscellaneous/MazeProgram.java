package main.java.miscellaneous;

import java.util.Scanner;

public class MazeProgram {

  // cell validation (x, y)
  private static boolean isValidCell(int x, int y, int row, int column) {
      return x >= 0 && y >= 0 && x < row && y < column;
  }

  private static int countPaths(
          int[][] array, int x, int y, boolean[][] visited, int count, int row, int column) {
    // if end point : right-top cell is found, increment the path count
    if (x == 0 && y == column - 1) {
      count++;
      return count;
    }

    // mark current cell as visited
    visited[x][y] = true;

    // if current cell is valid and also an open cell
    if (isValidCell(x, y, row, column) && array[x][y] == 0) {
      // up `(x, y)` ——> `(x - 1, y)`
      if (x - 1 >= 0 && !visited[x - 1][y]) {
        count = countPaths(array, x - 1, y, visited, count, row, column);
      }
      // right `(x, y)` ——> `(x, y + 1)`
      if (y + 1 < column && !visited[x][y + 1]) {
        count = countPaths(array, x, y + 1, visited, count, row, column);
      }

      // go down `(x, y)` ——> `(x + 1, y)`
      if (x + 1 < row && !visited[x + 1][y]) {
        count = countPaths(array, x + 1, y, visited, count, row, column);
      }

      // go left `(x, y)` ——> `(x, y - 1)`
      if (y - 1 >= 0 && !visited[x][y - 1]) {
        count = countPaths(array, x, y - 1, visited, count, row, column);
      }
    }
    // reverse from current cell marking as not visited till the alternative path if available,
    // once transversed all possible path, recursion will go back in last visited path and return
    // the count to main.
    visited[x][y] = false;

    return count;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String[] rowColumn = in.nextLine().split(" ");

    int row = Integer.parseInt(rowColumn[0]);
    int column = Integer.parseInt(rowColumn[1]);

    int[][] array = new int[row][column];
    for (int i = 0; i < 4; i++) {
      String[] rowData = in.nextLine().split(" ");
      for (int j = 0; j < rowData.length; j++) {
        array[i][j] = Integer.parseInt(rowData[j]);
      }
    }

    // count number of unique paths from source to destination
    int count = 0;
    // 2D matrix to keep track of cells involved in current path
    boolean[][] visited = new boolean[row][column];
    // start point : left-bottom cell (3, 0)`
    count = countPaths(array, row - 1, 0, visited, count, row, column);
    System.out.println("The total number of unique paths are " + count);
  }
}

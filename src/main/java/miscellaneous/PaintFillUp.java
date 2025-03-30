package main.java.miscellaneous;

import java.util.LinkedList;
import java.util.Queue;

public class PaintFillUp {

  public static void main(String[] args) {

    int[][] canvas =
        new int[][] {
          {1, 5, 5, 1, 5, 0, 2, 3, 4},
          {1, 4, 5, 1, 0, 2, 3, 4, 4},
          {1, 3, 5, 1, 0, 2, 3, 4, 4},
          {1, 5, 5, 1, 0, 2, 3, 4, 4},
          {1, 0, 1, 1, 0, 2, 3, 4, 4}
        };

    int row = canvas.length, column = canvas[0].length;
    int x = 0, y = 8, color = 6;
    int oldColor = canvas[x][y];

    System.out.println(oldColor);
    System.out.println(color);

    // fillMethod(canvas, x, y ,row, column, oldColor , color);

    fillMethodNonRecursive(canvas, x, y, row, column, oldColor, color);

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) {
        System.out.print(canvas[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static int valid(int x, int y, int n, int m) {
    if (x < 0 || y < 0 || x >= n || y >= m) {
      return 0;
    }
    return 1;
  }

  private static void fillMethodNonRecursive(
      int[][] canvas, int x, int y, int row, int column, int oldColor, int color) {

    int[][] visited = new int[row][column];

    Queue<Integer> xArray = new LinkedList<>();
    Queue<Integer> yArray = new LinkedList<>();

    xArray.add(x);
    yArray.add(y);

    visited[x][y] = 1;

    while (!xArray.isEmpty() && !yArray.isEmpty()) {

      int x1 = xArray.remove();
      int y1 = yArray.remove();

      canvas[x1][y1] = color;

      // north
      if ((valid(x1 + 1, y1, row, column) == 1)
          && visited[x1 + 1][y1] == 0
          && canvas[x1 + 1][y1] == oldColor) {

        xArray.add(x1 + 1);
        yArray.add(y1);
        visited[x1 + 1][y1] = 1;
      }

      // south
      if ((valid(x1 - 1, y1, row, column) == 1)
          && visited[x1 - 1][y1] == 0
          && canvas[x1 - 1][y1] == oldColor) {

        xArray.add(x1 - 1);
        yArray.add(y1);
        visited[x1 - 1][y1] = 1;
      }

      // east
      if ((valid(x1, y1 + 1, row, column) == 1)
          && visited[x1][y1 + 1] == 0
          && canvas[x1][y1 + 1] == oldColor) {
        xArray.add(x1);
        yArray.add(y1 + 1);
        visited[x1][y1 + 1] = 1;
      }

      // west
      if ((valid(x1, y1 - 1, row, column) == 1)
          && visited[x1][y1 - 1] == 0
          && canvas[x1][y1 - 1] == oldColor) {
        xArray.add(x1);
        yArray.add(y1 - 1);
        visited[x1][y1 - 1] = 1;
      }
    }
  }

  private static void fillMethod(
      int[][] canvas, int x, int y, int row, int column, int oldColor, int color) {

    if (x < 0 || x > row - 1 || y < 0 || y > column - 1) return;

    if (canvas[x][y] != oldColor) return;

    canvas[x][y] = color;

    fillMethod(canvas, x - 1, y, row, column, oldColor, color); // north
    fillMethod(canvas, x, y - 1, row, column, oldColor, color); // west
    fillMethod(canvas, x, y + 1, row, column, oldColor, color); // east
    fillMethod(canvas, x + 1, y, row, column, oldColor, color); // south
  }
}

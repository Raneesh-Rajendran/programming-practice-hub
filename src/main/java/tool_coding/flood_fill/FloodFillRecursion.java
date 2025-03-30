package main.java.tool_coding.flood_fill;

public class FloodFillRecursion {

  static int M = 8;
  static int N = 8;

  public static void main(String[] args) {

    int[][] screen = {
      {1, 1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 0, 0},
      {1, 0, 0, 1, 1, 0, 1, 1},
      {1, 2, 2, 2, 2, 0, 1, 0},
      {1, 1, 1, 2, 2, 0, 1, 0},
      {1, 1, 1, 2, 2, 2, 2, 0},
      {1, 1, 1, 1, 1, 2, 1, 1},
      {1, 1, 1, 1, 1, 2, 2, 1},
    };

    int x = 7, y = 1, newC = 3;
    floodFill(screen, x, y, newC);

    System.out.println("Updated screen after call to floodFill: ");
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) System.out.print(screen[i][j] + " ");
      System.out.println();
    }
  }

  private static void floodFill(int[][] screen, int x, int y, int newC) {

    int prevC = screen[x][y];
    floodFillUtil(screen, x, y, prevC, newC);
  }

  private static void floodFillUtil(int[][] screen, int x, int y, int prevC, int newC) {

    // Base cases
    if (x < 0 || x >= screen.length || y < 0 || y >= screen[0].length) return;

    if (screen[x][y] != prevC) return;

    // Replace the color at (x, y)
    screen[x][y] = newC;

    // Recur for north, east, south and west
    floodFillUtil(screen, x + 1, y, prevC, newC);
    floodFillUtil(screen, x - 1, y, prevC, newC);
    floodFillUtil(screen, x, y + 1, prevC, newC);
    floodFillUtil(screen, x, y - 1, prevC, newC);
  }
}

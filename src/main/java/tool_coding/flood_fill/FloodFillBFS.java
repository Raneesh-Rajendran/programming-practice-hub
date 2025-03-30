package main.java.tool_coding.flood_fill;

import java.util.LinkedList;
import java.util.Queue;

class Pair implements Comparable<Pair> {
  int x;
  int y;

  public Pair(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public int compareTo(Pair o) {
    return y - o.y;
  }
}

public class FloodFillBFS {

  public static int validCoord(int x, int y, int n, int m) {
    if (x < 0 || y < 0) {
      return 0;
    }
    if (x >= n || y >= m) {
      return 0;
    }
    return 1;
  }

  // Function to run bfs
  public static void bfs(int n, int m, int[][] data, int x, int y, int color) {

    // Visiing array
    int[][] vis = new int[data.length][data[0].length];

    // Creating queue for bfs
    Queue<Pair> obj = new LinkedList<>();

    // Pushing pair of {x, y}
    Pair pq = new Pair(x, y);
    obj.add(pq);

    // Marking {x, y} as visited
    vis[x][y] = 1;

    // Until queue is empty
    while (!obj.isEmpty()) {
      // Extracting front pair
      Pair coordinate = obj.peek();
      int x1 = coordinate.x;
      int y1 = coordinate.y;
      int preColor = data[x1][y1];

      data[x1][y1] = color;

      // Poping front pair of queue
      obj.remove();

      // For Upside Pixel or Cell
      if ((validCoord(x1 + 1, y1, n, m) == 1)
          && vis[x1 + 1][y1] == 0
          && data[x1 + 1][y1] == preColor) {
        Pair p = new Pair(x1 + 1, y1);
        obj.add(p);
        vis[x1 + 1][y1] = 1;
      }

      // For Downside Pixel or Cell
      if ((validCoord(x1 - 1, y1, n, m) == 1)
          && vis[x1 - 1][y1] == 0
          && data[x1 - 1][y1] == preColor) {
        Pair p = new Pair(x1 - 1, y1);
        obj.add(p);
        vis[x1 - 1][y1] = 1;
      }

      // For Right side Pixel or Cell
      if ((validCoord(x1, y1 + 1, n, m) == 1)
          && vis[x1][y1 + 1] == 0
          && data[x1][y1 + 1] == preColor) {
        Pair p = new Pair(x1, y1 + 1);
        obj.add(p);
        vis[x1][y1 + 1] = 1;
      }

      // For Left side Pixel or Cell
      if ((validCoord(x1, y1 - 1, n, m) == 1)
          && vis[x1][y1 - 1] == 0
          && data[x1][y1 - 1] == preColor) {
        Pair p = new Pair(x1, y1 - 1);
        obj.add(p);
        vis[x1][y1 - 1] = 1;
      }
    }

    // Printing The Changed Matrix Of Pixels
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.print(data[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int nn, mm, xx, yy, color;
    nn = 8;
    mm = 8;

    int[][] dataa = {
      {1, 1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 0, 0},
      {1, 0, 0, 1, 1, 0, 1, 1},
      {1, 2, 2, 2, 2, 0, 1, 0},
      {1, 1, 1, 2, 2, 0, 1, 0},
      {1, 1, 1, 2, 2, 2, 2, 0},
      {1, 1, 1, 1, 1, 2, 1, 1},
      {1, 1, 1, 1, 1, 2, 2, 1}
    };

    xx = 4;
    yy = 4;
    color = 3;

    // Function Call
    bfs(nn, mm, dataa, xx, yy, color);
  }
}

package main.java.miscellaneous;

import java.util.ArrayList;
import java.util.Scanner;

class Figure {
  private final int x;
  private final int y;
  private int type;

  public Figure(int x, int y, int type) {
    this.x = x;
    this.y = y;
    this.type = type;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getType() {
    return type;
  }

  public void setType(int t) {
    type = t;
  }

  @Override
  public String toString() {
    return "Figure{" + "x=" + x + ", y=" + y + ", type=" + type + '}';
  }
}

public class Godzilla {
  public static final int G = 'G';
  public static final int N = '.';
  public static final int M = 'M';
  public static final int R = 'R';
  public static final int W = 'W';
  public static final int MG = 'L';

  public static void main(String[] args) {
    new Godzilla().run();
  }

  private void testCase(int column, int row, String[] allRows) {
    Figure[][] matrix = deploy(row, column, allRows);
    int destroyedCount = 0;
    while (getGodzillaPosition(matrix) != null) {
      destroyedCount = turnG(getGodzillaPosition(matrix), matrix, destroyedCount);
      turnM(getGodzillaPosition(matrix), matrix);
    }

    System.out.println(destroyedCount);
  }

  private Figure getGodzillaPosition(Figure[][] matrix) {
    int rowLength = matrix.length;
    int colLength = matrix[0].length;
    boolean found = false;
    Figure godzilla = null;
    for (int a = 0; a < rowLength; a++) {
      for (int b = 0; b < colLength; b++) {
        if (matrix[a][b].getType() == G) {
          found = true;
          godzilla = matrix[a][b];
          break;
        }
      }
      if (found) break;
    }
    return godzilla;
  }

  private int turnG(Figure godzilla, Figure[][] matrix, int destroyedCount) {
    int rowLength = matrix.length;
    int colLength = matrix[0].length;
    int x = godzilla.getX();
    int y = godzilla.getY();

    if (x - 1 >= 0 && matrix[x - 1][y].getType() == R && matrix[x - 1][y].getType() != W) { // north
      matrix[x][y].setType('W');
      matrix[x - 1][y].setType('G');
      destroyedCount++;
    } else if (y + 1 <= colLength - 1
        && matrix[x][y + 1].getType() == R
        && matrix[x][y + 1].getType() != W) { // east
      matrix[x][y].setType('W');
      matrix[x][y + 1].setType('G');
      destroyedCount++;
    } else if (x + 1 <= rowLength - 1
        && matrix[x + 1][y].getType() == R
        && matrix[x + 1][y].getType() != W) { // south
      matrix[x][y].setType('W');
      matrix[x + 1][y].setType('G');
      destroyedCount++;
    } else if (y - 1 >= 0
        && matrix[x][y - 1].getType() == R
        && matrix[x][y - 1].getType() != W) { // west
      matrix[x][y].setType('W');
      matrix[x][y - 1].setType('G');
      destroyedCount++;
    } else if (x - 1 >= 0
        && matrix[x - 1][y].getType() == N
        && matrix[x - 1][y].getType() != W) { // north
      if (matrix[x - 1][y].getType() == M) matrix[x - 1][y].setType(MG);
      else {
        matrix[x][y].setType('W');
        matrix[x - 1][y].setType('G');
      }
    } else if (y + 1 <= colLength - 1
        && matrix[x][y + 1].getType() == N
        && matrix[x][y + 1].getType() != W) { // east
      if (matrix[x][y + 1].getType() == M) matrix[x][y + 1].setType(MG);
      else {
        matrix[x][y].setType('W');
        matrix[x][y + 1].setType('G');
      }
    } else if (x + 1 <= rowLength - 1
        && matrix[x + 1][y].getType() == N
        && matrix[x + 1][y].getType() != W) { // south
      if (matrix[x + 1][y].getType() == M) matrix[x + 1][y].setType(MG);
      else {
        matrix[x][y].setType('W');
        matrix[x + 1][y].setType('G');
      }
    } else if (y - 1 >= 0
        && matrix[x][y - 1].getType() == N
        && matrix[x][y - 1].getType() != W) { // west
      if (matrix[x][y - 1].getType() == M) matrix[x][y - 1].setType(MG);
      else {
        matrix[x][y].setType('W');
        matrix[x][y - 1].setType('G');
      }
    }
    return destroyedCount;
  }

  private void turnM(Figure godzilla, Figure[][] matrix) {
    int rowLength = matrix.length;
    int colLength = matrix[0].length;

    ArrayList<Figure> mechs = calculateMesh(matrix);

    for (Figure mech : mechs) {
      int x = mech.getX();
      int y = mech.getY();

      if (y - 1 >= 0 && matrix[x][y - 1].getType() != R) { // west
        matrix[x][y - 1].setType(M);
      }
      if (x + 1 <= rowLength - 1 && matrix[x + 1][y].getType() != R) { // south
        matrix[x + 1][y].setType(M);
      }
      if (y + 1 <= colLength - 1 && matrix[x][y + 1].getType() != R) { // east
        matrix[x][y + 1].setType(M);
      }
      if (x - 1 >= 0 && matrix[x - 1][y].getType() != R) { // north
        matrix[x - 1][y].setType(M);
      }
    }

    checkMeshAgainstGodzilla(matrix);
  }

  private ArrayList<Figure> calculateMesh(Figure[][] matrix) {
    ArrayList<Figure> mechs = new ArrayList<Figure>();
    int rowLength = matrix.length;
    int colLength = matrix[0].length;

    for (int a = 0; a < rowLength; a++) {
      for (int b = 0; b < colLength; b++) {
        if (matrix[a][b].getType() == M) {
          mechs.add(matrix[a][b]);
        }
      }
    }
    return mechs;
  }

  private void checkMeshAgainstGodzilla(Figure[][] matrix) {

    int rowLength = matrix.length;
    int colLength = matrix[0].length;

    ArrayList<Figure> mechs = calculateMesh(matrix);

    Figure godzilla = getGodzillaPosition(matrix);

    for (int m = godzilla.getX(); m >= 0; m--) { // up
      if (matrix[m][godzilla.getY()].getType() == R) break;
      if (matrix[m][godzilla.getY()].getType() == M) {
        matrix[godzilla.getX()][godzilla.getY()].setType(M);
      }
    }
    for (int m = godzilla.getX(); m < rowLength; m++) { // down
      if (matrix[m][godzilla.getY()].getType() == R) break;
      if (matrix[m][godzilla.getY()].getType() == M) {
        matrix[godzilla.getX()][godzilla.getY()].setType(M);
        break;
      }
    }
    for (int n = godzilla.getY(); n < colLength; n++) { // right
      if (matrix[godzilla.getX()][n].getType() == R) break;
      if (matrix[godzilla.getX()][n].getType() == M) {
        matrix[godzilla.getX()][godzilla.getY()].setType(M);
        break;
      }
    }
    for (int n = godzilla.getY(); n >= 0; n--) { // left
      if (matrix[godzilla.getX()][n].getType() == R) break;
      if (matrix[godzilla.getX()][n].getType() == M) {
        matrix[godzilla.getX()][godzilla.getY()].setType(M);
        break;
      }
    }

    for (int a = 0; a < rowLength; a++) {
      for (int b = 0; b < colLength; b++) {
        if (matrix[a][b].getType() == MG) matrix[a][b].setType(M);
      }
    }
  }

  private Figure[][] deploy(int row, int column, String[] allRows) {
    Figure[][] matrix = new Figure[row][column];
    for (int a = 0; a < row; a++) {
      for (int b = 0; b < column; b++) {
        matrix[a][b] = new Figure(a, b, allRows[a].charAt(b));
      }
    }
    return matrix;
  }

  private void run() {
    Scanner scanner = new Scanner(System.in);
    int cases = Integer.parseInt(scanner.nextLine().trim());
    for (int a = 0; a < cases; a++) {
      String[] dimensions = scanner.nextLine().trim().split(" ");
      int column = Integer.parseInt(dimensions[0]);
      int row = Integer.parseInt(dimensions[1]);
      String[] allRows = new String[row];
      for (int b = 0; b < row; b++) {
        allRows[b] = scanner.nextLine().trim();
      }
      testCase(column, row, allRows);
    }
  }
}

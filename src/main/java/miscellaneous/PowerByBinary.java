package main.java.miscellaneous;

public class PowerByBinary {
  static int power(int x, int y, int p) {
    int res = 1; // Initialize result

    while (y > 0) {

      // If y is odd, multiply x with result
      if ((y & 1) != 0) res = res * x;

      // y must be even now
      y = y >> 1; // y = y/2
      x = x * x; // Change x to x^2
    }
    return res % p;
  }

  public static void main(String[] args) {
    int x = -1;
    int y = 1;
    int p = 20;

    int mod = power(x, y, p);
    System.out.print("Power is " + mod);
  }
}

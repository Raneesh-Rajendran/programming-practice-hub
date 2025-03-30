package main.java.miscellaneous;

public class VeryLargePower {
  public int solve(int A, int B) {

    long mod = 1000000007;

    long fact = 1;
    for (long i = 2; i <= B; i++) {
      fact = (fact * i) % (mod - 1);
    }
    int ans = (int) fastPow(A, fact, mod);
    return ans;
  }

  public long fastPow(long A, long p, long mod) {
    if (p == 0) return 1;

    long half = fastPow(A, p / 2, mod) % mod;

    if (p % 2 == 0) {
      return (half * half) % mod;
    } else {
      return (((A * half) % mod) * half) % mod;
    }
  }
}

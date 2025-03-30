package main.java.miscellaneous;

public class LatestPossibleDateSolverTest {

  public static void main(String[] args) {
    LatestPossibleDateSolver solver = new LatestPossibleDateSolver();

    // Test cases
    test(solver.solve("01-01"), "01-01");
    test(solver.solve("12-31"), "12-31");
    test(solver.solve("??-??"), "12-31");
    test(solver.solve("?1-??"), "01-31");
    test(solver.solve("0?-15"), "09-15");
    test(solver.solve("??-2?"), "12-29");
    test(solver.solve("1?-??"), "12-31");
    test(solver.solve("04-31"), "XX-XX");
    test(solver.solve("06-31"), "XX-XX");
    test(solver.solve("02-29"), "XX-XX");
    test(solver.solve("02-30"), "XX-XX");
    test(solver.solve("00-15"), "XX-XX");
    test(solver.solve("13-01"), "XX-XX");
    test(solver.solve("01-00"), "XX-XX");
    test(solver.solve("01-32"), "XX-XX");
    test(solver.solve("AB-CD"), "XX-XX");
    test(solver.solve("12345"), "XX-XX");
    test(solver.solve("01-01"), "01-01");
    test(solver.solve("12-31"), "12-31");
    test(solver.solve("02-28"), "02-28");
  }

  private static void test(String actual, String expected) {
    if (actual.equals(expected)) {
      System.out.println("Test passed: " + actual);
    } else {
      System.out.println("Test failed: Expected " + expected + ", but got " + actual);
    }
  }
}

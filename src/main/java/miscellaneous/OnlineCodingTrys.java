package main.java.miscellaneous;

public class OnlineCodingTrys {

  public static void main(String[] args) throws Exception {}

  public static void ifTest(boolean flag) {
    if (flag)
      if (flag)
        if (flag) System.out.println("False True");
        else System.out.println("True False");
      else System.out.println("True True");
    else System.out.println("False False");
  }

  private static void calculate(int i) {
    String val;
    switch (i) {
      case 2:
      default:
        val = "def";
    }
    System.out.println(val);
  }

  public void testRefs(String str, StringBuilder sb) {
    System.out.println(str + " " + sb);
    str = str + sb.toString();
    System.out.println(str + " " + sb);
    sb.append(str);
    str = null;
    sb = null;
  }

  public String toString() {
    int i = 0;
    if (i == 0) return null;
    else return "" + i;
  }
}

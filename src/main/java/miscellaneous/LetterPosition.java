package main.java.miscellaneous;

public class LetterPosition {

  public static void main(String[] args) {
    System.out.println(encode("abcd !#7"));
  }

  public static String encode(String str) {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) result.append(c & 31);
      else result.append(c);
    }
    return result.toString();
  }
}

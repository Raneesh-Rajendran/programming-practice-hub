package main.java.miscellaneous;

public class StringManipulation {

  public static void main(String[] args) {

    StringManipulation manipulation = new StringManipulation();
    // System.out.println(manipulation.reverseEachWord("Interview with Myself"));

    String str = "contactDetails";
    System.out.println(camelCaseReverse(str));
  }

  public static String camelCaseReverseRegex(String input) {
    return input.replaceAll(
        String.format(
            "%s|%s|%s",
            "(?<=[A-Z])(?=[A-Z][a-z])", "(?<=[^A-Z])(?=[A-Z])", "(?<=[A-Za-z])(?=[^A-Za-z])"),
        " ");
  }

  public static String camelCaseReverse(String input) {
    StringBuilder builder = new StringBuilder();
    builder.append(Character.toUpperCase(input.charAt(0)));
    for (int i = 1; i < input.length(); i++) {
      if (Character.isUpperCase(input.charAt(i))) builder.append(" " + input.charAt(i));
      else builder.append(input.charAt(i));
    }
    return builder.toString();
  }

  public String reverseEachWord(String sentence) {
    String reversedWord = "";

    String[] words = sentence.split(" ");

    for (String word : words) {
      StringBuffer sb = new StringBuffer(word);
      sb.reverse();
      reversedWord += sb + " ";
    }
    return reversedWord;
  }
}

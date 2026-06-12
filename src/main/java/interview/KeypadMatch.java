package main.java.interview;

public class KeypadMatch {
  public WordMapProcessor processor;

  public KeypadMatch(WordMapProcessor processor) {
    this.processor = processor;
  }

  public String firstMatchingLetter(String input) {
    for (Character letter : input.toCharArray()) {
      int number = Integer.parseInt(letter.toString());
      if (number == 0 || number == 1) {
        return "";
      }
    }
    return processor.matchWord(input);
  }
}

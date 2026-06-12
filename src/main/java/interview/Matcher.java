package main.java.interview;

public class Matcher {
  public static void main(String[] args) {
    WordMapProcessor processor = new WordMapProcessor();
    processor.addWord("home");
    processor.addWord("rise");
    processor.addWord("exit");
    processor.addWord("list");
    processor.addWord("nine");
    processor.addWord("game");
    processor.addWord("cool");
    processor.addWord("calm");
    processor.addWord("tree");
    processor.addWord("face");

    KeypadMatch matcher = new KeypadMatch(processor);
    System.out.println(matcher.firstMatchingLetter("4663"));
    System.out.println(matcher.firstMatchingLetter("2120"));
    System.out.println(matcher.firstMatchingLetter("5555"));
    System.out.println(matcher.firstMatchingLetter("2665"));
  }
}

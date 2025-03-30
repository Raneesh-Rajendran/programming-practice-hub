package main.java.models;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

  public Map<Character, TrieNode> children;
  public Boolean endOfWord;

  public TrieNode() {
    this.children = new HashMap<Character, TrieNode>();
    endOfWord = false;
  }
}

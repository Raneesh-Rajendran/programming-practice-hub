package main.java.data_structures.tree.trie;

import main.java.models.TrieNode;

public class Trie {

  private final TrieNode root;

  public Trie() {
    this.root = new TrieNode();
  }

  public void insert(String word) {
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      TrieNode node = current.children.get(ch);
      if (node == null) {
        node = new TrieNode();
        current.children.put(ch, node);
      }
      current = node;
    }
    current.endOfWord = true;
  }

  public boolean search(String word) {
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      TrieNode node = current.children.get(ch);
      if (node == null) {
        System.err.println("Word not exist");
      }
      current = node;
    }
    if (current.endOfWord = true) System.out.println("Word exist");
    else System.err.println("Word not exist");
    return current.endOfWord;
  }

  public void delete(String word) {
    boolean wordExist = search(word);
    if (wordExist) delete(root, word, 0);
  }

  private boolean delete(TrieNode parentNode, String word, int index) {

    char ch = word.charAt(index);
    TrieNode currentNode = parentNode.children.get(ch);

    boolean canThisNodeBeDeleted;

    if (currentNode.children.size() > 1) {
      delete(currentNode, word, index + 1);
      return false;
    }

    if (index == word.length() - 1) {
      if (currentNode.children.size() >= 1) {
        currentNode.endOfWord = false;
        return false;
      } else {
        parentNode.children.remove(ch);
        return true;
      }
    }

    if (currentNode.endOfWord) {
      delete(currentNode, word, index + 1);
      return false;
    }

    canThisNodeBeDeleted = delete(currentNode, word, index + 1);
    if (canThisNodeBeDeleted) {
      parentNode.children.remove(ch);
      return true;
    } else return false;
  }
}

package main.java.data_structures.tree.bt.linkedlist;

import main.java.models.BinaryNode;
import main.java.models.Value;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {

  private BinaryNode root;

  public Tree() {
    root = null;
    System.out.println("tree created");
  }

  public void insertNode(Value value) {
    BinaryNode node = new BinaryNode(null, null, value, 0);
    if (root == null) {
      root = node;
      System.out.println("inserted");
      return;
    }
    Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
    queue.add(root);
    while (!queue.isEmpty()) {
      BinaryNode presentNode = queue.remove();
      if (presentNode.getLeft() == null) presentNode.setLeft(node);
      else if (presentNode.getRight() == null) presentNode.setRight(node);
      else {
        queue.add(presentNode.getLeft());
        queue.add(presentNode.getRight());
      }
    }
    System.out.println("inserted");
  }

  public void deleteNode(Value value) {
    if (root == null) {
      System.out.println("tree empty");
      return;
    }
    Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
    queue.add(root);
    while (!queue.isEmpty()) {
      BinaryNode presentNode = queue.remove();
      if (presentNode.getValue() == value) {
        presentNode.setValue(getDeepNode().getValue());
        deleteDeepNode();
        return;
      } else {
        if (presentNode.getLeft() != null) queue.add(presentNode.getLeft());
        if (presentNode.getRight() != null) queue.add(presentNode.getRight());
      }
    }
    System.out.println("node not found");
  }

  public BinaryNode getDeepNode() {
    Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
    queue.add(root);
    BinaryNode presentNode = null;
    while (!queue.isEmpty()) {
      presentNode = queue.remove();
      if (presentNode.getLeft() != null) queue.add(presentNode.getLeft());
      if (presentNode.getRight() != null) queue.add(presentNode.getRight());
    }
    return presentNode;
  }

  public void deleteDeepNode() {
    Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
    queue.add(root);
    BinaryNode previousNode, presentNode = null;
    while (!queue.isEmpty()) {
      previousNode = presentNode;
      presentNode = queue.remove();
      if (presentNode.getLeft() == null) previousNode.setRight(null);
      else if (presentNode.getRight() != null) presentNode.setLeft(null);
      else queue.add(presentNode.getLeft());
      queue.add(presentNode.getRight());
    }
    System.out.println("deleted");
  }

  public void searchNode(Value value) {
    if (root == null) {
      System.out.println("tree empty");
      return;
    }
    Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
    queue.add(root);
    while (!queue.isEmpty()) {
      BinaryNode presentNode = queue.remove();
      if (presentNode.getValue() == value) {
        System.out.println(presentNode.getValue());
        return;
      } else {
        if (presentNode.getLeft() != null) queue.add(presentNode.getLeft());
        if (presentNode.getRight() != null) queue.add(presentNode.getRight());
      }
    }
    System.out.println("node not found");
  }

  public void levelOrder() {
    if (root == null) {
      System.out.println("tree empty");
      return;
    }
    Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
    queue.add(root);
    while (!queue.isEmpty()) {
      BinaryNode presentNode = queue.remove();
      System.out.println(presentNode.getValue());
      if (presentNode.getLeft() != null) queue.add(presentNode.getLeft());
      if (presentNode.getRight() != null) queue.add(presentNode.getRight());
    }
  }

  public void preOrder(BinaryNode node) {
    if (root == null) return;
    System.out.println(node.getValue());
    preOrder(node.getLeft());
    preOrder(node.getRight());
  }

  public void inOrder(BinaryNode node) {
    if (root == null) return;
    inOrder(node.getLeft());
    System.out.println(node.getValue());
    inOrder(node.getRight());
  }

  public void postOrder(BinaryNode node) {
    if (root == null) return;
    postOrder(node.getLeft());
    postOrder(node.getRight());
    System.out.println(node.getValue());
  }

  public void deleteTree() {
    root = null;
    System.out.println("tree deleted");
  }
}

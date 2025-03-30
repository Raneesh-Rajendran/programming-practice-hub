package main.java.miscellaneous;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

class PBNode {
  PBNode left;
  PBNode right;
  int data;
  int height;
}

class BinaryTree {

  public void bottomView(PBNode node) {
    if (node == null) {
      return;
    }

    TreeMap<Integer, Integer> m = new TreeMap<Integer, Integer>();

    Queue<PBNode> q = new LinkedList<PBNode>();
    q.add(node);

    while (!q.isEmpty()) {
      PBNode temp = q.remove();
      int hd = temp.height;

      m.put(hd, temp.data);

      if (temp.left != null) {
        temp.left.height = hd - 1;
        q.add(temp.left);
      }

      if (temp.right != null) {
        temp.right.height = hd + 1;
        q.add(temp.right);
      }
    }
    System.out.println(m.values());
  }

  public void topView(PBNode node) {
    if (node == null) {
      return;
    }

    TreeMap<Integer, Integer> m = new TreeMap<Integer, Integer>();

    Queue<PBNode> q = new LinkedList<PBNode>();
    q.add(node);

    while (!q.isEmpty()) {
      PBNode temp = q.remove();
      int hd = temp.height;

      if (m.get(hd) == null) {
        m.put(hd, temp.data);
      }

      if (temp.left != null) {
        temp.left.height = hd - 1;
        q.add(temp.left);
      }

      if (temp.right != null) {
        temp.right.height = hd + 1;
        q.add(temp.right);
      }
    }
    System.out.println(m.values());
  }

  public PBNode createNewNode(int val) {
    PBNode newNode = new PBNode();
    newNode.data = val;
    newNode.left = null;
    newNode.right = null;
    return newNode;
  }
}

public class PrintBottomView {

  public static void main(String[] args) {

    BinaryTree a = new BinaryTree();

    PBNode root = a.createNewNode(2);
    root.left = a.createNewNode(7);
    root.right = a.createNewNode(5);
    root.left.left = a.createNewNode(2);
    // root.left.left.left = a.createNewNode(4);
    // root.left.left.right = a.createNewNode(5);
    root.left.right = a.createNewNode(6);
    root.left.right.left = a.createNewNode(5);
    root.left.right.right = a.createNewNode(11);
    root.right.right = a.createNewNode(9);
    root.right.right.left = a.createNewNode(4);
    // root.right.right.right = a.createNewNode(7);

    a.bottomView(root);
    a.topView(root);
  }
}

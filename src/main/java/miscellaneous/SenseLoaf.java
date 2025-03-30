package main.java.miscellaneous;

import main.java.models.Node;

public class SenseLoaf {

  public static void main(String[] args) {
    Node first = new Node(1);
    Node second = new Node(2);
    Node third = new Node(3);
    Node fourth = new Node(4);

    first.next = second;
    second.next = third;
    third.next = fourth;

    System.out.println("Before Reversing .... ");
    printLinkedlist(first);

    Node reversedList = reverseList(first);

    System.out.println("After Reversing .... ");
    printLinkedlist(reversedList);

    printPattern(9);
    String str = "baccad";
  }

  public static Node reverseList(Node head) {
    if (head == null) return null;
    if (head.next == null) return head;
    Node newNode = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return newNode;
  }

  public static void printLinkedlist(Node head) {
    Node temp = head;
    while (temp != null) {
      System.out.println(temp.getData());
      temp = temp.getNext();
    }
  }

  static void printPattern(int n) {
    // Variable initialization
    // Line count
    int line_no = 1;

    // Loop to print desired pattern
    int curr_star = 0;
    int number = 0;
    for (line_no = 1; line_no <= n && number < n; ) {
      // If current star count is less than
      // current line number
      if (curr_star < line_no) {
        System.out.print(++number + " ");
        curr_star++;
        continue;
      }

      // Else time to print a new line
      if (curr_star == line_no) {
        System.out.println();
        line_no++;
        curr_star = 0;
      }
    }
  }
}

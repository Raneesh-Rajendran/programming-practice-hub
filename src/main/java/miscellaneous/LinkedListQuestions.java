package main.java.miscellaneous;

import main.java.models.Node;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListQuestions {

  public static void main(String[] args) {

    Node first =
        new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6, new Node(7)))))));

    Node second = new Node(2, new Node(9, new Node(9, new Node(9))));

    /*System.out.println("Before Reversing .... ");
    printLinkedlist(first);
    Node reversedList = reverseList(first);
    System.out.println("\nAfter Reversing .... ");
    printLinkedlist(reversedList);
    System.out.println("\nAfter Reversing from A to B.... ");
    Node reversedListFromAtoB = reverseListAtoB(first, 4, 4);
    printLinkedlist(reversedListFromAtoB);*/

    System.out.println("Before Adding .... ");
    printLinkedlist(second);
    Node addedList = addNumberToLinkedList(second, 9);
    System.out.println("\nAfter Adding .... ");
    printLinkedlist(addedList);

    Queue<Integer> queue = new LinkedList();
    queue.add(2);
    queue.poll();
  }

  public static Node reverseList(Node head) {
    if (head == null) return null;
    if (head.next == null) return head;
    Node newNode = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return newNode;
  }

  public static Node reverseListAtoB(Node head, int a, int b) {
    if (a == b) return head;
    if (head.next.data == a) head.next = reverseListTillB(head.next, b);
    else reverseListAtoB(head.next, a, b);
    return head;
  }

  public static Node reverseListTillB(Node left, int b) {
    if (left.data == b) return left;
    Node right = reverseListTillB(left.next, b);
    Node rightNext = left.next.next;
    left.next.next = left;
    left.next = rightNext;
    return right;
  }

  public static Node addNumberToLinkedList(Node head, int number) {
    if (head.next.next == null) {
      int sum = head.next.data + number;
      int carry = (sum >= 10) ? 1 : 0;
      head.next.data = sum % 10;
      head.data = head.data + carry;
      return head;
    }
    Node newNode = addNumberToLinkedList(head.next, number);
    int carry = (newNode.data >= 10) ? 1 : 0;
    newNode.data = newNode.data % 10;
    head.data = head.data + carry;
    return head;
  }

  public static void printLinkedlist(Node head) {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
  }
}

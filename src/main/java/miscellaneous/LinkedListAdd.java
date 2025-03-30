package main.java.miscellaneous;

class Node<T> {
  T element;
  Node next;

  public Node(T element, Node node) {
    this.element = element;
    this.next = node;
  }
}

public class LinkedListAdd<T> {

  /*Adds element to the end of the linked list
  @param head the head of the list
  @param element the element to be added
  @return the new list head
  */
  public Node<T> add(Node<T> head, String element) {
    // insert you code here
    if (head == null) return new Node(element, null);

    if (head.next == null) {
      head.next = new Node(element, null);
      return head;
    }

    return add(head.next, element);
  }
}

package main.java.data_structures.linkedlist;

public class LinkedListIntersection {

  public static ListNode findIntersection(ListNode headA, ListNode headB) {
    int lenA = length(headA);
    int lenB = length(headB);

    // Equalize the start point of both lists
    while (lenA > lenB) {
      headA = headA.next;
      lenA--;
    }
    while (lenB > lenA) {
      headB = headB.next;
      lenB--;
    }

    // Find the intersection point
    while (headA != headB) {
      headA = headA.next;
      headB = headB.next;
    }

    return headA; // This will be null if there is no intersection
  }

  private static int length(ListNode head) {
    int length = 0;
    while (head != null) {
      length++;
      head = head.next;
    }
    return length;
  }

  public static void main(String[] args) {
    // Example usage
    ListNode headA = new ListNode(1);
    headA.next = new ListNode(3);
    headA.next.next = new ListNode(5);
    headA.next.next.next = new ListNode(7);
    headA.next.next.next.next = new ListNode(9);

    ListNode headB = new ListNode(2);
    headB.next = headA.next.next; // Intersect at node with data 5

    ListNode intersectionNode = findIntersection(headA, headB);
    if (intersectionNode != null) {
      System.out.println("Intersection at node with data: " + intersectionNode.data);
    } else {
      System.out.println("No intersection found");
    }
  }
}

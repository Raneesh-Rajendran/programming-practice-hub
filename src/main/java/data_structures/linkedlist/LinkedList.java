package main.java.data_structures.linkedlist;

import main.java.data_structures.linkedlist.linear.one.SingleLinkedList;
import main.java.data_structures.linkedlist.linear.two.DoubleLinkedList;
import main.java.models.Value;
import main.java.data_structures.linkedlist.circular.one.CircularSingleLinkedList;
import main.java.data_structures.linkedlist.circular.two.CircularDoubleLinkedList;

public class LinkedList<S> {
  public static void main(String[] args) {

    //        Single Linked List
    SingleLinkedList singleLinkedList = new SingleLinkedList();
    singleLinkedList.createLinkedList(new Value(5));
    singleLinkedList.insertNode(new Value(10), 2);
    singleLinkedList.insertNode(new Value("love"), 3);
    singleLinkedList.traverseList();
    singleLinkedList.deleteNode(new Value(10));
    singleLinkedList.deleteNode(new Value(5));
    singleLinkedList.deleteNode(new Value("love"));
    singleLinkedList.traverseList();
    singleLinkedList.createLinkedList(new Value(5));
    singleLinkedList.insertNode(new Value("Love"), 1);
    singleLinkedList.traverseList();

    //      Double Linked List
    DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
    doubleLinkedList.createLinkedList(new Value(5));
    doubleLinkedList.insertNode(new Value(10), 0);
    doubleLinkedList.insertNode(new Value("Love"), 1);
    doubleLinkedList.insertNode(new Value("You"), 2);
    doubleLinkedList.insertNode(new Value("We"), 1);
    doubleLinkedList.traverseList();
    doubleLinkedList.reverseTraverseList();
    doubleLinkedList.deleteNode(new Value(5));
    doubleLinkedList.traverseList();
    doubleLinkedList.reverseTraverseList();
    doubleLinkedList.deleteNode(new Value("love"));
    doubleLinkedList.traverseList();
    doubleLinkedList.reverseTraverseList();
    doubleLinkedList.deleteNode(new Value("you"));
    doubleLinkedList.traverseList();
    doubleLinkedList.reverseTraverseList();

    //        Circular Single Linked List
    CircularSingleLinkedList circularSingleLinkedList = new CircularSingleLinkedList();
    circularSingleLinkedList.createLinkedList(new Value(5));
    circularSingleLinkedList.insertNode(new Value(10), 2);
    circularSingleLinkedList.insertNode(new Value("love"), 3);
    circularSingleLinkedList.traverseList();
    circularSingleLinkedList.deleteNode(new Value(10));
    circularSingleLinkedList.deleteNode(new Value(5));
    circularSingleLinkedList.deleteNode(new Value("love"));
    circularSingleLinkedList.traverseList();
    circularSingleLinkedList.createLinkedList(new Value(5));
    circularSingleLinkedList.insertNode(new Value("Love"), 1);
    circularSingleLinkedList.traverseList();

    //        Circular Double Linked List
    CircularDoubleLinkedList circularDoubleLinkedList = new CircularDoubleLinkedList();
    circularDoubleLinkedList.createLinkedList(new Value(5));
    circularDoubleLinkedList.insertNode(new Value(10), 0);
    circularDoubleLinkedList.insertNode(new Value("Love"), 1);
    circularDoubleLinkedList.insertNode(new Value("You"), 2);
    circularDoubleLinkedList.insertNode(new Value("We"), 1);
    circularDoubleLinkedList.traverseList();
    circularDoubleLinkedList.reverseTraverseList();
    circularDoubleLinkedList.deleteNode(new Value(5));
    circularDoubleLinkedList.traverseList();
    circularDoubleLinkedList.reverseTraverseList();
    circularDoubleLinkedList.deleteNode(new Value("love"));
    circularDoubleLinkedList.traverseList();
    circularDoubleLinkedList.reverseTraverseList();
    circularDoubleLinkedList.deleteNode(new Value("you"));
    circularDoubleLinkedList.traverseList();
    circularDoubleLinkedList.reverseTraverseList();
  }
}

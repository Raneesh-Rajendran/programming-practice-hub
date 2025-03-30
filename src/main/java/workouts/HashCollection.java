package main.java.workouts;

import java.util.*;

public class HashCollection {
  public static void main(String[] args) {
    Set<Integer> hashSet = new TreeSet<Integer>();
    // Populating the HashSet
    hashSet.add(1124);
    hashSet.add(3654);
    hashSet.add(7854);
    hashSet.add(9945);
    System.out.println(hashSet);
    // Adding null elements
    //        hashSet.add(null);
    hashSet.add(9946);
    //        hashSet.add(null);
    hashSet.add(9945);
    //        hashSet.add(null);
    System.out.println(hashSet);

    Hashtable<Integer, String> ht1 = new Hashtable<>();

    // Initialization of a Hashtable
    // using Generics
    Hashtable<Integer, String> ht2 = new Hashtable<>();

    // Inserting the Elements
    // using put() method
    ht1.put(1, "one");
    ht1.put(2, "two");
    ht1.put(3, "three");

    ht2.put(1, "four");
    ht2.put(5, "five");
    ht2.put(6, "six");

    // Print mappings to the console
    System.out.println("Mappings of ht1 : " + ht1);
    System.out.println("Mappings of ht2 : " + ht2);

    Queue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());

    // Adding items to the pQueue using add()
    pQueue.add(10);
    pQueue.add(20);
    pQueue.add(15);
    pQueue.add(25);
    pQueue.add(75);

    // Printing the top element of PriorityQueue
    System.out.println(pQueue.poll());

    // Printing the top element and removing it
    // from the PriorityQueue container
    System.out.println(pQueue.poll());

    // Printing the top element again
    System.out.println(pQueue.poll());
    System.out.println(pQueue.poll());
    System.out.println(pQueue.poll());
  }
}

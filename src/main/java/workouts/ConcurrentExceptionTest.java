package main.java.workouts;

import java.util.*;

public class ConcurrentExceptionTest {

  public static void main(String[] args) {

    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(1, 1);
    map.put(2, 2);
    map.put(3, 3);

    Iterator<Integer> it = map.keySet().iterator();
    while (it.hasNext()) {
      Integer key = it.next();
      System.out.println("Map Value:" + map.get(key));
      if (key.equals(2)) {
        map.put(1, 4);
      }
    }

    List<Integer> list = new ArrayList<>();

    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);

    Set<Integer> array = new HashSet<>();
    System.out.println(array.add(10));
    System.out.println(array.add(20));
    System.out.println(array.add(20));

    Map<Integer, String> table = new HashMap<>();

    table.put(3, "work");
    table.put(2, "Hello");
    table.put(6, "work");

    Iterator iterator2 = table.entrySet().iterator();

    while (iterator2.hasNext()) {
      System.out.println(iterator2.next());
      iterator2.remove();
    }

    Queue<String> queue = new LinkedList<>();

    queue.add("G");
    queue.add("H");
    queue.add("A");

    Set<String> set = new TreeSet<>();

    set.add("G");
    set.add("H");
    set.add("A");
    set.add("B");
    set.add("Z");
    set.add("L");

    Iterator<String> iterator = set.iterator();

    while (iterator.hasNext()) {
      System.out.println(iterator.next());
      iterator.remove();
    }

    Iterator<Integer> iterator1 = list.listIterator();
    while (iterator1.hasNext()) {
      System.out.println(iterator1.next());
      iterator1.remove();
    }
    System.out.println(list);
  }
}

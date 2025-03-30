package main.java.miscellaneous;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonExecutor {

  public static void main(String[] args) {

    SingletonWithLock oneObject = SingletonWithLock.getSingleton();

    int[] array = new int[] {7, 5, 4, 3, 2, 1};

    int smallest = array[0], largest = 0, largestIdx = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] < smallest && largestIdx > i) {
        smallest = array[i];
      }
      if (array[i] > largest) {
        largest = array[i];
        largestIdx = i;
      }
    }

    System.out.println(largest - smallest);

    ExecutorService service = Executors.newFixedThreadPool(10);
    for (int i = 0; i < 10; i++) {
      Runnable task = () -> System.out.println(SingletonWithLock.getSingleton());
      service.execute(task);
    }
    service.shutdown();
  }
}

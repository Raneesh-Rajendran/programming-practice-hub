package main.java.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class CallableExample {
  public static void main(String[] args) {
    ExecutorService executor = Executors.newFixedThreadPool(20);

    List<Future<Integer>> resultList = new ArrayList<>();

    Random random = new Random();

    for (int i = 0; i < 20; i++) {
      Integer number = random.nextInt(10);
      FactorialCalculator calculator = new FactorialCalculator(number);
      Future<Integer> result = executor.submit(calculator);
      resultList.add(result);
    }

    for (Future<Integer> future : resultList) {
      try {
        System.out.println(
            "Future result is - " + " - " + future.get() + "; And Task done is " + future.isDone());
      } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
      }
    }
    // shut down the executor service now
    executor.shutdown();
  }
}

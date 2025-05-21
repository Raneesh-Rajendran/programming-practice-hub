package main.java.multithreading.print_numbers;

public class Tester {
  public static void main(String[] args) {
    NumberGenerator generator = new NumberGenerator(3, 11);

    Thread thread1 = new Thread(new SequenceGenerator(generator, 1));
    Thread thread2 = new Thread(new SequenceGenerator(generator, 2));
    Thread thread3 = new Thread(new SequenceGenerator(generator, 0));

    thread1.start();
    thread2.start();
    thread3.start();
  }
}

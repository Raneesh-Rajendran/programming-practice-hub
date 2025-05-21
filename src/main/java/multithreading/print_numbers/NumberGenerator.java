package main.java.multithreading.print_numbers;

public class NumberGenerator {
  private final int noOfThreads;
  private final int totalNumberInSeq;
  private int currentNumber = 1;

  public NumberGenerator(int noOfThreads, int totalNumberInSeq) {
    this.noOfThreads = noOfThreads;
    this.totalNumberInSeq = totalNumberInSeq;
  }

  public void printNumber(int index) {
    synchronized (this){
      while (currentNumber < totalNumberInSeq) {
        while (currentNumber % noOfThreads != index) {
          try {
            wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        System.out.println(currentNumber++);
        notifyAll();
      }
    }
  }
}

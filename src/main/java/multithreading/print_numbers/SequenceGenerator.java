package main.java.multithreading.print_numbers;

public class SequenceGenerator implements Runnable {
  private final NumberGenerator numberGenerator;
  private final int index;

  public SequenceGenerator(NumberGenerator numberGenerator, int index) {
    this.numberGenerator = numberGenerator;
    this.index = index;
  }

  @Override
  public void run() {
    numberGenerator.printNumber(this.index);
  }
}

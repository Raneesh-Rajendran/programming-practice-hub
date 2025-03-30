package main.java.multithreading.synchronization;

public class MultithreadMain {

  public static void main(String[] args) throws InterruptedException {

    Boolean flag = true;
    Thread t1 = new Thread(new Individual(flag));
    Thread t2 = new Thread(new Dependent(flag));

    if (flag) {
      t1.start();
      t2.start();
    }

    if (!flag) {
      t2.start();
      t1.start();
    }

    t1.join();
    t2.join();
  }
}

package main.java.multithreading.odd_even;

public class SynchronizedRunner {
  private static final Object lock = new Object();
  static volatile int counter = 1;
  int N;

  SynchronizedRunner(int N) {
    this.N = N;
  }

  public static void main(String[] args) {
    SynchronizedRunner runner1 = new SynchronizedRunner(10);
    SynchronizedRunner runner2 = new SynchronizedRunner(10);

    Thread t1 = new Thread(runner1::printOddNumbers);
    Thread t2 = new Thread(runner2::printEvenNumbers);

    t1.start();
    t2.start();
  }

  public void printOddNumbers() {
    while (counter <= N) {
      synchronized (lock) {
        if (counter % 2 == 1) {
          System.out.println(Thread.currentThread().getName() + " : " + counter++);
          lock.notifyAll();
        } else {
          try {
            if (counter > N) break;
            lock.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }

  public void printEvenNumbers() {
    while (counter <= N) {
      synchronized (lock) {
        if (counter % 2 == 0) {
          System.out.println(Thread.currentThread().getName() + " : " + counter++);
          lock.notifyAll();
        } else {
          try {
            if (counter > N) break;
            lock.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }
}

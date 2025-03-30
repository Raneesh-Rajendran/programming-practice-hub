package main.java.miscellaneous;

public class MainThread {
  static int N = 10;
  int counter = 1;

  public static void main(String[] args) {

    MainThread mainThread = new MainThread();

    Thread t1 =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                mainThread.printEvenNumber();
              }
            });
    Thread t2 =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                mainThread.printOddNumber();
              }
            });
    t1.start();
    t2.start();
  }

  public void printOddNumber() {
    synchronized (this) {
      while (counter < N) {
        while (counter % 2 == 0) {
          try {
            wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        System.out.print(counter + " ");
        counter++;
        notify();
      }
    }
  }

  public void printEvenNumber() {
    synchronized (this) {
      while (counter < N) {
        while (counter % 2 == 1) {
          try {
            wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        System.out.print(counter + " ");
        counter++;
        notify();
      }
    }
  }
}

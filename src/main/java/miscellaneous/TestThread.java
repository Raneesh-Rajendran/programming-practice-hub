package main.java.miscellaneous;

class SampleDemo implements Runnable {

  private Thread t;
  private final String threadName;

  public SampleDemo(String threadName) {
    this.threadName = threadName;
  }

  @Override
  public void run() {
    while (true) {
      System.out.print(threadName);
    }
  }

  public void start() {
    if (t == null) {
      t = new Thread(this, threadName);
      t.start();
    }
  }
}

class TestThread {
  public static void main(String[] args) {
    SampleDemo A = new SampleDemo("A");
    SampleDemo B = new SampleDemo("B");

    B.start();
    A.start();
  }
}

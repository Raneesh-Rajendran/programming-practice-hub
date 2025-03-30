package main.java.multithreading.odd_even;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockRunner {
  private final ReentrantLock lock = new ReentrantLock();
  int counter = 1;
  int N;
  Condition odd = lock.newCondition();
  Condition even = lock.newCondition();

  ReentrantLockRunner(int N) {
    this.N = N;
  }

  public static void main(String[] args) {
    ReentrantLockRunner runner = new ReentrantLockRunner(20);

    Thread t1 = new Thread(runner::printOddNumbers);
    Thread t2 = new Thread(runner::printEvenNumbers);

    t1.start();
    t2.start();
  }

  public void printOddNumbers() {
    while (true) {
      lock.lock();
      try {
        if (counter <= N && counter % 2 == 0) {
          odd.await();
        }
        if (counter > N) {
          break;
        }
        System.out.println(Thread.currentThread().getName() + " : " + counter++);
        even.signal();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      } finally {
        lock.unlock();
      }
    }
  }

  public void printEvenNumbers() {
    while (true) {
      lock.lock();
      try {
        if (counter <= N && counter % 2 == 1) {
          even.await();
        }
        if (counter > N) {
          break;
        }
        System.out.println(Thread.currentThread().getName() + " : " + counter++);
        odd.signal();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      } finally {
        lock.unlock();
      }
    }
  }
}

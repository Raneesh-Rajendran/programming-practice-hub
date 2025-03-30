package main.java.multithreading;

import main.java.models.Employee;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class CollectionMultithread {

  static List<Employee> list = new CopyOnWriteArrayList<>();

  static ReentrantLock lock = new ReentrantLock();

  public static void main(String[] args) throws InterruptedException {

    CollectionMultithread multithread = new CollectionMultithread();
    list.add(new Employee(1L, "Raneesh", "raneesh@gmail.com", 1237L));
    list.add(new Employee(2L, "Julie", "julie@gmail.com", 1453L));
    list.add(new Employee(3L, "Karen", "karen@gmail.com", 1263L));
    list.add(new Employee(4L, "David", "david@gmail.com", 1723L));
    list.add(new Employee(5L, "Dennis", "dennis@gmail.com", 1823L));

    ExecutorService executor = Executors.newFixedThreadPool(2);

    Runnable thread1 =
        () -> {
          readAndDelete("t1", 1L);
        };

    Runnable thread2 =
        () -> {
          readAndDelete("t2", 3L);
        };

    //        executor.execute(thread1);
    //        executor.execute(thread2);
    //        executor.shutdown();

    Data data = new Data();
    Thread sender = new Thread(new Sender(data));
    Thread receiver = new Thread(new Receiver(data));

    sender.start();
    receiver.start();

    sender.join();
    receiver.join();

    System.out.println("Main ended");
  }

  public static void readAndDelete(String threadName, Long employeeId) {
    for (Employee employee : list) {
      if (employee.getId() == employeeId) {
        lock.lock();
        try {
          list.remove(employee);
          System.out.println(threadName + " Removed " + employee);
        } finally {
          lock.unlock();
        }
      } else System.out.println(threadName + employee);
    }
  }
}

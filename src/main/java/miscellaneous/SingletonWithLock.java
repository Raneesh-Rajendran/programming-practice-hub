package main.java.miscellaneous;

public class SingletonWithLock {

  static SingletonWithLock singleton;
  private static final Object lock = new Object();

  private SingletonWithLock() {}

  public static SingletonWithLock getSingleton() {
    if (singleton == null) {
      synchronized (lock) {
        singleton = new SingletonWithLock();
      }
    }
    return singleton;
  }
}

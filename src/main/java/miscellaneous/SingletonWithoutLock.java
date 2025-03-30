package main.java.miscellaneous;

public class SingletonWithoutLock {

  private static final SingletonWithoutLock instance = new SingletonWithoutLock();

  protected SingletonWithoutLock() {}

  public static SingletonWithoutLock getInstance() {
    return instance;
  }
}

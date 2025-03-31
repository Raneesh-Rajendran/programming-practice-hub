package main.java.oop_basics.abstraction;

public interface InterfaceExample {

  static void staticSound() {
    String str = "static";
    System.out.println(str);
  }

  default void sound() {
    String str = "dafault";
    System.out.println(str);
  }

  private void privateSound() {
    String str = "private";
    System.out.println(str);
  }

    void staticDefautSound();
}

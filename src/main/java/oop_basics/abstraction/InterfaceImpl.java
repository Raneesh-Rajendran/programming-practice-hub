package main.java.oop_basics.abstraction;

public class InterfaceImpl implements InterfaceExample {

  static void staticSound() {
    String str = "Impl static";
    System.out.println(str);
  }

  public void sound() {
    String str = "Impl default";
    System.out.println(str);
  }

  private void privateSound() {
    String str = "private";
    System.out.println(str);

    staticSound();
  }

    @Override
  public void staticDefautSound() {
    String str = "Impl static default";
    System.out.println(str);
  }
}

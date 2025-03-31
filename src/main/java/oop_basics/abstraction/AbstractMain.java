package main.java.oop_basics.abstraction;

public class AbstractMain {

  public static void main(String[] args) {
    Pig pig = new Pig();
    pig.sleep();
    pig.animalSound();

    InterfaceImpl impl = new InterfaceImpl();
    impl.sound();
    InterfaceImpl.staticSound();
    InterfaceExample.staticSound();
  }
}

package main.java.workouts;

public class Inheritance {

  public static void main(String[] args) {
    A a = new B();
    a.show1();
    a.show2();
    ((B) a).show3();
  }
}

class A {
  public void show1() {
    System.out.println("Parent class show1");
  }

  public static void show2() {
    System.out.println("Parent class show2");
  }
}

class B extends A {

  public void show1() {
    System.out.println("Child class show1");
  }

  public static void show2() {
    System.out.println("Child class show2");
  }

  public void show3() {
    System.out.println("Child class show3");
  }
}

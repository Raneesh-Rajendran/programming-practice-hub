package main.java.oop_basics;

class Parent {
  public void method() {
    System.out.println("Parent");
  }
}

class Child extends Parent {
  public void method() {
    System.out.println("Child");
  }
}

public class Inheritance {
  public static void main(String[] args) {
    Parent parent = new Child();
    parent.method();
  }
}

package main.java.miscellaneous;

class A {

  public A() {}

  public A(int i) {
    System.out.println(i);
  }
}

public class Inheritance {
  static A s1 = new A(1);
  static A s2 = new A(4);
  A a = new A(2);

  public static void main(String[] args) {
    Inheritance b = new Inheritance();
    A a = new A(3);
  }
}

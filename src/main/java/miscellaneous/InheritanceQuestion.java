package main.java.miscellaneous;

public class InheritanceQuestion {

  public static void main(String[] args) {
    //        Parent p = new Child();
    //        Child c = (Child) p;
    //        p.dP();
    //        ((Child) p).dC();
    //        c.dP();
    //        c.dC();
    //         ambigious method call - compilation error
    //         p.m1(null);
    //        Parent child = new Child();

    Parent p = new Parent();
  }
}

class Parent {

  Parent() {
    System.out.println("I am Parent");
  }

  public void dP() {
    System.out.println("Parent method");
  }

  void m1(Object o) {
    System.out.println("o");
  }

  void m1(String s) {
    System.out.println("s");
  }

  void m1(Integer i) {
    System.out.println("i");
  }
}

class Child extends Parent {

  Child() {
    System.out.println("I am Child");
  }

  public void dC() {
    System.out.println("Child method");
  }
}

class GrandParent {

  GrandParent() {
    System.out.println("I am GrandParent");
  }
}

package main.java.miscellaneous;

public class Explore {

  private final String something = "google";
  private Parent parent;

  public static void main(String[] args) {
    new Explore().division(4, 5);
    Explore explore = new Explore();
    Explore.Parent parent = explore.new Parent();
    System.out.println(parent.runSomething());
  }

  public int division(int a, int b) {
    int result = a / b;
    return result;
  }

  public double division(int a) {
    double result = a;
    return result;
  }

  private static class ParentReturnType {}

  private class Parent {

    public String runSomething() {
      return something;
    }

    public ParentReturnType run() {
      return new ParentReturnType();
    }
  }

  private class Child extends Parent {
    @Override
    public ChildReturnType run() {
      return new ChildReturnType();
    }
  }

  private class ChildReturnType extends ParentReturnType {}
}

package main.java.miscellaneous;

class XXX {
  public void m() throws Exception {
    System.out.println("XXX Exception");
    throw new Exception("Workable");
  }
}

class YYY extends XXX {
  @Override
  public void m() {
    System.out.println("YYY Exception");
  }
}

class MainExceptionInheritance {
  public static void main(String[] args) throws Exception {
    XXX object = new YYY();
    object.m();

    One oneObj = new One();
    // oneObj.hello(null);
  }
}

class One {
  public void hello(Object obj) {
    System.out.println("Hello Object");
  }

  public void hello(String str) {
    System.out.println("Hello String");
  }

  public void hello(StringBuffer str) {
    System.out.println("Hello String");
  }
}

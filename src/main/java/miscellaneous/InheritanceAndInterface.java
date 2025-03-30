package main.java.miscellaneous;

interface ACommon {
  default void displayInterface() {
    System.out.println("ACommon");
  }
}

interface BCommon {
  default void displayInterface() {
    System.out.println("BCommon");
  }
}

public class InheritanceAndInterface {
  public static void main(String[] args) {
    //        AInhertiance a = new CInhertiance();
    //        a.displayInheritance();
    //
    //        BCommon b = new CInhertiance();
    //        b.displayInterface();
    //
    //        CInhertiance c = new CInhertiance();
    //        c.displayInheritance();
    //        c.displayInterface();
    //
    //        AInhertiance.staticMethod();

    ClientInterface ci = new ClientInterface();
    ci.displayInterface();
  }
}

class AInhertiance {
  static void staticMethod() {}

  void displayInheritance() {
    System.out.println("displayInheritance");
  }
}

class CInhertiance extends AInhertiance implements BCommon {

  @Override
  public void displayInterface() {
    System.out.println("displayInterface");
  }
}

class ClientInterface implements ACommon, BCommon {

  @Override
  public void displayInterface() {
    ACommon.super.displayInterface();
  }
}

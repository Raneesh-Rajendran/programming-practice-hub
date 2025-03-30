package main.java.workouts;

import java.io.*;

class TrasientTest implements Serializable {
  // Use of transient has no impact here
  static int l = 40;
  final transient int m = 50;
  // Normal variables
  int i = 10, j = 20;
  // Transient variables
  transient int k = 30;

  public static void main(String[] args) throws Exception {
    TrasientTest input = new TrasientTest();

    // serialization
    FileOutputStream fos = new FileOutputStream("abc.txt");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(input);

    // de-serialization
    FileInputStream fis = new FileInputStream("abc.txt");
    ObjectInputStream ois = new ObjectInputStream(fis);
    TrasientTest output = (TrasientTest) ois.readObject();
    System.out.println("i = " + output.i);
    System.out.println("j = " + output.j);
    System.out.println("k = " + output.k);
    System.out.println("l = " + l);
    System.out.println("m = " + output.m);
  }
}

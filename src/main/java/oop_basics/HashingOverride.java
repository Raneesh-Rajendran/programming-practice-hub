package main.java.oop_basics;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashingOverride {
  static class Person {
    String name;
    int age;

    public Person(String name, int age) {
      this.name = name;
      this.age = age;
    }

    @Override
    public int hashCode() {
      return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null || getClass() != obj.getClass()) return false;

      Person person = (Person) obj;
      return age == person.age && name.equals(person.name);
    }
  }

  public static void main(String[] args) {
    Person p1 = new Person("John", 30);
    Person p2 = new Person("John", 30);
    System.out.println(p1.equals(p2)); // false, unless overridden

    Map<Person, String> map = new HashMap<>();
    map.put(new Person("John", 30), "Developer");
    System.out.println(map.get(new Person("John", 30))); // null, unless overridden
  }
}

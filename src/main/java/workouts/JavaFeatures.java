package main.java.workouts;

import static java.util.Map.Entry.comparingByKey;
import static java.util.stream.Collectors.toMap;

import java.util.*;
import main.java.models.Employee;

public class JavaFeatures {

  public static void main(String[] args) {
    JavaFeatures test = new JavaFeatures();
    Moveable move = test.new MovableImplementation();
    StreamsImplementation stream = test.new StreamsImplementation();
    move.move();
    stream.streamTestOut();
    // stream.disp(100, 20d);
  }

  public interface Moveable {
    default void move() {
      System.out.println("I am moving");
    }
  }

  public class MovableImplementation implements Moveable {}

  public class StreamsImplementation {

    public void streamTestOut() {
      List<Employee> employeeList = new ArrayList<>();

      employeeList.add(new Employee(1L, "Raneesh", "abc@gmail.com", 123L));
      employeeList.add(new Employee(21L, "Raneesh", "abc@gmail.com", 123L));
      employeeList.add(new Employee(13L, "Raneesh", "abc@gmail.com", 123L));

      System.out.println(employeeList);
      sortBasedonTwoFields(employeeList);
    }

    public void sortBasedonTwoFields(List<Employee> employeeList) {

      employeeList.sort(Comparator.comparing(Employee::getId).thenComparing(Employee::getEmail));
      System.out.println(employeeList);

      Map<Long, Employee> employeeMap =
          employeeList.stream().collect(toMap(Employee::getId, e -> e));

      employeeMap.entrySet().stream().sorted(comparingByKey()).forEach(System.out::println);

      Map<Long, Employee> sortedMap = new HashMap<>();
      employeeMap.entrySet().stream()
          .sorted(Map.Entry.comparingByKey())
          .forEach(x -> sortedMap.put(x.getKey(), x.getValue()));
      sortedMap.entrySet().forEach(System.out::println);
    }

    void disp(int a, float b) {
      System.out.println("Method A");
    }

    void disp(int a, double b) {
      System.out.println("Method B");
    }
  }
}

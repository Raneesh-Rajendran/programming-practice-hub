package main.java.miscellaneous;

import main.java.models.Employee;

import java.util.*;

import static java.util.Map.Entry.comparingByKey;
import static java.util.stream.Collectors.toMap;

public class StreamSortByTwoFields {

  public static void main(String[] args) {
    List<Employee> employeeList = new ArrayList<>();

    employeeList.add(new Employee(1L, "Raneesh", "abc@gmail.com", 123L));
    employeeList.add(new Employee(21L, "Raneesh", "abc@gmail.com", 123L));
    employeeList.add(new Employee(13L, "Raneesh", "abc@gmail.com", 123L));

    System.out.println(employeeList);
    sortBasedonTwoFields(employeeList);
  }

  public static void sortBasedonTwoFields(List<Employee> employeeList) {

    employeeList.sort(
        Comparator.comparing(Employee::getId)
            .thenComparing(Comparator.comparing(Employee::getEmail)));
    System.out.println(employeeList);

    Map<Long, Employee> employeeMap =
        employeeList.stream()
            .collect(
                toMap(
                    Employee::getId,
                    employee -> {
                      return employee;
                    }));
    employeeMap.entrySet().stream().sorted(comparingByKey()).forEach(System.out::println);

    // Map<Long, Employee> sortedByKey = employeeMap.entrySet().stream()
    //    .sorted(Map.Entry.<Long, Employee>comparingByKey())
    //   .collect(Collectors.toMap(Map.Entry.comparingByKey()));
    // sortedByKey.entrySet().stream().forEach(System.out::println);
  }
}

package main.java.workouts;

import static main.java.oop_basics.PredicatesClass.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import main.java.models.Employee;

public class PredicateTest {

  public static void main(String[] args) {

    Predicate<String> emailFilter = Pattern.compile("^(.+)@example.com$").asPredicate();

    // Input list
    List<String> emails =
        Arrays.asList("alex@example.com", "bob@yahoo.com", "cat@google.com", "david@example.com");

    // Apply predicate filter
    List<String> desiredEmails =
        emails.stream().filter(emailFilter).collect(Collectors.<String>toList());

    // Now perform desired operation
    desiredEmails.forEach(System.out::println);

    Employee e1 = new Employee(1L, 23, "M", "Rick", "Beethovan");
    Employee e2 = new Employee(2L, 13, "F", "Martina", "Hengis");
    Employee e3 = new Employee(3L, 43, "M", "Ricky", "Martin");
    Employee e4 = new Employee(4L, 26, "M", "Jon", "Lowman");
    Employee e5 = new Employee(5L, 19, "F", "Cristine", "Maria");
    Employee e6 = new Employee(6L, 15, "M", "David", "Feezor");
    Employee e7 = new Employee(7L, 68, "F", "Melissa", "Roy");
    Employee e8 = new Employee(8L, 79, "M", "Alex", "Gussin");
    Employee e9 = new Employee(9L, 15, "F", "Neetu", "Singh");
    Employee e10 = new Employee(10L, 45, "M", "Naveen", "Jain");

    List<Employee> employees = new ArrayList<Employee>();
    employees.addAll(Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10));

    System.out.println(filterEmployees(employees, isAdultMale()));

    System.out.println(filterEmployees(employees, isAdultFemale()));

    System.out.println(filterEmployees(employees, isAgeMoreThan(35)));

    // Employees other than above collection of "isAgeMoreThan(35)"
    // can be get using negate()
    System.out.println(filterEmployees(employees, isAgeMoreThan(35).negate()));
  }
}

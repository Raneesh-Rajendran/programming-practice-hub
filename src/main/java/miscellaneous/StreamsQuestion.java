package main.java.miscellaneous;

/*
Given a list of Employee objects, find the employee with the highest salary and
the employee with the lowest salary  using Java 8 API.
class Employee{
    Integer empId;
    String empName;
    String department; //( “Account“,”IT”,”HR”,”Admin”)
    Integer salary;
}
 */

import java.util.*;
import java.util.stream.Collectors;

public class StreamsQuestion {

  public static void main(String[] args) {
    List<Employee> employeeList =
        Arrays.asList(
            new Employee("IT", "John", 50000),
            new Employee("IT", "Alice", 55000),
            new Employee("HR", "Bob", 45000),
            new Employee("HR", "Carol", 48000));

    Optional<Employee> lowestEmployee =
        employeeList.stream().min(Comparator.comparing(Employee::getSalary));
    Optional<Employee> highestEmployee =
        employeeList.stream().max(Comparator.comparing(Employee::getSalary));

    Map<String, Optional<Employee>> departmentMinSalaryEmployee =
        employeeList.stream()
            .collect(
                Collectors.groupingBy(
                    Employee::getDepartment,
                    Collectors.minBy(Comparator.comparingInt(Employee::getSalary))));

    int[] array = new int[] {0, 7, 4, 0, 0, 8, 3, 0, 0, 0, 5, 6};
    System.out.println(Arrays.toString(moveZerosToBack(array)));
  }

  public static int[] moveZerosToBack(int[] array) {
    int i = 0, j = 0, n = array.length;

    while (i < n) {
      if (array[i] != 0) {
        swap(array, i, j);
        j++;
      }
      i++;
    }
    return array;
  }

  /*
  Suppose I have an array of [0,7,4,0,0,8,3,0,0,0,5,6] I have to take all the zeroes to last positions after
   numbers without modifying their order.
  So output array should be [7,4,8,3,5,6,0,0,0,0,0];
   */

  public static void swap(int[] array, int idx1, int idx2) {
    int temp = array[idx2];
    array[idx2] = array[idx1];
    array[idx1] = temp;
  }

  static class Employee {
    String empName;
    String department; // ( “Account“,”IT”,”HR”,”Admin”)
    Integer salary;

    public Employee(String empName, String department, Integer salary) {
      this.empName = empName;
      this.department = department;
      this.salary = salary;
    }

    public String getEmpName() {
      return empName;
    }

    public void setEmpName(String empName) {
      this.empName = empName;
    }

    public String getDepartment() {
      return department;
    }

    public void setDepartment(String department) {
      this.department = department;
    }

    public Integer getSalary() {
      return salary;
    }

    public void setSalary(Integer salary) {
      this.salary = salary;
    }
  }
}

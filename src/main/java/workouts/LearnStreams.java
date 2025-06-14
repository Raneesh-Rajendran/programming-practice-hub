package main.java.workouts;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import main.java.models.Employee;

public class LearnStreams {

  public static void main(String[] args) {

    ArrayList<Employee> list = new ArrayList<>();

    list.add(
        new Employee(
            1L, "Karen Oltmann", "karen.oltmann@gmail.com", 7123L, 55, "F", "Karen", "Oltmann"));
    list.add(
        new Employee(
            2L, "David Kempton", "david.kempton@gmail.com", 3123L, 60, "M", "David", "Kempton"));
    list.add(
        new Employee(
            3L, "Dennis McGowan", "dennis.mcgowan@gmail.com", 6123L, 65, "M", "Dennis", "McGowan"));

    ArrayList<Employee> list1 = new ArrayList<>();
    list1.add(
        new Employee(
            4L, "Sean McDermott", "sean.mcdermott@gmail.com", 1123L, 40, "M", "Sean", "McDermott"));
    list1.add(
        new Employee(
            5L, "Hannah Olivia", "hannah.olivia@gmail.com", 1723L, 28, "F", "Hannah", "Olivia"));
    list1.add(
        new Employee(
            6L, "Naresh Butani", "naresh.butani@gmail.com", 4123L, 45, "M", "Naresh", "Butani"));

    ArrayList<Employee> list2 = new ArrayList<>();
    list2.add(
        new Employee(
            7L,
            "Victoria Tanner",
            "victoria.tanner@gmail.com",
            9123L,
            54,
            "F",
            "Victoria",
            "Tanner"));
    list2.add(
        new Employee(
            8L, "Vikram Jammula", "vikram.jammula@gmail.com", 1283L, 33, "M", "Vikram", "Jammula"));
    list2.add(
        new Employee(
            9L, "Mark Russito", "mark.russito@gmail.com", 1273L, 40, "M", "Mark", "Russito"));

    Map<Integer, List<Employee>> map = new HashMap<>();
    map.put(1, list);
    map.put(2, list1);
    map.put(3, list2);

    map.entrySet().stream()
        .flatMap(data -> data.getValue().stream())
        .filter(data -> data.getId() == 6)
        .forEach(System.out::println);

    List<Employee> employees =
        map.entrySet().stream()
            .filter(entry -> entry.getKey() == 2 || entry.getKey() == 1)
            .flatMap(data -> data.getValue().stream())
            .filter(data -> data.getId() > 2L && data.getId() < 6L)
            .toList();

    employees.forEach(System.out::println);

    Integer ageTotal =
        employees.stream()
            .reduce(0, (partialResult, data) -> partialResult + data.getAge(), Integer::sum);

    System.out.println(ageTotal);

    Comparator<Employee> nameSorter = (a, b) -> a.getName().compareToIgnoreCase(b.getName());
    list.sort(nameSorter);
    list.sort(
        Comparator.comparing(Employee::getAge, Comparator.reverseOrder())
            .thenComparing(Employee::getEmail, Comparator.reverseOrder()));
    list.sort(Comparator.comparing(Employee::getId).thenComparing(Employee::getName));

    Map<Integer, List<Employee>> sortedMap = new LinkedHashMap<>();
    map.entrySet().stream()
        .sorted(Map.Entry.comparingByKey())
        .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

    sortedMap.entrySet().forEach(System.out::println);

    List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    Map<Boolean, List<Integer>> resultMap =
        input.stream().collect(Collectors.partitioningBy(s -> s % 2 == 0));
    System.out.println(resultMap);

    List<Integer> resultList =
        list.stream().map(Employee::getAge).filter(age -> age % 2 == 1).toList();
    resultList.forEach(System.out::println);

    // Calling generic method with Integer argument
    genericDisplay(11);

    // Calling generic method with String argument
    genericDisplay("GeeksForGeeks");

    // Calling generic method with double argument
    genericDisplay(1.0);

    List<Employee> mergedList = Stream.of(list, list1, list2).flatMap(Collection::stream).toList();

    Map<Integer, Employee> employeeMapByAge =
        mergedList.stream()
            .collect(
                Collectors.toMap(
                    Employee::getAge, Function.identity(), (existing, replacement) -> existing));
    employeeMapByAge.entrySet().forEach(System.out::println);

    Map<Integer, Long> employeeCountByAge =
        mergedList.stream()
            .collect(
                Collectors.groupingBy(Employee::getAge, LinkedHashMap::new, Collectors.counting()));
    employeeCountByAge.entrySet().forEach(System.out::println);

    Map<String, Long> employeeNameByManager =
        mergedList.stream()
            .sorted((a, b) -> a.getName().compareToIgnoreCase(b.getName()))
            .collect(
                Collectors.toMap(
                    Employee::getName, Employee::getManagerId, (a, b) -> b, LinkedHashMap::new));
    employeeNameByManager.entrySet().forEach(System.out::println);

    Map<Long, Double> managerWiseAvgAge =
        mergedList.stream()
            .collect(
                Collectors.groupingBy(
                    Employee::getManagerId, Collectors.averagingInt(Employee::getAge)));
    managerWiseAvgAge.entrySet().forEach(System.out::println);

    managerWiseAvgAge.putIfAbsent(1283L, 101.0);
    System.out.println(managerWiseAvgAge.computeIfAbsent(1284L, e -> 102.0));

    managerWiseAvgAge.merge(1283L, 101.0, Double::max);
    managerWiseAvgAge.entrySet().forEach(System.out::println);

    String s1 = "Leetcode";

    Map<Character, Long> characterCount =
        s1.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    characterCount.entrySet().forEach(System.out::println);

    Map<Character, Long> charCount =
        s1.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.toMap(Function.identity(), c -> 1L, Long::sum, LinkedHashMap::new));

    charCount.entrySet().forEach(System.out::println);

  }

  static <T> void genericDisplay(T element) {
    System.out.println(element.getClass().getName() + " = " + element);
  }
}

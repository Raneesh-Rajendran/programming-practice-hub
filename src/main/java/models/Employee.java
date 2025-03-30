package main.java.models;

public class Employee implements Comparable {

  private Long id;
  private String name;
  private String email;
  private Long managerId;
  private Integer age;
  private String gender;
  private String firstName;
  private String lastName;

  public Employee(Long id, String name, String email, Long managerId) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.managerId = managerId;
  }

  public Employee(Long id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }

  public Employee(Long id, Integer age, String gender, String firstName, String lastName) {
    this.id = id;
    this.age = age;
    this.gender = gender;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public Employee(
      Long id,
      String name,
      String email,
      Long managerId,
      Integer age,
      String gender,
      String firstName,
      String lastName) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.managerId = managerId;
    this.age = age;
    this.gender = gender;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Long getManagerId() {
    return managerId;
  }

  public void setManagerId(Long managerId) {
    this.managerId = managerId;
  }

  @Override
  public String toString() {
    return "Employee{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", email='"
        + email
        + '\''
        + ", managerId="
        + managerId
        + ", age="
        + age
        + ", gender='"
        + gender
        + '\''
        + ", firstName='"
        + firstName
        + '\''
        + ", lastName='"
        + lastName
        + '\''
        + '}';
  }

  @Override
  public int compareTo(Object o) {
    return 0;
  }
}

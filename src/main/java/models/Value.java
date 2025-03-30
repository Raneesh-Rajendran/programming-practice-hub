package main.java.models;

public class Value {

  private Integer integer;
  private String string;

  public Value(Integer integer) {
    this.integer = integer;
  }

  public Value(String string) {
    this.string = string;
  }

  public Integer getInteger() {
    return integer;
  }

  public void setInteger(Integer integer) {
    this.integer = integer;
  }

  public String getString() {
    return string;
  }

  public void setString(String string) {
    this.string = string;
  }

  //    @Override
  //    public String toString() {
  //        String value = "(";
  //        if (!string.isBlank() && !string.isEmpty())
  //            value= value + string;
  //        if (integer!=null)
  //            value= value + integer.toString();
  //        value= value+")";
  //        return value;
  //    }

  @Override
  public String toString() {
    return "Value{" + "integer=" + integer + ", string='" + string + '\'' + '}';
  }
}

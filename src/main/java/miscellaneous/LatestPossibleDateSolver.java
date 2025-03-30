package main.java.miscellaneous;

/**
 * Problem Statement: There is a string representing a date in "MM-DD" format, where MM denotes a
 * month in a two-digit format and DD denotes a day in a two-digit format. Some digits were replaced
 * by "?". Replace all the question marks with digits (0-9) in such a way as to obtain the latest
 * possible date. Assume that the maximum number of days in each month is as follows:
 *
 * <p>January: 31, February: 28, March: 31, April: 30, May: 31, June: 30, July: 31, August: 31,
 * September: 30, October: 31, November: 30, December: 31
 *
 * <p>Write a function that, given a string date, returns the latest valid date as a string in the
 * format "MM-DD". If it is not possible to obtain any valid date, return the string "XX-XX".
 */
public class LatestPossibleDateSolver {
  public String solve(String date) {
    // Maximum number of days in each month
    int[] maxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // Extract month and day from the date
    String month = date.substring(0, 2);
    String day = date.substring(3, 5);

    // Replace '?' in month and day
    month = replaceMonth(month);
    if (month.equals("XX")) return "XX-XX";

    int monthIndex = Integer.parseInt(month) - 1;
    day = replaceDay(day, maxDays[monthIndex]);
    if (day.equals("XX")) return "XX-XX";

    return month + "-" + day;
  }

  private String replaceMonth(String month) {
    if (month.equals("??")) return "12";
    if (month.charAt(0) == '?') {
      if (month.charAt(1) == '0' || month.charAt(1) > '2') return "XX";
      return (month.charAt(1) == '2') ? "12" : "0" + month.charAt(1);
    }
    if (month.charAt(1) == '?') {
      return (month.charAt(0) == '1') ? "12" : month.charAt(0) + "0";
    }
    int m = Integer.parseInt(month);
    if (m == 0 || m > 12) return "XX";
    return month;
  }

  private String replaceDay(String day, int maxDay) {
    if (day.equals("??")) return String.format("%02d", maxDay);
    if (day.charAt(0) == '?') {
      int d = Integer.parseInt("0" + day.charAt(1));
      return (d <= maxDay) ? String.format("%02d", Math.min(d + 10, maxDay)) : "XX";
    }
    if (day.charAt(1) == '?') {
      int d = Integer.parseInt(day.charAt(0) + "0");
      return (d <= maxDay) ? day.charAt(0) + "9" : "XX";
    }
    int d = Integer.parseInt(day);
    if (d == 0 || d > maxDay) return "XX";
    return day;
  }
}

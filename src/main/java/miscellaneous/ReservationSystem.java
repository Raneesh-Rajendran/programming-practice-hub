package main.java.miscellaneous;

import java.io.*;

public class ReservationSystem {
  static int minReservationTables(int[][] reservationStartEndTimes) {
    // YOUR CODE HERE
    int count = 1;
    for (int i = 0; i < reservationStartEndTimes.length; i++) {
      for (int j = 1; j < reservationStartEndTimes.length; j++) {
        if ((reservationStartEndTimes[i][i] < reservationStartEndTimes[j][i])
            && (reservationStartEndTimes[i][i + 1] < reservationStartEndTimes[j][i + 1])) count++;
      }
    }
    return count;
  }

  // DO NOT MODIFY ANYTHING BELOW THIS LINE!!

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter wr = new PrintWriter(System.out);
    int n = Integer.parseInt(br.readLine().trim());
    int[][] reservationStartEndTimeList = new int[n][2];
    String[] reservationStartEndTimes = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      String[] reservationStartEndTime = reservationStartEndTimes[i].split(",");
      for (int j = 0; j < reservationStartEndTime.length; j++) {
        reservationStartEndTimeList[i][j] = Integer.parseInt(reservationStartEndTime[j]);
      }
    }

    int out = minReservationTables(reservationStartEndTimeList);
    System.out.println(out);

    wr.close();
    br.close();
  }
}

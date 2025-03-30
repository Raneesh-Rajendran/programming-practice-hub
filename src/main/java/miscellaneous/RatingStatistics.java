package main.java.miscellaneous;

import java.util.*;

public class RatingStatistics {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numLines = Integer.parseInt(scanner.nextLine());
    int currentLine = 0;
    while (currentLine++ < numLines) {
      final RatingStatisticsCollector stats = new RatingStatisticsCollectorImpl();
      final Set<String> apps = new TreeSet<>();

      String line = scanner.nextLine();
      String[] inputs = line.split(",");
      for (int i = 0; i < inputs.length; ++i) {
        String[] tokens = inputs[i].split(" ");
        final String app = tokens[0];
        apps.add(app);
        final int runs = Integer.parseInt(tokens[1]);

        stats.putNewRating(app, runs);
      }

      for (String app : apps) {
        System.out.printf(
                "%s %.2f %d%n", app, stats.getAverageRating(app), stats.getRatingsCount(app));
      }
    }
    scanner.close();
  }

  ////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

  public interface RatingStatisticsCollector {
    // Ratings feed will call this method when new app rating information is received. This is input
    // to your class. ratings is a non negative integer between 0 to 10.
    void putNewRating(String app, int rating);

    // Report the average rating of the app.
    double getAverageRating(String app);

    // Report the total number of rating for an app.
    int getRatingsCount(String app);
  }

  public static class RatingStatisticsCollectorImpl implements RatingStatisticsCollector {
    public Map<String, List<Integer>> ratingsMap = new HashMap<>();

    @Override
    public void putNewRating(String app, int rating) {
      // YOUR CODE HERE
      List<Integer> ratings;
      if (ratingsMap.containsKey(app)) {
        ratings = ratingsMap.get(app);
        ratings.set(0, ratings.get(0) + rating);
        ratings.set(1, ratings.get(1) + 1);
        ratingsMap.put(app, ratings);

      } else {
        ratings = new ArrayList<>();
        ratings.add(rating);
        ratings.add(1);
        ratingsMap.put(app, ratings);
      }
      System.out.println(ratingsMap);
    }

    @Override
    public double getAverageRating(String app) {
      // YOUR CODE HERE
      List<Integer> ratings;
      if (ratingsMap.containsKey(app)) {
        ratings = ratingsMap.get(app);
        return (double) ratings.get(0) / ratings.get(1);
      }
      return 0;
    }

    @Override
    public int getRatingsCount(String app) {
      // YOUR CODE HERE
      List<Integer> ratings;
      if (ratingsMap.containsKey(app)) {
        ratings = ratingsMap.get(app);
        return ratings.get(1);
      }
      return 0;
    }
  }
}

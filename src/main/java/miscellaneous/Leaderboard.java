package main.java.miscellaneous;

import java.util.*;

public class Leaderboard {
  private final Map<Integer, Integer> playerMap;

  public Leaderboard() {
    playerMap = new HashMap<>();
  }

  public static void main(String[] args) {
    Leaderboard leaderboard = new Leaderboard();
    leaderboard.addScore(1, 73);
    leaderboard.addScore(2, 56);
    leaderboard.addScore(3, 39);
    leaderboard.addScore(4, 51);
    leaderboard.addScore(5, 4);
    System.out.println(leaderboard.top(1)); // Output: 73
    leaderboard.reset(1);
    leaderboard.reset(2);
    leaderboard.addScore(2, 51);
    System.out.println(leaderboard.top(3)); // Output: 141 (51 + 51 + 39)
  }

  public void addScore(int playerId, int score) {
    // Update the leaderboard by adding the score to the player's existing score.
    playerMap.put(playerId, playerMap.getOrDefault(playerId, 0) + score);
  }

  public int top(int K) {
    // Create a priority queue to store the top K scores.
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(K, Collections.reverseOrder());

    // Iterate through player scores and add them to the max heap.
    for (int score : playerMap.values()) {
      maxHeap.offer(score);
    }

    // Calculate the sum of the top K scores.
    int sum = 0;
    while (K > 0 && !maxHeap.isEmpty()) {
      sum += maxHeap.poll();
      K--;
    }

    return sum;
  }

  public void reset(int playerId) {
    // Reset the player's score by removing the entry from the map.
    playerMap.remove(playerId);
  }
}

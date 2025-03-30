package main.java.miscellaneous;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/*
In a special ranking system, each voter gives a rank from highest to lowest to all teams participating in the competition.

The ordering of teams is decided by who received the most position-one votes. If two or more teams tie in the first position,
we consider the second position to resolve the conflict, if they tie again, we continue this process until the ties are resolved.
If two or more teams are still tied after considering all positions, we rank them alphabetically based on their team letter.

You are given an array of strings votes which is the votes of all voters in the ranking systems. Sort all teams according to
the ranking system described above.

Return a string of all teams sorted by the ranking system.

Input: votes = ["ABC","ACB","ABC","ACB","ACB"]
Output: "ACB"
Explanation:
Team A was ranked first place by 5 voters. No other team was voted as first place, so team A is the first team.
Team B was ranked second by 2 voters and ranked third by 3 voters.
Team C was ranked second by 3 voters and ranked third by 2 voters.
As most of the voters ranked C second, team C is the second team, and team B is the third.

Example 2:
Input: votes = ["WXYZ","XYZW"]
Output: "XWYZ"
 */
public class RankingSystem {

  public static void main(String[] args) {
    String[] votes = {"ZMNAGUEDSJYLBOPHRQICWFXTVK"};
    System.out.println(rankedTeams(votes));
  }

  public static String rankedTeams(String[] array) {
    TreeMap<Character, Integer> positionSum = new TreeMap<>();

    for (String vote : array) {
      for (int i = 0; i < vote.length(); i++) {
        positionSum.put(vote.charAt(i), positionSum.getOrDefault(vote.charAt(i), 0) + i);
      }
    }

    return positionSum.entrySet().stream()
        .sorted(Map.Entry.comparingByValue())
        .map(entry -> entry.getKey().toString())
        .collect(Collectors.joining());
  }
}

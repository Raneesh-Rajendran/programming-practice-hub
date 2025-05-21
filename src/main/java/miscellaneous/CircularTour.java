package main.java.miscellaneous;

/*
2 arrays
gas filing ->
gas bought = {3,4,5,6}
gas spent= {1,2,3,4}

output: index from its starts
//
cost = {10,3,4,5}

circular tour ->
 */
public class CircularTour {

  public static void main(String[] args) {
    int[] gasBought = {3, 4, 5, 6};
    int[] gasSpent = {10, 1, 1, 4};
    System.out.println("Start the travel from " + startingIndex(gasBought, gasSpent));
  }

  public static int startingIndex(int[] gasBought, int[] gasSpent) {
    int total = 0;
    int currentTank = 0;
    int startIndex = 0;
    for (int i = 0; i < gasBought.length; i++) {
      int netGain = gasBought[i] - gasSpent[i];
      total += netGain;
      currentTank += netGain;

      if (currentTank < 0) {
        startIndex = i + 1;
        currentTank = 0;
      }
    }
    return total >= 0 ? startIndex % gasBought.length : -1;
  }
}

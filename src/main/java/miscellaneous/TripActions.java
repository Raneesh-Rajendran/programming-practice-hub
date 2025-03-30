package main.java.miscellaneous;

import java.io.*;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'segment' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER x
   *  2. INTEGER_ARRAY space
   */

  public static int segment(int x, List<Integer> space) {
    // Write your code here
    int result = 0;
    Queue<Integer> minQueue = new PriorityQueue<>(x);
    for (int i = 0; i < space.size(); i++) {
      minQueue.add(space.get(i));
      if (i + 1 >= x) {
        result = Math.max(result, minQueue.peek() != null ? minQueue.peek() : 0);
        minQueue.remove(space.get(i - (x - 1)));
      }
    }
    return result;
  }
}

public class TripActions {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int x = Integer.parseInt(bufferedReader.readLine().trim());

    int spaceCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> space =
        IntStream.range(0, spaceCount)
            .mapToObj(
                i -> {
                  try {
                    return bufferedReader.readLine().replaceAll("\\s+$", "");
                  } catch (IOException ex) {
                    throw new RuntimeException(ex);
                  }
                })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

    int result = Result.segment(x, space);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}

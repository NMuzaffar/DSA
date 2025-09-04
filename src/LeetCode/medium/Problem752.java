package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/open-the-lock/">752. Open the Lock</a>
 */
public class Problem752 {

  public static void main(String[] args) {
    assertEquals(6, openLock(new String[] {"0201","0101","0102","1212","2002"}, "0202"));
    assertEquals(1, openLock(new String[] {"8888"}, "0009"));
    assertEquals(-1, openLock(new String[] {"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888"));
  }

  /**
   * Approach: Graph BFS <br>
   * Time Complexity: O(10^n * n^2 + d) <-> 10^n different states, each state perform O(n^2) work <br>
   * Space Complexity: O(10^n) <br>
   */
  public static int openLock(String[] deadends, String target) {
    Queue<State> queue = new LinkedList<>();
    Set<String> visited = new HashSet<>(Arrays.asList(deadends));
    if (!visited.add("0000")) {
      return -1;
    }
    queue.offer(new State("0000", 0));
    while (!queue.isEmpty()) {
      State state = queue.poll();
      String node = state.node;
      int steps = state.steps;
      if (node.equals(target)) {
        return steps;
      }
      for (String neighbor : getNeighbors(node)) {
        if (!visited.contains(neighbor)) {
          visited.add(neighbor);
          queue.offer(new State(neighbor, steps + 1));
        }
      }
    }
    return -1;
  }

  private static List<String> getNeighbors(String node) { // O(n^2) <-> 'n' is a variable number of wheels
    List<String> neighbors = new ArrayList<>();
    int[] wheelRotations = new int[] { -1, 1 };
    for (int i = 0; i < 4; i++) {
      int currSlot = node.charAt(i) - '0';
      for (int rotation : wheelRotations) { // O(n)
        int nextSlot = (currSlot + rotation + 10) % 10;
        StringBuilder neighborSb = new StringBuilder(node);
        neighborSb.setCharAt(i, (char) ('0' + nextSlot)); // O(n)
        neighbors.add(neighborSb.toString());
      }
    }
    return neighbors;
  }

  static class State {
    String node;
    int steps;
    State(String node, int steps) {
      this.node = node;
      this.steps = steps;
    }
  }
}

package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/">1557. Minimum Number of Vertices to Reach All Nodes</a>
 */
public class Problem1557 {

  public static void main(String[] args) {
    assertEquals(List.of(0,3), findSmallestSetOfVertices(6, List.of(List.of(0,1), List.of(0,2), List.of(2,5), List.of(3,4), List.of(4,2))));
    assertEquals(List.of(0,2,3), findSmallestSetOfVertices(5, List.of(List.of(0,1), List.of(2,1), List.of(3,1), List.of(1,4), List.of(2,4))));
  }

  /**
   * Approach: Graph <br>
   * Time Complexity: O(e + n) <br>
   * Space Complexity: O(n) <br>
   */
  public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
    int[] indegree = new int[n];
    for (List<Integer> edge : edges) {
      indegree[edge.get(1)]++;
    }
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (indegree[i] == 0) {
        res.add(i);
      }
    }
    return res;
  }
}

package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/evaluate-division/">399. Evaluate Division</a>
 */
public class Problem399 {

  public static void main(String[] args) {
    assertArrayEquals(
        new double[] {6.00000,0.50000,-1.00000,1.00000,-1.00000},
        calcEquation(
            List.of(List.of("a","b"), List.of("b","c")),
            new double[] {2.0,3.0},
            List.of(List.of("a","c"), List.of("b","a"), List.of("a","e"), List.of("a","a"), List.of("x","x"))
        ),
        1e-5
    );

    assertArrayEquals(
        new double[] {3.75000,0.40000,5.00000,0.20000},
        calcEquation(
            List.of(List.of("a","b"), List.of("b","c"), List.of("bc","cd")),
            new double[] {1.5,2.5,5.0},
            List.of(List.of("a","c"), List.of("c","b"), List.of("bc","cd"), List.of("cd","bc"))
        ),
        1e-5
    );

    assertArrayEquals(
        new double[] {0.50000,2.00000,-1.00000,-1.00000},
        calcEquation(
            List.of(List.of("a","b")),
            new double[] {0.5},
            List.of(List.of("a","b"), List.of("b","a"), List.of("a","c"), List.of("x","y"))
        ),
        1e-5
    );

    assertArrayEquals(
        new double[] {360.00000,0.00833,20.00000,1.00000,-1.00000,-1.00000},
        calcEquation(
            List.of(List.of("x1","x2"), List.of("x2","x3"), List.of("x3","x4"), List.of("x4","x5")),
            new double[] {3.0,4.0,5.0,6.0},
            List.of(List.of("x1","x5"), List.of("x5","x2"), List.of("x2","x4"), List.of("x2","x2"), List.of("x2","x9"), List.of("x9","x9"))
        ),
        1e-5
    );
  }

  /**
   * Approach: Graph DFS (Recursive) <br>
   * Time Complexity: O(m * n) <-> 'm' = queries.length & 'n' = equations.length <br>
   * Space Complexity: O(m + n) <br>
   */
  public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    Map<String, List<Step>> graph = buildGraph(equations, values);
    int m = queries.size();
    double[] ans = new double[m];
    for (int i = 0; i < m; i++) {
      ans[i] = evaluateQuery(queries.get(i).get(0), queries.get(i).get(1), 1.0d, graph, new HashSet<>());
    }
    return ans;
  }

  private static double evaluateQuery(String currNode, String targetNode, double currWeight, Map<String, List<Step>> graph, Set<String> visited) {
    if (!graph.containsKey(currNode) || !graph.containsKey(targetNode)) {
      return -1.0d;
    } else if (currNode.equals(targetNode)) {
      return currWeight;
    }
    visited.add(currNode);
    for (Step neighbor : graph.get(currNode)) {
      if (!visited.contains(neighbor.node)) {
        double result = evaluateQuery(neighbor.node, targetNode, currWeight * neighbor.weight, graph, visited);
        if (result != -1) {
          return result; // return first valid path
        }
      }
    }
    visited.remove(currNode); // backtrack
    return -1.0d;
  }

  private static Map<String, List<Step>> buildGraph(List<List<String>> equations, double[] values) {
    Map<String, List<Step>> graph = new HashMap<>();
    for (int i = 0; i < equations.size(); i++) {
      List<String> equation = equations.get(i);
      String a = equation.get(0);
      String b = equation.get(1);
      double weight = values[i];
      graph.computeIfAbsent(a, k -> new ArrayList<>()).add(new Step(b, weight));
      graph.computeIfAbsent(b, k -> new ArrayList<>()).add(new Step(a, 1 / weight));
    }
    return graph;
  }

  static class Step {
    String node;
    double weight;
    Step(String node, double weight) {
      this.node = node;
      this.weight = weight;
    }
    @Override
    public String toString() {
      return node + "->" + weight;
    }
  }
}

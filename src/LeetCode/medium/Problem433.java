package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <a href="https://leetcode.com/problems/minimum-genetic-mutation/">433. Minimum Genetic Mutation</a>
 */
public class Problem433 {

  public static void main(String[] args) {
    assertEquals(1, minMutation("AACCGGTT", "AACCGGTA", new String[] {"AACCGGTA"}));
    assertEquals(2, minMutation("AACCGGTT", "AAACGGTA", new String[] {"AACCGGTA","AACCGCTA","AAACGGTA"}));
  }

  /**
   * Approach: <br>
   * Time Complexity: O() <br>
   * Space Complexity: O() <br>
   */
  public static int minMutation(String startGene, String endGene, String[] bank) {
    return -1;
  }
}

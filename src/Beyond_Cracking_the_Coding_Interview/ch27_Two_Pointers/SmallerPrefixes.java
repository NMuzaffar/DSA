package Beyond_Cracking_the_Coding_Interview.ch27_Two_Pointers;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://start.interviewing.io/beyond-ctci/part-vii-catalog/two-pointers#smaller-prefixes">Smaller Prefixes</a>
 */
public class SmallerPrefixes {

  public static void main(String[] args) {
    runTests();
  }

  public static void runTests() {
    Assertions.assertTrue(solve(new int[] {1, 2, 2, -1}));
    Assertions.assertFalse(solve(new int[] {1, 2, -2, 1, 3, 5}));
  }

  /**
   * Approach: Two Pointers <br>
   * Time Complexity: O() <br>
   * Space Complexity: O(1) <br>
   */
  public static boolean solve(int[] arr) {
    return true;
  }
}

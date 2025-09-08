package Beyond_Cracking_the_Coding_Interview.ch27_Two_Pointers;

/**
 * <a href="https://start.interviewing.io/beyond-ctci/part-vii-catalog/two-pointers#palindrome-check">Palindrome Check</a>
 */
public class Palindrome {

  public static void main(String[] args){
    runTests();
  }

  public static void runTests() {
    Object[][] tests = {
        // Example from the book
        { "level", true },
        { "naan", true },
        // Additional test cases
        { "", true },
        { "a", true },
        { "ab", false },
        { "abc", false },
        { "abba", true },
        { "abcba", true },
    };

    Palindrome solution = new Palindrome();
    for (Object[] test : tests) {
      String s = (String) test[0];
      boolean want = (boolean) test[1];
      boolean got = solution.solve(s);
      if (got != want) {
        throw new RuntimeException(String.format(
            "\nsolve(%s): got: %b, want: %b\n",
            s, got, want));
      }
    }
  }

  /**
   * Approach: Two Pointers <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(1) <br>
   */
  public static boolean solve(String s) {
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}

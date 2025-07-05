package Structy.ch08_Stack;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <a href="https://structy.net/problems/premium/paired-parentheses">Paired Parentheses</a>
 */
public class PairedParentheses {

  public static void main(String[] args) {
    assertTrue(pairedParentheses("(david)((abby))"));
    assertFalse(pairedParentheses("()rose(jeff"));
    assertFalse(pairedParentheses(")("));
    assertTrue(pairedParentheses("()"));
    assertTrue(pairedParentheses("(((potato())))"));
    assertTrue(pairedParentheses("(())(water)()"));
    assertFalse(pairedParentheses("(())(water()()"));
    assertTrue(pairedParentheses(""));
    assertFalse(pairedParentheses("))()"));
  }

  /**
   * Time Complexity: O(n) <br>
   * Space Complexity: O(1) <br>
   */
  public static boolean pairedParentheses(String str) {
    int count = 0;
    for (char c : str.toCharArray()) {
      if (c == '(') {
        count++;
      } else if (c == ')') {
        if (count > 0) {
          count--;
        } else {
          return false;
        }
      }
    }
    return count == 0;
  }
}

package Structy.ch08_Stack;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * <a href="https://structy.net/problems/premium/befitting-brackets">Befitting Brackets</a>
 */
public class BefittingBrackets {

  public static void main(String[] args) {
    assertTrue(befittingBrackets("(){}[](())"));
    assertTrue(befittingBrackets("({[]})"));
    assertFalse(befittingBrackets("[][}"));
    assertFalse(befittingBrackets("{[]}({}"));
    assertFalse(befittingBrackets("[]{}(}[]"));
    assertTrue(befittingBrackets("[]{}()[]"));
    assertFalse(befittingBrackets("]{}"));
    assertTrue(befittingBrackets(""));
    assertFalse(befittingBrackets("{[(}])"));
  }

  /**
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static boolean befittingBrackets(String str) {
    Map<Character, Character> bracketsMapping = Map.of(
        '(', ')',
        '{', '}',
        '[', ']');
    Deque<Character> stack = new ArrayDeque<>();
    for (char c : str.toCharArray()) {
      if (bracketsMapping.containsKey(c)) {
        stack.push(c);
      } else {
        if (stack.isEmpty() || c != bracketsMapping.get(stack.pop())) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}

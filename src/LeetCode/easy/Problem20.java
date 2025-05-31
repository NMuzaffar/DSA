//package LeetCode.easy;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.*;
//
///**
// * <a href="https://leetcode.com/problems/valid-parentheses/">20. Valid Parentheses</a>
// */
//public class Problem20 {
//
//  public static void main(String[] args) {
//    assertTrue(isValid("()"));
//    assertTrue(isValid("()[]{}"));
//    assertFalse(isValid("(]"));
//    assertTrue(isValid("([])"));
//    assertTrue(isValid("{([]){}}"));
//    assertFalse(isValid("{([}])"));
//    assertTrue(isValid("(((((())))))"));
//    assertTrue(isValid("()()()()"));
//    assertFalse(isValid("(((((((()"));
//    assertTrue(isValid("((()(())))"));
//  }
//
//  /**
//   * Approach: Stack <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static boolean isValid(String s) {
//    Map<Character, Character> bracketsMapping =
//        Map.of(
//            '(', ')',
//            '{', '}',
//            '[', ']');
//    Deque<Character> openBrackets = new ArrayDeque<>();
//    for (char c : s.toCharArray()) {
//      if (bracketsMapping.containsKey(c)) {
//        openBrackets.addFirst(c);
//      } else {
//        if (openBrackets.isEmpty()) {
//          return false;
//        }
//        char previousOpening = openBrackets.removeFirst();
//        if (bracketsMapping.get(previousOpening) != c) {
//          return false;
//        }
//      }
//    }
//    return openBrackets.isEmpty();
//  }
//}

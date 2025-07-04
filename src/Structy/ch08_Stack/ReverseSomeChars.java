package Structy.ch08_Stack;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

/**
 * <a href="https://structy.net/problems/premium/reverse-some-chars">Reverse Some Chars</a>
 */
public class ReverseSomeChars {

  public static void main(String[] args) {
    assertEquals("cemputor", reverseSomeChars("computer", List.of('a', 'e', 'i', 'o', 'u')));
    assertEquals("skatobeard", reverseSomeChars("skateboard", List.of('a', 'e', 'i', 'o', 'u')));
    assertEquals("ainplare", reverseSomeChars("airplane", List.of('m', 'n', 'r')));
    assertEquals("buglidni", reverseSomeChars("building", List.of('g', 'd', 'i')));
  }

  /**
   * Time Complexity: O(n + m) <br>
   * Space Complexity: O(n + m) <br>
   */
  public static String reverseSomeChars(String str, List<Character> chars) {
    Set<Character> canBeReversedChars = new HashSet<>(chars);
    Deque<Character> reversedStrChars = new ArrayDeque<>();
    for (char c : str.toCharArray()) {
      if (canBeReversedChars.contains(c)) {
        reversedStrChars.push(c);
      }
    }
    StringBuilder sb = new StringBuilder();
    for (char c : str.toCharArray()) {
      if (canBeReversedChars.contains(c)) {
        sb.append(reversedStrChars.pop());
      } else {
        sb.append(c);
      }
    }
    return sb.toString();
  }
}

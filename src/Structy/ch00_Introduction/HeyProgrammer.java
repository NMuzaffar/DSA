package Structy.ch00_Introduction;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://structy.net/problems/hey-programmer">Hey Programmer</a>
 */
public class HeyProgrammer {

  public static void main(String[] args) {
    assertEquals("hey alvin", greet("alvin"));
    assertEquals("hey jason", greet("jason"));
    assertEquals("hey how now brown cow", greet("how now brown cow"));
  }

  /**
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static String greet(String s) {
    return "hey " + s;
  }
}

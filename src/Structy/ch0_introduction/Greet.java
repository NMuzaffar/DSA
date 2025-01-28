package Structy.ch0_introduction;

import static org.junit.jupiter.api.Assertions.*;

public class Greet {

  public static void main(String[] args) {
    assertEquals("hey alvin", greet("alvin"));
    assertEquals("hey jason", greet("jason"));
    assertEquals("hey how now brown cow", greet("how now brown cow"));
  }

  /**
   * Time Complexity: O(1) <br>
   * Space Complexity: O(1) <br>
   */
  public static String greet(String s) {
    return "hey " + s;
  }
}

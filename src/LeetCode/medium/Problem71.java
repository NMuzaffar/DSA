package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/simplify-path/">71. Simplify Path</a>
 */
public class Problem71 {

  public static void main(String[] args) {
    assertEquals("/home", simplifyPath("/home/"));
    assertEquals("/home/foo", simplifyPath("/home//foo/"));
    assertEquals("/home/user/Pictures", simplifyPath("/home/user/Documents/../Pictures"));
    assertEquals("/", simplifyPath("/../"));
    assertEquals("/.../b/d", simplifyPath("/.../a/../b/c/../d/./"));
    assertEquals("/a/b/f", simplifyPath("/a/b///c/.././d/../f/"));
  }

  /**
   * Approach: Stack <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static String simplifyPath(String path) {
    Deque<String> stack = new ArrayDeque<>();
    String[] components = path.split("/");
    for (String directory : components) {
      if (directory.equals(".") || directory.isEmpty()) {
        continue;
      } else if (directory.equals("..")) {
        if (!stack.isEmpty()) {
          stack.removeFirst();
        }
      } else {
        stack.addFirst(directory);
      }
    }
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append("/").append(stack.removeLast());
    }
    return sb.isEmpty() ? "/" : sb.toString();
  }
}

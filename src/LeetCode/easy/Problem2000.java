package LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/reverse-prefix-of-word/">2000. Reverse Prefix of Word</a>
 */
public class Problem2000 {

  public static void main(String[] args) {
    assertEquals("dcbaefd", reversePrefix("abcdefd", 'd'));
    assertEquals("zxyxxe", reversePrefix("xyxzxe", 'z'));
    assertEquals("abcd", reversePrefix("abcd", 'z'));
  }

  /**
   * Approach: Two Pointers <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static String reversePrefix(String word, char ch) {
    char[] chArray = word.toCharArray();
    for (int left = 0, right = 0; right < chArray.length; right++) {
      if (chArray[right] == ch) {
        while (left < right) {
          char temp = chArray[left];
          chArray[left++] = chArray[right];
          chArray[right--] = temp;
        }
        return new String(chArray);
      }
    }
    return word;
  }

//  /**
//   * Approach: Find the Index and Fill Result <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static String reversePrefix(String word, char ch) {
//    int chIndex = word.indexOf(ch);
//    if (chIndex == -1) {
//      return word;
//    }
//    StringBuilder sb = new StringBuilder();
//    for (int i = 0; i < word.length(); i++) {
//      if (i <= chIndex) {
//        sb.append(word.charAt(chIndex - i));
//      } else {
//        sb.append(word.charAt(i));
//      }
//    }
//    return sb.toString();
//  }
//
//  /**
//   * Approach: Stack <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static String reversePrefix(String word, char ch) {
//    StringBuilder sb = new StringBuilder();
//    Stack<Character> stack = new Stack<>();
//    int index = 0;
//    while (index < word.length()) {
//      stack.push(word.charAt(index));
//      if (word.charAt(index) == ch) {
//        while (!stack.isEmpty()) {
//          sb.append(stack.pop());
//        }
//        index++;
//        while (index < word.length()) {
//          sb.append(word.charAt(index));
//          index++;
//        }
//        return sb.toString();
//      }
//      index++;
//    }
//    return word;
//  }
}

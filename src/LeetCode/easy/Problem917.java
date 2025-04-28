package LeetCode.easy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/reverse-only-letters/">917. Reverse Only Letters</a>
 */
public class Problem917 {

  public static void main(String[] args) {
    assertEquals("dc-ba", reverseOnlyLetters("ab-cd"));
    assertEquals("j-Ih-gfE-dCba", reverseOnlyLetters("a-bC-dEf-ghIj"));
    assertEquals("Qedo1ct-eeLg=ntse-T!", reverseOnlyLetters("Test1ng-Leet=code-Q!"));
  }

  /**
   * Approach: Two Pointers <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static String reverseOnlyLetters(String s) {
    char[] chArray = s.toCharArray();
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
      if (Character.isLetter(chArray[left]) && Character.isLetter(chArray[right])) {
        char temp = chArray[left];
        chArray[left++] = chArray[right];
        chArray[right--] = temp;
      }
      if (!Character.isLetter(chArray[left])) {
        left++;
      }
      if (!Character.isLetter(chArray[right])) {
        right--;
      }
    }
    return new String(chArray);
  }

//  /**
//   * Approach: Stack of Letters <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static String reverseOnlyLetters(String s) {
//    Stack<Character> letters = new Stack<>();
//    for (char c : s.toCharArray()) {
//      if (Character.isLetter(c)) {
//        letters.push(c);
//      }
//    }
//    StringBuilder sb = new StringBuilder();
//    for (char c : s.toCharArray()) {
//      if (Character.isLetter(c)) {
//        sb.append(letters.pop());
//      } else {
//        sb.append(c);
//      }
//    }
//    return sb.toString();
//  }
}


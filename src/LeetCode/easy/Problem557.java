//package LeetCode.easy;
//
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * <a href="https://leetcode.com/problems/reverse-words-in-a-string-iii/">557. Reverse Words in a String III</a>
// */
//public class Problem557 {
//
//  public static void main(String[] args) {
//    assertEquals("s'teL ekat edoCteeL tsetnoc", reverseWords("Let's take LeetCode contest"));
//    assertEquals("rM gniD", reverseWords("Mr Ding"));
//  }
//
//  /**
//   * Approach: Two Pointers <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static String reverseWords(String s) {
//    char[] chArray = s.toCharArray();
//    int lastSpaceIndex = -1;
//    for (int i = 0; i <= s.length(); i++) {
//      if (i == s.length() || Character.isWhitespace(chArray[i])) {
//        int startIndex = lastSpaceIndex + 1;
//        int endIndex = i - 1;
//        while (startIndex < endIndex) {
//          char temp = chArray[startIndex];
//          chArray[startIndex++] = chArray[endIndex];
//          chArray[endIndex--] = temp;
//        }
//        lastSpaceIndex = i;
//      }
//    }
//    return new String(chArray);
//  }
//
////  /**
////   * Approach: Traverse and Reverse each character one by one <br>
////   * Time Complexity: O(n) <br>
////   * Space Complexity: O(n) <br>
////   */
////  public static String reverseWords(String s) {
////    StringBuilder sb = new StringBuilder();
////    int lastSpaceIndex = -1;
////    for (int i = 0; i < s.length(); i++) {
////      if ((i == s.length() - 1) || Character.isWhitespace(s.charAt(i))) {
////        int reverseIndex = (i == s.length() - 1) ? i : (i - 1);
////        for (; reverseIndex > lastSpaceIndex; reverseIndex--) {
////          sb.append(s.charAt(reverseIndex));
////        }
////        if (i != s.length() - 1) {
////          sb.append(' ');
////        }
////        lastSpaceIndex = i;
////      }
////    }
////    return sb.toString();
////  }
//}
//

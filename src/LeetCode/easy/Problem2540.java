package LeetCode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <a href="https://leetcode.com/problems/minimum-common-value/">2540. Minimum Common Value</a>
 */
public class Problem2540 {

  public static void main(String[] args) {
    assertEquals(2, getCommon(new int[] {1,2,3}, new int[] {2,4}));
    assertEquals(2, getCommon(new int[] {1,2,3,6}, new int[] {2,3,4,5}));
  }

  /**
   * Approach: Two Pointers <br>
   * Time Complexity: O(n + m) <br>
   * Space Complexity: O(1) <br>
   */
  public static int getCommon(int[] nums1, int[] nums2) {
    int i = 0;
    int j = 0;
    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] < nums2[j]) {
        i++;
      } else if (nums1[i] > nums2[j]) {
        j++;
      } else {
        return nums1[i];
      }
    }
    return -1;
  }

//  /**
//   * Approach: Hash Set <br>
//   * Time Complexity: O(n + m) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static int getCommon(int[] nums1, int[] nums2) {
//    Set<Integer> nums1Set = new HashSet<>();
//    for (int num : nums1) {
//      nums1Set.add(num);
//    }
//    for (int num : nums2) {
//      if (nums1Set.contains(num)) {
//        return num;
//      }
//    }
//    return -1;
//  }
}

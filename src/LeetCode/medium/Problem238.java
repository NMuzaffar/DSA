//package LeetCode.medium;
//
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * <a href="https://leetcode.com/problems/product-of-array-except-self/">238. Product of Array Except Self</a>
// */
//public class Problem238 {
//
//  public static void main(String[] args) {
//    assertArrayEquals(new int[] {24, 12, 8, 6}, productExceptSelf(new int[] {1, 2, 3, 4}));
//    assertArrayEquals(new int[] {0, 0, 9, 0, 0}, productExceptSelf(new int[] {-1, 1, 0, -3, 3}));
//  }
//
//  /**
//   * Approach: Prefix Sum (Prefix Product) <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static int[] productExceptSelf(int[] nums) {
//    int n = nums.length;
//    int[] prefix = new int[n];
//    prefix[0] = 1;
//    for (int i = 1; i < n; i++) {
//      prefix[i] = prefix[i - 1] * nums[i - 1];
//    }
//    int[] suffix = new int[n];
//    suffix[n - 1] = 1;
//    for (int j = n - 2; j >= 0; j--) {
//      suffix[j] = suffix[j + 1] * nums[j + 1];
//    }
//    int[] ans = new int[n];
//    for (int k = 0; k < n; k++) {
//      ans[k] = prefix[k] * suffix[k];
//    }
//    return ans;
//  }
//}

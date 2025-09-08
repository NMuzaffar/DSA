//package LeetCode.medium;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * <a href="https://leetcode.com/problems/smallest-number-in-infinite-set/">2336. Smallest Number in Infinite Set</a>
// */
//public class Problem2336 {
//
//  public static void main(String[] args) {
//    SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
//    smallestInfiniteSet.addBack(2);    // 2 is already in the set, so no change is made.
//    assertEquals(1, smallestInfiniteSet.popSmallest()); // return 1, since 1 is the smallest number, and remove it from the set.
//    assertEquals(2, smallestInfiniteSet.popSmallest()); // return 2, and remove it from the set.
//    assertEquals(3, smallestInfiniteSet.popSmallest()); // return 3, and remove it from the set.
//    smallestInfiniteSet.addBack(1);    // 1 is added back to the set.
//    assertEquals(1, smallestInfiniteSet.popSmallest()); // return 1, since 1 was added back to the set and
//    // is the smallest number, and remove it from the set.
//    assertEquals(4, smallestInfiniteSet.popSmallest()); // return 4, and remove it from the set.
//    assertEquals(5, smallestInfiniteSet.popSmallest()); // return 5, and remove it from the set.
//  }
//
//  /**
//   * Your SmallestInfiniteSet object will be instantiated and called as such:
//   * SmallestInfiniteSet obj = new SmallestInfiniteSet();
//   * int param_1 = obj.popSmallest();
//   * obj.addBack(num);
//   */
//  static class SmallestInfiniteSet {
//
//    /**
//     * Approach: Heap (Priority Queue) <br>
//     * Time Complexity: O() <br>
//     * Space Complexity: O() <br>
//     */
//    public SmallestInfiniteSet() {
//    }
//
//    public int popSmallest() {
//    }
//
//    public void addBack(int num) {
//    }
//  }
//}

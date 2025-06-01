package Coding_Interview_Patterns_ByteByteGo.ch1_two_pointers;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <a href="https://bytebytego.com/exercises/coding-patterns/two-pointers/shift-zeros-to-the-end">Shift Zeros to the End</a>
 */
public class ShiftZerosToTheEnd {

  public static void main(String[] args) {
    int[] nums = new int[] {0, 1, 0, 3, 2};
    shiftZerosToTheEnd(nums);
    assertArrayEquals(new int[] {1, 3, 2, 0, 0}, nums);

    nums = new int[] {};
    shiftZerosToTheEnd(nums);
    assertArrayEquals(new int[] {}, nums);

    nums = new int[] {0};
    shiftZerosToTheEnd(nums);
    assertArrayEquals(new int[] {0}, nums);

    nums = new int[] {1};
    shiftZerosToTheEnd(nums);
    assertArrayEquals(new int[] {1}, nums);

    nums = new int[] {0, 0, 0};
    shiftZerosToTheEnd(nums);
    assertArrayEquals(new int[] {0, 0, 0}, nums);

    nums = new int[] {1, 3, 2};
    shiftZerosToTheEnd(nums);
    assertArrayEquals(new int[] {1, 3, 2}, nums);

    nums = new int[] {1, 1, 1, 0, 0};
    shiftZerosToTheEnd(nums);
    assertArrayEquals(new int[] {1, 1, 1, 0, 0}, nums);

    nums = new int[] {0, 0, 1, 1, 1};
    shiftZerosToTheEnd(nums);
    assertArrayEquals(new int[] {1, 1, 1, 0, 0}, nums);
  }

  /**
   * Approach: Two Pointers (Unidirectional Traversal) <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(1) <br>
   */
  public static void shiftZerosToTheEnd(int[] nums) {
    for (int lastNonZeroIndex = 0, i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        int temp = nums[lastNonZeroIndex];
        nums[lastNonZeroIndex] = nums[i];
        nums[i] = temp;
        lastNonZeroIndex++;
      }
    }
  }

//  /**
//   * Approach: Brute Force <br>
//   * Time Complexity: O(n) <br>
//   * Space Complexity: O(n) <br>
//   */
//  public static void shiftZerosToTheEnd(int[] nums) {
//    int[] temp = new int[nums.length];
//    int lastNonZeroIndex = 0;
//    for (int num : nums) {
//      if (num != 0) {
//        temp[lastNonZeroIndex] = num;
//        lastNonZeroIndex++;
//      }
//    }
//    System.arraycopy(temp, 0, nums, 0, nums.length);
//  }
}

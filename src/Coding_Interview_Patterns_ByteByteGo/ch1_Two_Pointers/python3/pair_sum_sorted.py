from typing import List


'''
Approach: Two Pointers (Inward Traversal)
Time Complexity: O(n)
Space Complexity: O(1)
'''
def pair_sum_sorted(nums: List[int], target: int) -> List[int]:
    left = 0
    right = len(nums) - 1
    while left < right:
        sum = nums[left] + nums[right]
        if sum < target:
            left += 1
        elif sum > target:
            right -= 1
        else:
            return [left, right]
    return []


# '''
# Approach: Brute Force
# Time Complexity: O(n^2)
# Space Complexity: O(1)
# '''
# def pair_sum_sorted(nums: List[int], target: int) -> List[int]:
#     n = len(nums)
#     for i in range(n):
#         for j in range(i + 1, n):
#             if nums[i] + nums[j] == target:
#                 return [i, j]
#     return []
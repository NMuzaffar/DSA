# from typing import List
#
# '''
# Approach: Two Pointers (Unidirectional Traversal)
# Time Complexity: O(n)
# Space Complexity: O(1)
# '''
#
#
# def shift_zeros_to_the_end(nums: List[int]) -> None:
#   last_non_zero_index = 0
#   for i in range(len(nums)):
#     if nums[i] != 0:
#       temp = nums[last_non_zero_index]
#       nums[last_non_zero_index] = nums[i]
#       nums[i] = temp
#       last_non_zero_index += 1
#
#
# '''
# Approach: Brute Force
# Time Complexity: O(n)
# Space Complexity: O(n)
# '''
#
#
# # def shift_zeros_to_the_end(nums: List[int]) -> None:
# #   temp = [0] * len(nums)
# #   last_non_zero_index = 0
# #   for num in nums:
# #     if num != 0:
# #       temp[last_non_zero_index] = num
# #       last_non_zero_index += 1
# #   for j in range(len(nums)):
# #     nums[j] = temp[j]

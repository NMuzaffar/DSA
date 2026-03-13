# from typing import List
#
# '''
# Approach: Hash Set
# Time Complexity: O(n)
# Space Complexity: O(n)
# '''
#
#
# def longest_chain_of_consecutive_numbers(nums: List[int]) -> int:
#   if not nums:
#     return 0
#   longest = 1
#   curr_longest = 1;
#   nums_set = set()
#   for i in range(len(nums)):
#     nums_set.add(nums[i])
#   for num in nums:
#     while (num + 1) in nums_set:
#       num += 1
#       curr_longest += 1
#     longest = max(longest, curr_longest)
#     curr_longest = 1
#   return longest

from typing import List

'''
Approach: Hash Map (One Pass)
Time Complexity: O(n)
Space Complexity: O(n)
'''


def pair_sum_unsorted(nums: List[int], target: int) -> List[int]:
  nums_map = {}
  for (i, num) in enumerate(nums):
    complement = target - num
    if complement in nums_map:
      return [nums_map[complement], i]
    nums_map[num] = i
  return []


'''
Approach: Hash Map (Two Pass)
Time Complexity: O(n)
Space Complexity: O(n)
'''


# def pair_sum_unsorted(nums: List[int], target: int) -> List[int]:
#   nums_map = {}
#   for (i, num) in enumerate(nums):
#     nums_map[num] = i
#   for (i, num) in enumerate(nums):
#     complement = target - num
#     if complement in nums_map and nums_map[complement] != i:
#       return [i, nums_map[complement]]
#   return []

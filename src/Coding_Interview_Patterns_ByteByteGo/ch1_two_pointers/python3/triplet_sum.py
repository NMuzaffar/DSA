from typing import List


'''
Approach: Two Pointers (Inward Traversal)
Time Complexity: O(n^2)
Space Complexity: O(n) without output array (OR O(n^2) with output array)
'''
def triplet_sum(nums: List[int]) -> List[List[int]]:
    triplets = []
    nums.sort() # O(n * log(n))
    for i in range(len(nums)):
        # Optimization: triplets consisting of only positive numbers will never sum to 0.
        if nums[i] > 0:
            break
        # To avoid duplicate triplets, skip 'a' if it's the same as the previous number.
        if i > 0 and nums[i] == nums[i - 1]:
            continue
        pairs = pair_sum_sorted_all_pairs(nums, i + 1, -nums[i])
        for pair in pairs:
            triplets.append([nums[i], pair[0], pair[1]])
    return triplets


'''
Time Complexity: O(n)
Space Complexity: O(n)
'''
def pair_sum_sorted_all_pairs(nums: List[int], start_index: int, target: int) -> List[List[int]]:
    pairs = []
    left = start_index
    right = len(nums) - 1
    while left < right:
        sum = nums[left] + nums[right]
        if sum == target:
            pairs.append([nums[left], nums[right]])
            left += 1
            # To avoid duplicate '[b, c]' pairs, skip 'b' if it's the same as the previous number.
            while left < right and nums[left] == nums[left - 1]:
                left += 1
        elif sum < target:
            left += 1
        else:
            right -= 1
    return pairs


# '''
# Approach: Brute Force
# Time Complexity: O(n^3)
# Space Complexity: O(n)
# '''
# def triplet_sum(nums: List[int]) -> List[List[int]]:
#     triplets = set()
#     n = len(nums)
#     for i in range(n):
#         for j in range(i + 1, n):
#             for k in range(j + 1, n):
#                 if nums[i] + nums[j] + nums[k] == 0:
#                     triplet = tuple(
#                         sorted([nums[i], nums[j], nums[k]])
#                     )
#                     triplets.add(triplet)
#     return [list(triplet) for triplet in triplets]

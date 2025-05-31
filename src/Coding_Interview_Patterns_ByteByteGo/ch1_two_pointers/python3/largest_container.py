from typing import List


'''
Approach: Two Pointers (Inward Traversal)
Time Complexity: O(n)
Space Complexity: O(1)
'''
def largest_container(heights: List[int]) -> int:
    max_water = 0
    left = 0
    right = len(heights) - 1
    while left < right:
        water = min(heights[left], heights[right]) * (right - left)
        max_water = max(max_water, water)
        if heights[left] < heights[right]:
            left += 1
        elif heights[left] > heights[right]:
            right -= 1
        else:
            left += 1
            right -= 1
    return max_water


# '''
# Approach: Brute Force
# Time Complexity: O(n^2)
# Space Complexity: O(1)
# '''
# def largest_container(heights: List[int]) -> int:
#     max_water = 0
#     n = len(heights)
#     for i in range(n):
#         for j in range(i + 1, n):
#             water = min(heights[i], heights[j]) * (j - i)
#             max_water = max(max_water, water)
#     return max_water
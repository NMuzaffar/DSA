'''
Approach: Two Pointers (Inward Traversal)
Time Complexity: O(n)
Space Complexity: O(1)
'''
def is_palindrome_valid(s: str) -> bool:
    left = 0
    right = len(s) - 1
    while left < right:
        while left < right and not s[left].isalnum():
            left += 1
        while left < right and not s[right].isalnum():
            right -= 1
        if s[left] != s[right]:
            return False
        left += 1
        right -= 1
    return True
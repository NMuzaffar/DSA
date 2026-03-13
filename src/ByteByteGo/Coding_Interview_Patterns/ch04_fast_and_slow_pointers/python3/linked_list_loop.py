"""
Definition of ListNode
"""


class ListNode:
  def __init__(self, val=None, next=None):
    self.val = val
    self.next = next


'''
Approach: Floyd's Cycle Detection (Fast & Slow Pointers)
Time Complexity: O(n)
Space Complexity: O(1)
'''


def linked_list_loop(head: ListNode) -> bool:
  slow = fast = head
  # Check both 'fast' and 'fast.next' to avoid null pointer
  # exceptions when we perform 'fast.next' and 'fast.next.next'.
  while fast and fast.next:
    slow = slow.next
    fast = fast.next.next
    if slow == fast:
      return True
  return False


'''
Approach: Hash Set
Time Complexity: O(n)
Space Complexity: O(n)
'''


# def linked_list_loop(head: ListNode) -> bool:
#   visited = set()
#   curr = head
#   while curr:
#     # Cycle detected if the current node has already been visited.
#     if curr in visited:
#       return True
#     visited.add(curr)
#     curr = curr.next
#   return False

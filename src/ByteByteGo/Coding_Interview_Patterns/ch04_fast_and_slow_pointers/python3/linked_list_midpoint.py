"""
Definition of ListNode
"""


class ListNode:
  def __init__(self, val=None, next=None):
    self.val = val
    self.next = next


'''
Approach: Fast & Slow Pointers
Time Complexity: O(n)
Space Complexity: O(1)
'''


def linked_list_midpoint(head: ListNode) -> ListNode:
  slow = fast = head
  # When the fast pointer reaches the end of the list, the slow
  # pointer will be at the midpoint of the linked list.
  while fast and fast.next:
    slow = slow.next
    fast = fast.next.next
  return slow

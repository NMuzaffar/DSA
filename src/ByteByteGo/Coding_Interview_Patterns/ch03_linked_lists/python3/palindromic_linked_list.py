"""
Definition of ListNode
"""


class ListNode:
  def __init__(self, val=None, next=None):
    self.val = val
    self.next = next


'''
Approach:
Time Complexity: O()
Space Complexity: O()
'''


def palindromic_linked_list(head: ListNode) -> bool:
  mid = linked_list_midpoint(head)

  pass


'''
Time Complexity: O(n)
Space Complexity: O(1)
'''


def linked_list_midpoint(head: ListNode) -> ListNode:
  slow = head
  fast = head
  while fast and fast.next:
    slow = slow.next
    fast = fast.next.next
  return slow

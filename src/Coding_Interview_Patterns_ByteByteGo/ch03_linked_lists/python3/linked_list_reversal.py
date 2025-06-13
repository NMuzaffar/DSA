"""
Definition of ListNode
"""


class ListNode:
  def __init__(self, val=None, next=None):
    self.val = val
    self.next = next


'''
Approach: Recursive
Time Complexity: O(n)
Space Complexity: O(n)
'''


def linked_list_reversal(head: ListNode) -> ListNode:
  if (not head) or (not head.next):
    return head
  new_head = linked_list_reversal(head.next)
  head.next.next = head
  head.next = None
  return new_head


'''
Approach: Iterative
Time Complexity: O(n)
Space Complexity: O(1)
'''


# def linked_list_reversal(head: ListNode) -> ListNode:
#   curr_node = head
#   prev_node = None
#   while curr_node:
#     next_node = curr_node.next
#     curr_node.next = prev_node
#     prev_node = curr_node
#     curr_node = next_node
#   return prev_node

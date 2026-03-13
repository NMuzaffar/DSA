"""
Definition of ListNode
"""


class ListNode:
  def __init__(self, val=None, next=None):
    self.val = val
    self.next = next


'''
Approach: Two Pointers
Time Complexity: O(n)
Space Complexity: O(1)
'''


def remove_kth_last_node(head: ListNode, k: int) -> ListNode:
  # A dummy node to ensure there's a node before 'head' in case we
  # need to remove the head node.
  sentinel = ListNode(-1)
  sentinel.next = head
  trailer = leader = sentinel
  # Advance 'leader' k steps ahead.
  for _ in range(k):
    leader = leader.next
    # If k is larger than the length of the linked list, no node
    # needs to be removed.
    if not leader:
      return head
  # Move 'leader' to the end of the linked list, keeping 'trailer'
  # k nodes behind.
  while leader.next:
    leader = leader.next
    trailer = trailer.next
  # Remove the kth node from the end.
  trailer.next = trailer.next.next
  return sentinel.next

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


def linked_list_intersection(head_A: ListNode, head_B: ListNode) -> ListNode:
  pass

n8 = ListNode(8)
n7 = ListNode(7)
n8.next = n7
n2 = ListNode(2)
n7.next = n2

# A
n1 = ListNode(1)
n3 = ListNode(3)
n1.next = n3
n4_a = ListNode(4)
n3.next = n4_a
n4_a.next = n8

# B
n6 = ListNode(6)
n4_b = ListNode(4)
n6.next = n4_b
n4_b.next = n8


print(linked_list_intersection(n1, n6).val)


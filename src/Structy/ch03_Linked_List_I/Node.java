package Structy.ch03_Linked_List_I;

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 */
public class Node<T> {

  public T val;
  public Node<T> next;

  public Node() {}

  public Node(T val) {
    this.val = val;
  }

  public Node(T val, Node<T> next) {
    this.val = val;
    this.next = next;
  }

  public static <T> Node<T> fromArray(T[] values) {
    return fromArray(values, -1);
  }

  /**
   * Creates a linked list from an array.
   * If pos >= 0, it connects the last node to the node at index 'pos' to create a cycle.
   *
   * @param values array of integers to convert to a linked list
   * @param pos the index of the node the last node should link to (-1 means no cycle)
   * @return head of the linked list
   */
  public static <T> Node<T> fromArray(T[] values, int pos) {
    if (values == null || values.length == 0) {
      return null;
    }
    Node<T> head = new Node<>(values[0]);
    Node<T> current = head;
    Node<T> cycleEntry = null;
    if (pos == 0) {
      cycleEntry = head;
    }
    for (int i = 1; i < values.length; i++) {
      current.next = new Node<>(values[i]);
      current = current.next;
      if (i == pos) {
        cycleEntry = current;
      }
    }
    if (pos >= 0) {
      current.next = cycleEntry;
    }
    return head;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Node<T> a = this;
    Node<T> b = (Node<T>) obj;
    Set<Node<T>> visitedA = new HashSet<>();
    Set<Node<T>> visitedB = new HashSet<>();
    while (a != null && b != null) {
      if (a.val != b.val) return false;
      if (!visitedA.add(a) || !visitedB.add(b)) {
        // If we've seen either node before, assume we entered a cycle.
        // If both nodes are the same object, the cycle is equivalent.
        return a == b;
      }

      a = a.next;
      b = b.next;
    }
    return a == null && b == null;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    Set<Node<T>> visited = new HashSet<>();
    Node<T> current = this;
    while (current != null) {
      if (!visited.add(current)) {
        sb.append(" -> (cycle to ").append(current.val).append(")");
        break;
      }
      if (!sb.isEmpty()) {
        sb.append(" -> ");
      }
      sb.append(current.val);
      current = current.next;
    }
    return sb.toString();
  }
}

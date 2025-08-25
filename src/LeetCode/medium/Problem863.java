package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

import LeetCode.common.TreeNode;
import java.util.*;

/**
 * <a href="https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/">863. All Nodes Distance K in Binary Tree</a>
 */
public class Problem863 {

  public static void main(String[] args) {
    TreeNode root = TreeNode.buildTree(new Integer[] {3,5,1,6,2,0,8,null,null,7,4});
    assertTrue(distanceK(root, root.left, 2).containsAll(List.of(7,4,1)));

    root = TreeNode.buildTree(new Integer[] {1});
    assertTrue(distanceK(root, root, 2).containsAll(List.of()));
  }

  /**
   * Approach: Graph BFS <br>
   * Time Complexity: O(n) <br>
   * Space Complexity: O(n) <br>
   */
  public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    Map<TreeNode, TreeNode> nodeParents = new HashMap<>();
    buildTreeNodeParents(root, null, nodeParents);
    Queue<TreeNode> queue = new LinkedList<>();
    Set<TreeNode> visited = new HashSet<>();
    queue.offer(target);
    visited.add(target);
    int distance = 0;
    while(!queue.isEmpty() && distance < k) {
      int currLength = queue.size();
      for (int i = 0; i < currLength; i++) {
        TreeNode node = queue.poll();
        for (TreeNode neighbor : new TreeNode[] {node.left, node.right, nodeParents.get(node)}) {
          if (neighbor != null && !visited.contains(neighbor)) {
            visited.add(neighbor);
            queue.offer(neighbor);
          }
        }
      }
      distance++;
    }
    List<Integer> ans = new ArrayList<>();
    for (TreeNode node : queue) {
      ans.add(node.val);
    }
    return ans;
  }

  private static void buildTreeNodeParents(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> nodeParents) {
    if (node == null) {
      return;
    }
    nodeParents.put(node, parent);
    buildTreeNodeParents(node.left, node, nodeParents);
    buildTreeNodeParents(node.right, node, nodeParents);
  }
}
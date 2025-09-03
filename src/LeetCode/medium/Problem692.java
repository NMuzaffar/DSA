package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/top-k-frequent-words/">692. Top K Frequent Words</a>
 */
public class Problem692 {

  public static void main(String[] args) {
    assertEquals(List.of("i","love"), topKFrequent(new String[] {"i","love","leetcode","i","love","coding"}, 2));
    assertEquals(List.of("the","is","sunny","day"), topKFrequent(new String[] {"the","day","is","sunny","the","the","the","sunny","is","is"}, 4));
  }

  /**
   * Approach: Heap (Priority Queue) <br>
   * Time Complexity: O(n * log(k)) <br>
   * Space Complexity: O(n) <br>
   */
  public static List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> wordCounts = new HashMap<>();
    for (String word : words) {
      wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
    }
    PriorityQueue<String> minHeap = new PriorityQueue<>(
        (w1, w2) -> wordCounts.get(w1).equals(wordCounts.get(w2))
            ? w2.compareTo(w1)
            : Integer.compare(wordCounts.get(w1), wordCounts.get(w2)));
    for (String word : wordCounts.keySet()) {
      minHeap.add(word);
      if (minHeap.size() > k) {
        minHeap.remove();
      }
    }
    List<String> ans = new ArrayList<>();
    while (!minHeap.isEmpty()) {
      ans.add(minHeap.remove());
    }
    Collections.reverse(ans);
    return ans;
  }
}

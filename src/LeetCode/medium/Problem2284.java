package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/sender-with-largest-word-count/">2284. Sender With Largest Word Count</a>
 */
public class Problem2284 {

  public static void main(String[] args) {
    assertEquals("Alice",
        largestWordCount(
            new String[] {"Hello userTwooo","Hi userThree","Wonderful day Alice","Nice day userThree"},
            new String[] {"Alice","userTwo","userThree","Alice"}));

    assertEquals("Charlie",
        largestWordCount(
            new String[] {"How is leetcode for everyone","Leetcode is useful for practice"},
            new String[] {"Bob","Charlie"}));
  }

  /**
   * Approach: Counting <br>
   * Time Complexity: O(n * m) <-> 'm' = average length of a message string <br>
   * Space Complexity: O(n + m) <br>
   */
  public static String largestWordCount(String[] messages, String[] senders) {
    String largestSender = "";
    int maxWordCount = 0;
    Map<String, Integer> wordCounts = new HashMap<>();
    for (int i = 0; i < messages.length; i++) {
      String sender = senders[i];
      int wordCount = messages[i].split(" ").length;
      int totalWordCount = wordCounts.getOrDefault(sender, 0) + wordCount;
      wordCounts.put(sender, totalWordCount);
      if (totalWordCount > maxWordCount || (totalWordCount == maxWordCount && sender.compareTo(largestSender) > 0)) {
        maxWordCount = totalWordCount;
        largestSender = sender;
      }
    }
    return largestSender;
  }
}

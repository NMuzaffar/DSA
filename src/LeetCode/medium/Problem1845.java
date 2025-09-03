package LeetCode.medium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/seat-reservation-manager/">1845. Seat Reservation Manager</a>
 */
public class Problem1845 {

  public static void main(String[] args) {
    SeatManager seatManager1 = new SeatManager(5); // Initializes a SeatManager with 5 seats.
    assertEquals(1, seatManager1.reserve());    // All seats are available, so return the lowest numbered seat, which is 1.
    seatManager1.reserve();    // The available seats are [2,3,4,5], so return the lowest of them, which is 2.
    seatManager1.unreserve(2); // Unreserve seat 2, so now the available seats are [2,3,4,5].
    assertEquals(2, seatManager1.reserve());    // The available seats are [2,3,4,5], so return the lowest of them, which is 2.
    assertEquals(3, seatManager1.reserve());    // The available seats are [3,4,5], so return the lowest of them, which is 3.
    assertEquals(4, seatManager1.reserve());    // The available seats are [4,5], so return the lowest of them, which is 4.
    assertEquals(5, seatManager1.reserve());    // The only available seat is seat 5, so return 5.
    seatManager1.unreserve(5); // Unreserve seat 5, so now the available seats are [5].

    SeatManager seatManager2 = new SeatManager(4);
    assertEquals(1, seatManager2.reserve());
    seatManager2.unreserve(1);
    assertEquals(1, seatManager2.reserve());
    assertEquals(2, seatManager2.reserve());
    assertEquals(3, seatManager2.reserve());
    seatManager2.unreserve(2);
    assertEquals(2, seatManager2.reserve());
    seatManager2.unreserve(1);
    assertEquals(1, seatManager2.reserve());
    seatManager2.unreserve(2);
  }

  /**
   * Your SeatManager object will be instantiated and called as such:
   * SeatManager obj = new SeatManager(n);
   * int param_1 = obj.reserve();
   * obj.unreserve(seatNumber);
   */
  static class SeatManager {
    private final PriorityQueue<Integer> minHeap;
    private int markerSeat;

    /**
     * Approach: Heap (Priority Queue) <br>
     * Time Complexity: O(m * log(n)) <br>
     * Space Complexity: O(n) <br>
     */
    public SeatManager(int n) {
      this.minHeap = new PriorityQueue<>();
      this.markerSeat = 1;
    }

    public int reserve() {
      if (minHeap.isEmpty()) {
        return markerSeat++;
      } else {
        return minHeap.remove();
      }
    }

    public void unreserve(int seatNumber) {
      minHeap.add(seatNumber);
    }
  }
}

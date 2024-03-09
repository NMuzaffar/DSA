import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearch(IntStream.rangeClosed(1, 100).boxed().toList(), 57)); // => 56
        System.out.println(binarySearch(new ArrayList<>(List.of(1, 3, 5, 7, 9)), 3)); // => 1
        System.out.println(binarySearch(new ArrayList<>(List.of(1, 3, 5, 7, 9)), -1)); // => -1
        System.out.println(binarySearch(new ArrayList<>(), -1)); // => -1
    }

    /**
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static int binarySearch(List<Integer> arr, Integer item) {
        if (arr.isEmpty()) {
            return -1;
        }

        int low = 0;
        int high = arr.size() - 1;
    
        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = arr.get(mid);
    
            if (guess == item) {
                return mid;
            } else if (guess > item) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}

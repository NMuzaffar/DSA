import java.util.Arrays;

// Use raw arrays instead of ArrayList
public class SelectionSort2 {
    public static void main(String[] args) {
        int[] arr = new int[] {5, 3, 6, 2, 10};
        System.out.println("Before Sorting: " + Arrays.toString(arr));

        selectionSort(arr);
        System.out.println("After Sorting: " + Arrays.toString(arr)); // [2, 3, 5, 6, 10]
    }

    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}

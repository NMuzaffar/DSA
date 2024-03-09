package main.ch2_selection_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectionSort {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(5, 3, 6, 2, 10));
        System.out.println(selectionSort(arr)); //[2, 3, 5, 6, 10]
        }   

    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     */
    public static List<Integer> selectionSort(List<Integer> arr) {
        List<Integer> result = new ArrayList<>(arr.size());

        int n = arr.size();
        for (int i = 0; i < n; i++) {
            int smallest = findSmallest(arr);
            result.add(arr.get(smallest));

            arr.remove(smallest);
        }

        return result;
    }

    private static int findSmallest(List<Integer> arr) {
        int smallest = arr.get(0);
        int smallestIndex = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) < smallest) {
                smallest = arr.get(i);
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }
}

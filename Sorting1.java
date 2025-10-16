/**
 * This class demonstrates the Bubble Sort algorithm for sorting an array of integers.
 * Bubble Sort is a simple sorting algorithm that repeatedly steps through the list,
 * compares adjacent elements and swaps them if they are in the wrong order.
 * The pass through the list is repeated until no swaps are needed, which indicates
 * that the list is sorted.
 */
public class BubbleSort { // Changed from BubbleSort() to BubbleSort as it's a class declaration.
    /**
     * The main method serves as the entry point for the program.
     * It initializes an integer array, prints its initial state,
     * sorts it using the bubble sort algorithm, and then prints its sorted state.
     * @param args Command line arguments (not used in this program).
     */
    public static void main(String[] args) {
        // Initialize an array of integers with unsorted values.
        int[] arr = { 38, 27, 43, 3, 9, 82, 10 };

        // Print the array before sorting to show its initial state.
        System.out.println("Array before sorting:");
        printArray(arr);

        // Call the sort method to apply the Bubble Sort algorithm to the array.
        sort(arr);

        // Print the array after sorting to show its final sorted state.
        System.out.println("Array after sorting:");
        printArray(arr);
    }

    /**
     * Helper method to print the elements of an integer array to the console.
     * Each element is followed by a space, and a new line is printed at the end.
     * @param arr The integer array to be printed.
     */
    private static void printArray(int[] arr) {
        // Iterate through each element in the array using an enhanced for loop.
        for (int num : arr) {
            System.out.print(num + " "); // Print the current number followed by a space.
        }
        System.out.println(); // Print a new line after all elements have been printed.
    }

    /**
     * Sorts an array of integers using the Bubble Sort algorithm.
     * This implementation includes an optimization to stop early if the array is already sorted
     * (i.e., no swaps occur in a pass).
     * @param nums The integer array to be sorted in ascending order.
     */
    private static void sort(int[] nums) {
        int n = nums.length; // Get the total number of elements in the array.

        // Outer loop: This loop controls the number of passes.
        // In each pass, the largest unsorted element "bubbles up" to its correct position.
        // After 'i' passes, the last 'i' elements are guaranteed to be in their final sorted positions.
        for (int i = 0; i < n; i++) {
            boolean flag = true; // A flag to detect if any swaps occurred in the current pass.
                                 // If no swaps occur, the array is sorted, and we can stop early.

            // Inner loop: This loop performs comparisons and swaps for the current pass.
            // It iterates from the first element up to the last unsorted element.
            // The `n - 1 - i` limit ensures we don't compare elements that are already sorted
            // and prevents an `ArrayIndexOutOfBoundsException` when accessing `nums[j+1]`.
            for (int j = 0; j < n - 1 - i; j++) {
                // Compare adjacent elements.
                if (nums[j + 1] < nums[j]) {
                    // If the element on the right is smaller than the element on the left, swap them.
                    int temp = nums[j + 1]; // Store the value of the right element in a temporary variable.
                    nums[j + 1] = nums[j]; // Move the value of the left element to the right position.
                    nums[j] = temp;        // Move the stored value (original right element) to the left position.
                    flag = false;          // A swap occurred, so set the flag to false.
                }
            }

            // Optimization: If no swaps occurred in the entire inner loop (current pass),
            // it means the array is already sorted, so we can break out of the outer loop.
            if (flag) {
                break;
            }
        }
    }
}
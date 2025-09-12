/**
 * The Sort class demonstrates the Merge Sort algorithm.
 * It contains methods for sorting an array of integers and printing its contents.
 */
public class Sort {

    /**
     * The main method is the entry point of the program.
     * It initializes an integer array, prints it, sorts it using merge sort,
     * and then prints the sorted array.
     *
     * @param args Command line arguments (not used in this program).
     */
    public static void main(String[] args) {
        // Initialize an integer array with unsorted elements.
        int[] arr = {38, 27, 43, 3, 9, 82, 10};

        // Print the array before sorting to show its initial state.
        System.out.print("Original array: ");
        printArray(arr);

        // Call the mergeSort method to sort the array.
        // The sorting is applied to the entire array, from index 0 to arr.length - 1.
        mergeSort(arr, 0, arr.length - 1);

        // Print the array after sorting to show its final sorted state.
        System.out.print("Sorted array: ");
        printArray(arr);
    }

    /**
     * Implements the Merge Sort algorithm recursively.
     * It divides the array into two halves, recursively sorts them,
     * and then merges the sorted halves.
     *
     * @param arr   The array to be sorted.
     * @param left  The starting index of the subarray to be sorted.
     * @param right The ending index of the subarray to be sorted.
     */
    public static void mergeSort(int[] arr, int left, int right) {
        // Base case: if left is less than right, there are at least two elements
        // or more to sort. If left >= right, the subarray has 0 or 1 element, which is already sorted.
        if (left < right) {
            // Calculate the middle point of the array to divide it into two halves.
            // This prevents potential overflow that (left + right) / 2 might cause for very large left/right.
            int mid = left + (right - left) / 2;

            // Recursively sort the first half of the array.
            mergeSort(arr, left, mid);
            // Recursively sort the second half of the array.
            mergeSort(arr, mid + 1, right);

            // Merge the two sorted halves back into a single sorted subarray.
            merge(arr, left, mid, right);
        }
    }

    /**
     * Merges two sorted subarrays into one sorted array.
     * This is a key step in the Merge Sort algorithm.
     * The two subarrays are arr[left...mid] and arr[mid+1...right].
     *
     * @param arr   The main array containing the subarrays to be merged.
     * @param left  The starting index of the first subarray.
     * @param mid   The middle index, also the end of the first subarray.
     *              The second subarray starts at mid + 1.
     * @param right The ending index of the second subarray.
     */
    public static void merge(int[] arr, int left, int mid, int right) {
        // Calculate the sizes of the two temporary arrays needed for merging.
        int n1 = mid - left + 1; // Size of the left subarray.
        int n2 = right - mid;    // Size of the right subarray.

        // Create two temporary arrays to hold the left and right subarrays.
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data from the original array into the left temporary array.
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        // Copy data from the original array into the right temporary array.
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        // Initialize indices for the temporary arrays (i, j) and for the merged array (k).
        int i = 0, j = 0;
        int k = left; // Starting index for placing merged elements back into the original array.

        // Merge the temporary arrays back into the original array (arr[left...right]).
        // Compare elements from L and R and place the smaller one into arr.
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++]; // Take from L if L's element is smaller or equal.
            } else {
                arr[k++] = R[j++]; // Take from R if R's element is smaller.
            }
        }

        // Copy any remaining elements of L[] (if any) into arr.
        while (i < n1) {
            arr[k++] = L[i++];
        }

        // Copy any remaining elements of R[] (if any) into arr.
        while (j < n2) {
            arr[k++] = R[j++];
        }
    }

    /**
     * Prints the elements of an integer array to the console,
     * separated by spaces, followed by a newline.
     *
     * @param arr The array whose elements are to be printed.
     */
    public static void printArray(int[] arr) {
        // Iterate through each element of the array.
        for (int num : arr) {
            System.out.print(num + " "); // Print the number followed by a space.
        }
        System.out.println(); // Print a newline character to move to the next line.
    }
}
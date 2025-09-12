import java.util.Scanner;

/**
 * This class provides functionality to reverse an array of integers
 * entered by the user and then print the reversed array.
 */
public class ReverseArray {

    /**
     * The main method is the entry point of the program.
     * It reads an array of integers from the console, reverses it,
     * and then prints the reversed array.
     *
     * @param args Command line arguments (not used in this program).
     */
    public static void main(String[] args) {
        // Create a Scanner object to read input from the console.
        Scanner in = new Scanner(System.in);

        // Read the size of the array from the user.
        int n = in.nextInt();

        // Declare and initialize an integer array of the specified size.
        int arr[] = new int[n];

        // Loop to read 'n' integer elements from the user and populate the array.
        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        
        // Initialize two pointers: 'left' at the beginning and 'right' at the end of the array.
        int left =  0, right = n - 1;

        // Loop to reverse the array using a two-pointer approach.
        // It continues as long as the left pointer is less than the right pointer.
        while(left < right){
            // Swap the elements at the 'left' and 'right' positions.
            // 1. Store the element at 'left' in a temporary variable.
            int temp = arr[left];
            // 2. Assign the element at 'right' to the 'left' position.
            arr[left] = arr[right];
            // 3. Assign the stored temporary element (original 'left' element) to the 'right' position.
            arr[right] = temp;

            // Move the 'left' pointer one step to the right.
            left++;
            // Move the 'right' pointer one step to the left.
            right--;
        }

        // Call the printArray method to display the contents of the reversed array.
        printArray(arr);

        // Close the scanner to release system resources.
        in.close();
    }

    /**
     * A utility method to print all elements of an integer array to the console,
     * separated by spaces.
     *
     * @param arr The integer array to be printed.
     */
    private static void printArray(int arr[]){
        // Iterate through each element of the array.
        for(int i = 0; i < arr.length; i++) {
            // Print the current element followed by a space.
            System.out.print(arr[i] + " ");
        }
        // Print a new line character at the end for better formatting.
        System.out.println();
    }
}
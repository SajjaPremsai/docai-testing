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

        // Read the size of the array from the user's input.
        int n = in.nextInt();

        // Declare and initialize an integer array named 'arr' with the specified size 'n'.
        int arr[] = new int[n];

        // Loop to read 'n' integer elements from the user and populate the array 'arr'.
        for(int i = 0; i < n; i++) {
            // Assign the integer read from the console to the current position 'i' in the array.
            arr[i] = in.nextInt();
        }
        
        // Initialize two pointers for the reversal process:
        // 'left' pointer starts at the beginning of the array (index 0).
        // 'right' pointer starts at the end of the array (index n - 1).
        int left =  0, right = n - 1;

        // Loop to reverse the array using a two-pointer approach.
        // The loop continues as long as the 'left' pointer is less than the 'right' pointer,
        // ensuring elements are swapped from the outside inwards.
        while(left < right){
            // Perform a swap operation between the elements at 'left' and 'right' positions.
            // 1. Store the element at the 'left' position in a temporary variable.
            int temp = arr[left];
            // 2. Assign the element at the 'right' position to the 'left' position.
            arr[left] = arr[right];
            // 3. Assign the value from the temporary variable (original 'left' element) to the 'right' position.
            arr[right] = temp;

            // Move the 'left' pointer one step to the right to process the next element from the start.
            left++;
            // Move the 'right' pointer one step to the left to process the next element from the end.
            right--;
        }

        // Call the 'printArray' method to display the contents of the now reversed array.
        printArray(arr);

        // Close the Scanner object to release system resources associated with it.
        in.close();
    }

    /**
     * A utility method to print all elements of an integer array to the console,
     * separated by spaces, followed by a newline at the end.
     *
     * @param arr The integer array whose elements are to be printed.
     */
    private static void printArray(int arr[]){
        // Iterate through each element of the array from the first to the last.
        for(int i = 0; i < arr.length; i++) {
            // Print the current element followed by a space.
            // Using System.out.print() keeps all elements on the same line.
            System.out.print(arr[i] + " ");
        }
        // After printing all elements, print a new line character.
        // This ensures that any subsequent output appears on a fresh line.
        System.out.println();
    }
}
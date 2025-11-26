import java.util.Scanner; // Import the Scanner class to read input from the console.

/**
 * The Searching class demonstrates a simple linear search algorithm.
 * It reads an array of integers from the user, then reads an element to search for,
 * and prints the index of the element if found, or "Not Found" otherwise.
 */
public class Searching {

    /**
     * The main method is the entry point of the program.
     * It orchestrates the input reading, search operation, and output.
     * @param args Command line arguments (not used in this program).
     */
    public static void main(String[] args) {
        // Create a Scanner object to read input from the standard input (keyboard).
        Scanner in = new Scanner(System.in);

        // Prompt the user to enter the number of elements for the array.
        // Read the number of elements the user wants in the array.
        int n = in.nextInt();

        // Declare and initialize an integer array of size 'n' to store the elements.
        int arr[] = new int[n];

        // Loop to read 'n' integer elements from the user and populate the array.
        // Each integer entered by the user will be stored sequentially in the array.
        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        
        // Prompt the user to enter the element to search for.
        // Read the integer element that needs to be searched within the array.
        int ele = in.nextInt();

        // Perform a linear search: Iterate through each element of the array from the beginning to the end.
        for(int i = 0; i < n; i++){
            // Check if the current array element at index 'i' matches the element to be searched.
            if(arr[i] == ele){
                // If a match is found, print its index to the console.
                System.out.println(i);
                // Terminate the program immediately as the element has been found.
                // This prevents further execution of the loop and ensures the "Not Found" message is not printed.
                System.exit(0);
            }
        }
        // If the loop completes without finding the element (i.e., System.exit(0) was not called),
        // it means the element is not present in the array.
        // Print "Not Found" to indicate that the search element was not found in the array.
        System.out.println("Not Found");

        // Close the scanner to release system resources associated with it.
        in.close();
    }
}
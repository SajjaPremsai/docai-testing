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

        // Read the number of elements the user wants in the array.
        int n = in.nextInt();

        // Declare and initialize an integer array of size 'n'.
        int arr[] = new int[n];

        // Loop to read 'n' integer elements from the user and populate the array.
        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        
        // Read the integer element that needs to be searched within the array.
        int ele = in.nextInt();

        // Perform a linear search: Iterate through each element of the array.
        for(int i = 0; i < n; i++){
            // Check if the current array element matches the element to be searched.
            if(arr[i] == ele){
                // If a match is found, print its index.
                System.out.println(i);
                // Terminate the program immediately as the element has been found.
                // This prevents further execution and the "Not Found" message.
                System.exit(0);
            }
        }
        // If the loop completes without finding the element (i.e., System.exit(0) was not called),
        // it means the element is not present in the array.
        System.out.println("Not Found");

        // Close the scanner to release system resources.
        in.close();
    }
}
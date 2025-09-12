import java.util.Scanner; // Imports the Scanner class, which is used to read input from the console.

/**
 * The Search class demonstrates a simple linear search algorithm.
 * It reads an array of integers from the user, then reads an element to search for,
 * and prints the index of the element if found, or "Not Found" otherwise.
 */
public class Search {
    /**
     * The main method is the entry point of the program.
     * It orchestrates the input reading, array population, searching, and output.
     * @param args Command line arguments (not used in this program).
     */
    public static void main(String[] args) {
        // Create a Scanner object to read input from the standard input (keyboard).
        Scanner in = new Scanner(System.in);

        // Read the number of elements (n) for the array from the user.
        // This 'n' determines the size of the integer array to be created.
        int n = in.nextInt();

        // Declare and initialize an integer array of size 'n'.
        // This array will store the integers provided by the user.
        int arr[] = new int[n];

        // Loop to read 'n' integer elements from the user and populate the array.
        // The loop iterates 'n' times, reading one integer in each iteration.
        for(int i = 0; i < n; i++) {
            // Assign the integer read from the console to the current index 'i' of the array.
            arr[i] = in.nextInt();
        }
        
        // Read the element (ele) that needs to be searched in the array.
        // This is the target value we are looking for within 'arr'.
        int ele = in.nextInt();

        // Close the scanner to prevent resource leaks.
        // It's good practice to close input streams when they are no longer needed.
        in.close();

        // Perform a linear search: Iterate through each element of the array from start to end.
        // The loop variable 'i' represents the current index being checked.
        for(int i = 0; i < n; i++){
            // Check if the current array element at index 'i' matches the element to be searched ('ele').
            if(arr[i] == ele){
                // If a match is found, print its index 'i'.
                System.out.println(i);
                // Terminate the program immediately as the element has been found.
                // This prevents further execution and the "Not Found" message from being printed.
                System.exit(0); 
            }
        }
        // If the loop completes without finding the element (i.e., System.exit(0) was not called),
        // it means the element is not present in the array.
        // In this case, print "Not Found" to indicate the search was unsuccessful.
        System.out.println("Not Found");
    }
}
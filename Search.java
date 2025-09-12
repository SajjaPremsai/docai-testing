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
        // This object will be used to capture user input for array size, array elements, and the search element.
        Scanner in = new Scanner(System.in);

        // Read the number of elements (n) for the array from the user.
        // This 'n' determines the size of the integer array to be created dynamically.
        // For example, if the user enters 5, an array of 5 integers will be created.
        int n = in.nextInt();

        // Declare and initialize an integer array of size 'n'.
        // This array, named 'arr', will store the 'n' integers subsequently provided by the user.
        int arr[] = new int[n];

        // Loop to read 'n' integer elements from the user and populate the array.
        // The loop iterates 'n' times, from index 0 up to n-1, reading one integer in each iteration.
        for(int i = 0; i < n; i++) {
            // Assign the integer read from the console to the current index 'i' of the array.
            // This populates the array with user-specified values.
            arr[i] = in.nextInt();
        }
        
        // Read the element (ele) that needs to be searched within the array.
        // This is the target value we are looking for within the 'arr' array.
        int ele = in.nextInt();

        // Close the scanner to prevent resource leaks.
        // It's crucial to close input streams when they are no longer needed to release system resources.
        in.close();

        // Perform a linear search: Iterate through each element of the array from start to end.
        // The loop variable 'i' represents the current index being checked in the array.
        for(int i = 0; i < n; i++){
            // Check if the current array element at index 'i' matches the element to be searched ('ele').
            // This is the core comparison step of the linear search algorithm.
            if(arr[i] == ele){
                // If a match is found, print its index 'i'.
                // The index indicates the position of the first occurrence of the element in the array.
                System.out.println(i);
                // Terminate the program immediately as the element has been found.
                // This prevents further execution of the loop and ensures that "Not Found" is not printed
                // if the element was indeed found. It also signifies a successful search completion.
                System.exit(0); 
            }
        }
        // If the loop completes without finding the element (i.e., System.exit(0) was not called),
        // it means the element is not present anywhere in the array.
        // In this case, print "Not Found" to indicate that the search was unsuccessful.
        System.out.println("Not Found");
    }
}
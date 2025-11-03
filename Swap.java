/**
 * The `Swap` class provides utility methods for performing element swaps.
 * This particular class focuses on swapping elements within an integer array.
 */
class Swap {
  /**
   * Swaps two elements in an integer array at specified indices.
   * This method performs an in-place swap, modifying the array directly.
   *
   * @param arr The integer array in which elements are to be swapped.
   *            It is assumed that `arr` is not null.
   * @param i   The index of the first element to be swapped.
   *            It is assumed that `i` is a valid index within the bounds of `arr`.
   * @param j   The index of the second element to be swapped.
   *            It is assumed that `j` is a valid index within the bounds of `arr`.
   */
  private void swap(int arr[], int i, int j) {
    // Store the value of the element at index 'i' in a temporary variable.
    int temp = arr[i];
    // Assign the value of the element at index 'j' to the position of index 'i'.
    arr[i] = arr[j];
    // Assign the value stored in the temporary variable (original value of arr[i])
    // to the position of index 'j', completing the swap.
    arr[j] = temp;
  }
}
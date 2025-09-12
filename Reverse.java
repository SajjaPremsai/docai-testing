import java.util.Scanner;
public class ReverseArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = in.nextInt();
        
        int left =  0, right = n-1;
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        printArray(arr);
    }
    private static void printArray(int arr[]){
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}

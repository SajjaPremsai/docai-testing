import java.util.Scanner;

public class Searching {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = in.nextInt();
        
        int ele = in.nextInt();

        for(int i = 0; i < n; i++){
            if(arr[i] == ele){
                System.out.println(i);
                System.exit(0);
            }
        }
        System.out.println("Not Found");
    }
}

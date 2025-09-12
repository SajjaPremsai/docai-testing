import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int left = 0, right = str.length()-1;
        while(left < right){
            char ch = str.charAt(left);
            char ch1 = str.charAt(right);
            if(ch1 == ch){
                left++;
                right--;
            }
            else{ System.err.println("Not Palindrome"); return; }
        }
        System.err.println("Palindrome");
    }
}

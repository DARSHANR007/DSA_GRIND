import java.util.*;

public class Main {

    public static String helper(int[] arr) {
        int n =arr.length;
        int place[] = new int[n + 1];
        for (int i = 0;i <n; i++) 
        {
         place[arr[i]] =i;
  }
        for (int i = 1; i < n; i++) {
            if (place[i]>place[i+ 1]) {
                return "nO";
     }
   }
        return "yes";
 }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        while (t--> 0) {
            int n= sc.nextInt();
            int[] arr =new int[n];
            for (int i =0;i < n;i++) {
                arr[i] =sc.nextInt();
            }
            System.out.println(helper(arr));
        }
        sc.close();
 }
}

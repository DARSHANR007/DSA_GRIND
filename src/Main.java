import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();


        while (t-->0) {
            int n =sc.nextInt();



            int[] rotate = new int[n];
            for (int i =0;i<n;i++) {
                rotate[i] = sc.nextInt();

            }
            int maxEat = 0;

            for (int start = 0; start < n; start++) {
                int[] dp =new int[n];
                dp[start] =1;
                for (int i= 1;i< n;i++) {

                    int curr = (start + i) % n;

                    for(int j =0;j< i;j++) {

                        int prev = (start + j) % n;
                        if (rotate[curr] > rotate[prev]){

                            dp[curr] = Math.max(dp[curr], dp[prev] + 1);

                        }
                    }
                    maxEat = Math.max(maxEat, dp[curr]);
                }
                maxEat = Math.max(maxEat, dp[start]);
            }
            System.out.println(maxEat);
        }
    }
}

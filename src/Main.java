import java.util.*;

public class Main {
    public static void main(String[] args)
    
    
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t--> 0) 
        
        {
            int n = sc.nextInt();
            long[] a = new long[n];
            for(int i = 0; i < n; i++)
                a[i] = sc.nextLong();

            long[] dp =new long[n];
            dp[0] = 0;

            for(int i = 1; i < n; i++) {
                dp[i] =Long.MAX_VALUE;
                long maxi = 0;
                for(int j =0;j <i; j++)
                    maxi =Math.max(maxi,a[j]);

                Set<Long> arr = new HashSet<>();
                arr.add(a[i]);
                for(int j = 0; j < i;j++)
                    arr.add(a[j]);

                for(Long val : arr) {
                    long cost = Math.max(0, val- a[i]);
                    boolean check =true;
                    if(i % 2 == 1) {
                        if(val <=maxi)
                            check =false;
                    } else {
                        if(val >=maxi)
                            check =false;
                    }
                    if(check)
                        dp[i] = Math.min(dp[i], dp[i-1] + cost);
                }
            }

            System.out.println(dp[n-1]);
        }

    }
}

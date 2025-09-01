public class lc1043 {

    public int maxSumAfterPartitioning(int[] arr, int k) {


        int n=arr.length;



        int[] dp=new int[n+1];

        for (int i = 1; i <= n; i++) {

            int maxi = Integer.MIN_VALUE;

            for (int j = i-1; j >= Math.max(0,i-k); j++) {

                dp[i] = Math.max(dp[i], arr[j]*(i-j));

            }

        }
        

        return dp[n];
        
    }
    
}

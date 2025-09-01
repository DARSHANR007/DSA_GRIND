public class LIS {


    int maxi = Integer.MIN_VALUE;


    //Input: [10, 9, 2, 5, 3, 7, 101, 18]
   
    public int helper(int n, int[] arr, int curr, int prev, int[][] memo) {

        if (curr == n)
            return 0;

        if (memo[prev + 1][curr] != -1)
            return memo[prev + 1][curr];

        int dont = helper(n, arr, curr + 1, prev, memo);

        int take = 0;

        if (prev == -1 || arr[curr] > arr[prev]) {
            take = 1 + helper(n, arr, curr + 1, prev, memo);
        }

        memo[prev + 1][curr] = Math.max(dont, take);

        return memo[prev + 1][curr];
    }
    

    public int dp_helper(int n, int arr[]) {


        int[][] dp = new int[n][n + 1];


        for (int i = 0; i < n; i++) {

            dp[i][0] = -1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n + 1; j++) {
                
                int dont=dp[]
                
            }
        }
        



        return 0;
    }

    

    
}

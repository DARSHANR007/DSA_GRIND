public class knapsack1 {


    public int dp(int n, int[] weight, int[] profit, int capacity) {


        int[][] dp = new int[n+1][capacity+1];


        for (int i = 1; i <=n; i++) {

            for (int j = 1; j <= capacity; j++) {
                
                int dont_pick = dp[i - 1][j];

                int pick = 0;

                if (weight[i-1] <= capacity) {    //i-1 because loop starts from 1 

                    pick = profit[i] + dp[i][j - weight[i]];

                }
                
                dp[i][j] = Math.max(dont_pick, pick);
            }
            
            
        }
        

        return dp[n][capacity];
    }
    
}

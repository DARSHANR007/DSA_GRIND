public class CoinCombo1 {
    
    int count = 0;

    public int coin_combinations1(int n, int[] arr, int required) {



        int[][] dp = new int[n + 1][required + 1];


        for (int i = 0; i < dp.length; i++) {

            dp[i][0] = 1;
        }
        
        for (int i = n - 1; i >= 0; i++) {

            for (int j = 1; j <= required; j++) {

                int pick = 0;

                if (j - arr[i] >= 0) {

                    pick = dp[i][required - arr[i]];

                }

                int dont = dp[i + 1][required];

                dp[i][j] = pick + dont;
            }

        }
        


        return dp[0][required];
    }
    

    public int helper(int n, int[] arr, int index, int sum, int required, int[][] memo) {

        if (index > n || sum > required)
            return 0;

        if (sum == required)
            return 1;

        if (memo[index][sum] != -1)
            return memo[index][sum];

        int pick = helper(n, arr, index, sum + arr[index], required, memo);
        int dont_pick = helper(n, arr, index + 1, sum, required, memo);

        memo[index][sum] = pick + dont_pick;

        return memo[index][sum];

    }
    
    public int coin_combinations_DP(int n, int[] coins, int required) {


        int[][] dp = new int[n+1][required+ 1];
        

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j < required; j++) {

                int dontpick = dp[i - 1][j];

                int pick = Integer.MIN_VALUE;
                

                if (coins[i-1] <=j) {

                    dp[i][j+= dp[i-1][j-coins[i-1]]; 
                    
                    
                }
            }

            
            


        }









        

        return 0;


     }


    public boolean dp2(int n, int[] arr, int target) {


        int total = 0;

        for (int x : arr) {
            total += x;
        }


        boolean[][] dp = new boolean[n + 1][total + 1];
        

        for (int i = 0; i <= n; i++) {

            dp[i][0] = true;
        }
        

        for (int i = 1; i <= n; i++) {
            
            for (int j = 1; j <= target; j++) {
                
                dp[i][j] = dp[i - 1][j];


                if (arr[i - 1] <= target) {

                    dp[i][j] = dp[i][j] || dp[i - 1][j - arr[i]];
                    

                }
            }
        }
        


        return dp[n][target];
     }
    


    

}

public class max_pages {

    int maxi=Integer.MIN_VALUE;
    
    
    public int maximum_pages(int n, int max_pages,int[] price, int[] pages) {


        int[] dp = new int[n+1 ];
        dp[0]=0;
        
        for (int i = 1; i < n; i++) {

            for (int j = n; j >= price[i]; j--) {
                
                dp[j]=Math.max(dp[j],dp[j-price[i]]+pages[i]);
            }


            

        }




        return 0;

    }


    public int helper(int n, int max_price, int[] price, int[] pages, int index, int page_sum, int cost, int[][] memo) {

        if (index >= pages.length)
            return 0;

        if (cost > max_price)
            return 0;

        if (memo[index][cost] != -1) {
            return memo[index][cost];
        }

        int pick = 0;

        if (cost + price[index] <= max_price) {
            pick = helper(n, max_price, price, pages, index, page_sum + pages[index], cost + price[index], memo);

        }

        int dont = helper(n, max_price, price, pages, index + 1, page_sum, cost, memo);

        memo[index][cost] = Math.max(pick, dont);

        return memo[index][cost];

    }
    
    public int knapsack(int[] weight, int cost[], int max_weight, int n) {


        int[][] dp = new int[n + 1][max_weight+ 1];


        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }


        for (int i = 1; i <=n; i++) {
            
            for (int j = 1; j <= max_weight; j++) {
                

                if (weight[i - 1] <= max_weight) {
                    
                    dp[i][j] = Math.max(dp[i - 1][j], cost[i - 1] + dp[i - 1][j - weight[i - 1]]);
                }
            }
        }
        




        return dp[n][max_weight];
    }
    


}

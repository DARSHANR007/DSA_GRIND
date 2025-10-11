public class KnapSack {

    public  int knapSack(int W, int[] wt, int[] val, int n) {


        int[][] dp = new int[n + 1][W + 1];


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {

                int curr_weight = wt[i - 1];
                int curr_value = val[i - 1];


                if (dp[i - 1][j] + curr_weight < j) {
                    dp[i][j] = Math.max(dp[i - 1][j], curr_value + dp[i - 1][j - curr_weight]);
                }

            }
        }

        return dp[n][W];

    }

    public int spaceOptimized_KnapSack(int W, int[] wt, int[] val, int n){

        int[] dp= new int[W];

        for(int i=0;i<n;i++){
            for(int j=W;j>=wt[i];j++){

                dp[j]=Math.max(dp[j],val[i]+dp[j-wt[i]]);
            }
        }









    }


}

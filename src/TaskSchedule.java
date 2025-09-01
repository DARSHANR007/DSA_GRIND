public class TaskSchedule {

    public int dp(int n, int[] easy, int[] hard) {


        int[][] dp = new int[3][n];




        dp[0][0] = easy[0];
        dp[0][1] = hard[1];
        dp[0][2] = 0;

        for (int i = 1; i < n; i++) {


            dp[i][0] = easy[i]+Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));


            dp[i][1] = hard[i] + dp[i - 1][2];


            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][0]);


        }
        
        return Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2]));
    }
    
}

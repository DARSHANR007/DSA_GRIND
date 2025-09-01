public class Frog1 {



    public int dp(int n, int[] jumps) {
        
       //10 30 40 20
        int dp[] = new int[n];



        dp[0] = jumps[0];
        dp[1] = Math.abs(jumps[1]-jumps[0]);


        for (int i = 2; i < n; i++) {

            int j1 = dp[i - 2] + Math.abs(jumps[i] - jumps[i - 2]);
            int j2 = dp[i - 1] + Math.abs(jumps[i] - jumps[i - 1]);

            dp[i] = Math.min(j1, j2);

        }
        
        return dp[n - 1];



        
    }
    
}

public class StoneGame {


    public boolean helper(int k, int n, int[] stones) {

        boolean [] dp = new boolean[k+1];

        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <= k; j++) {

                if (j - stones[i] >= 0 && dp[j - stones[i]] == false) {
                    dp[j] = true;
                    break;
                }
                
            }
        }
        
        return dp[k];
    }
    
}

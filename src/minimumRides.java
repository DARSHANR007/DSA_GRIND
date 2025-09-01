public class minimumRides {
   

    public int solution(int[] weight, int n, int capacity) {


        int[][] dp = new int[n + 1][capacity + 1];
        

        for (int i = 1; i <= n; i++) {
            
            for (int j = 1; j <= capacity; j++) {

                if( weight[i]<= j)
                
                dp[i][j] = weight[i] + dp[i - 1][j - weight[i]];
            }
        }
        








        return dp[n][capacity];
    }
    
}

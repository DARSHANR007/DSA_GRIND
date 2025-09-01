public class Two_Sets_2 {

    public int countTwoSets(int n) {
        int total = n * (n + 1) / 2;

        // If total sum is odd, return 0
        if (total % 2 != 0) return 0;

        int target = total / 2;

        return countWays(n, target) / 2;  
    }

    private int countWays(int num, int target) {
        if (target == 0)
            return 1; // Found a valid subset
        if (num == 0 || target < 0)
            return 0; // No more numbers or target too small

        int include = countWays(num - 1, target - num);
        int exclude = countWays(num - 1, target);

        return include + exclude;
    }

    
    private int memo(int num, int target, int[][] memo) {

        if (num == 0 || target < 0) {
            return 0;
        }

        if (target == 0)
            return 1;

        if (memo[num][target] != -1)
            return memo[num][target];

        int pick = memo(num - 1, target - num, memo);

        int dont = memo(num - 1, target, memo);

        memo[num][target] = pick + dont;

        return memo[num][target];

    }


    private int dp(int num, int target) {


        int[][] dp = new int[num + 1][target + 1];

        for (int i = 1; i <= num; i++) {
            

            for (int j = 1; j <= target; j++) {

                int dont = dp[i - 1][target];

                int pick = 0;

                if (j - i > 0) {

                    pick += dp[i - 1][j - i];
                }

                dp[i][j] = pick + dont;
            }
            
            
        }

        return dp[num][target];

    }
    

    
    
}

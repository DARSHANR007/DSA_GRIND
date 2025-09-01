import java.util.HashSet;

public class MoneySums {

    public int money(int n, int[] coins) {
        int totalSum = 0;
        for (int coin : coins) totalSum += coin;

        boolean[][] memo = new boolean[n + 1][totalSum + 1];
        HashSet<Integer> set = new HashSet<>();

        helper(n, coins, set, 0, 0, memo);
        set.remove(0); // optional: remove 0 if empty subset isn't needed
        return set.size();
    }

    public void helper(int n, int[] coins, HashSet<Integer> set, int index, int sum, boolean[][] memo) {
        if (index == n) {
            set.add(sum);
            return;
        }

        if (memo[index][sum])

            return; // already visited this state
        memo[index][sum] = true;

        // include
        helper(n, coins, set, index + 1, sum + coins[index], memo);

        // exclude
        helper(n, coins, set, index + 1, sum, memo);
    }
    

    public int dp_method(int n, int[] coins) {
        

        int totalSum = 0;

        for (int coin : coins) {
            totalSum += coin;
        }


        int[] dp = new int[totalSum + 1];

        dp[0]=0;


        for (int coin : coins) {
            
            for (int i = totalSum; i >= coin; i--) {
                
                if(dp[])
            }
        }
    }

    
    
}

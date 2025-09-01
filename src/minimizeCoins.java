import java.util.ArrayList;
import java.util.List;

public class minimizeCoins {


    int mini = Integer.MAX_VALUE;


    public  int minimize(int n, int[] denominations, int required) {


         
        helper(n, denominations, 0, 0, required,new ArrayList<>(););

        return mini == Integer.MAX_VALUE ? -1 : mini;

    }
    

    public void helper(int n, int[] denominations, int index, int sum_up, int required, List<Integer> coins) {

        if (sum_up == required) {
            mini = Math.min(mini, coins.size());
            return;
        }

        if (sum_up > required)
            return;

        if (index >= n)
            return;

        coins.add(denominations[index]);
        helper(n, denominations, index, sum_up + denominations[index], required, coins);
        coins.remove(coins.size() - 1);
        helper(n, denominations, index + 1, sum_up, required, coins);
        return;

    }
        public void helper_memo(int n, int[] denominations, int index, int sum_up, int required, List<Integer> coins, int[][] memo) {

        if (sum_up == required) {
            mini = Math.min(mini, coins.size());
            return;
        }

        if (sum_up > required)
            return;

        if (index >= n)
            return;

        coins.add(denominations[index]);
        helper(n, denominations, index, sum_up + denominations[index], required, coins);
        coins.remove(coins.size() - 1);
        helper(n, denominations, index + 1, sum_up, required, coins);
        return;

    }

    



    
}

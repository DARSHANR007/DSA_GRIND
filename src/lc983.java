import java.util.HashSet;
import java.util.Set;

public class lc983 {


    public int mincostTickets(int[] days, int[] costs) {

        Set<Integer> confirm=new HashSet<>();


        int total_days = 0;

        int n = days.length;

        for (int i : days) {

            confirm.add(i);
            total_days = Math.max(total_days, i);
        }


        int[] dp = new int[total_days+1];


        for (int i = 1; i <= n; i++) {

            if (!confirm.contains(i)) {
                dp[i] = dp[i - 1];
            }
            else {
                int cost1 = costs[0] + dp[Math.max(0, i - 1)];
                int cost2 = costs[1] + dp[Math.max(0, i - 7)];
                int cost3 = costs[2] + dp[Math.max(0, i - 30)];

                dp[i] = Math.min(cost1, Math.max(cost2, cost3));

            }


            


        }


        



        return dp[total_days];
        
    }
    
}

import java.util.HashSet;
import java.util.Set;

public class MinCostforTickets {


    public int mincostTickets(int[] days, int[] costs) {

        Set<Integer> set=new HashSet<>();

        int lastday=days[days.length-1];

        int[] dp=new int[lastday+1];

        for(int day:days){
            set.add(day);
        }

        for(int i=0;i<lastday;i++){

            if(!set.contains(i)){
                dp[i]=dp[i-1];

            }
            int day1=dp[i-1]+2;
            int day2=dp[Math.max(0,(i-7))]+7;
            int day3=dp[Math.max(0,(i-15))]+15;

            dp[i]=Math.min(day1,Math.min(day2,day3));
        }


        return dp[lastday];
    }


}

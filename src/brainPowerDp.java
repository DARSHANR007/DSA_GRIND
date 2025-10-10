public class brainPowerDp {

    public long mostPoints(int[][] questions) {

        int n=questions.length;

        long[] dp=new long[n];

        long maxi=Integer.MIN_VALUE;

        for(int i=0;i<=n;i++){

            int current_power=questions[i][1];
            int next_jump=current_power+i+1;


            dp[i]+=questions[i][0];

            if( next_jump < n){
                dp[next_jump]=Math.max(dp[next_jump],dp[i]);
            }

        }


        for(long num:dp){
            maxi=Math.max(num,maxi);
        }

        return maxi;

    }
}

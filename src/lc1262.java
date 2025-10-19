public class lc1262 {

    public int maxSumDivThree(int[] nums) {


        int n=nums.length;

        int[][] dp=new int[n+1][n+1];

        int maxi=0;


        for(int i=1;i<n;i++){
            for(int j=i;j<n;j++){

                dp[i][j]=dp[i][j-1]+nums[i];

                if(dp[i][j]%3==0){
                    maxi=Math.max(dp[i][j],maxi);
                }

            }
        }

        return maxi;


    }
}

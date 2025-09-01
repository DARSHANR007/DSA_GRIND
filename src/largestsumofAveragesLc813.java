public class largestsumofAveragesLc813 {



    //nums = [9,1,2,3,9], k = 3


    public double largestSumOfAverages(int[] nums, int k) {

        int n=nums.length;


        double dp[][] = new double[n + 1][k + 1];
        

        for (int i = 1; i <= n; i++) {
            
            for (int j = 1; j <= k; j++) {

                if (i < j) {
                    dp[i][j] = 0;
                    continue;
                }


                dp[i][j] = ((dp[i - 1][j - 1] * (j - 1)) + nums[i]) / j;

            }
        }





        return dp[n][k];
        
    }






    
}

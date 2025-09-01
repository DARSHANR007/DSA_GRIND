public class lc740 {

    public int deleteAndEarn(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n];

        dp[0] = nums[0];

        dp[1]=nums[0];
        if(Math.abs(nums[0]-nums[1])>1){
            dp[1]=nums[0]+nums[1];
        }


        for (int i = 2; i < n; i++) {
            
            dp[i] = nums[i] + dp[i - 2];
            

        }

        


        


        return dp[n];
        
    }
    
}

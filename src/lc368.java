import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc368 {
    
    public List<Integer> largestDivisibleSubset(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;

        List<Integer>[] dp = new ArrayList[n];
        
        

        for (int i = 0; i <= n; i++) {
            dp[i] = new ArrayList<>();
        }


        for (int i = 0; i < n; i++) {

            dp[i].add(nums[i]);

            for (int j = 0; j < i; j++) {
                

                if (nums[j] % nums[i] == 0 && dp[j].size()+1 > dp[i].size()) {

                    dp[i] = new ArrayList<>(dp[j]);
                    dp[i].add(nums[i]);
                    
                }
            }
            
            
        }







        return new ArrayList<>();
    }







}
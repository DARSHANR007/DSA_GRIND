import java.util.HashMap;

public class NumberofLongestSusbstrings {


    
    public int findNumberOfLIS(int[] nums) {


        int n=nums.length;

        HashMap<Integer,Integer> hash=new HashMap<>();


        int []dp=new int[m];
        dp[0]=1;

        int maxi=0;


        for(int i=0;i<m;i++){

            for(int j=i;j>=1;j--){

                if(nums[j] < nums[i]){
                    dp[i]=dp[j]+1;

            
                    continue;
                }
                else{
                    dp[i]=1;
                }

                    hash.put(dp[i], hash.getOrDefault(dp[i], 0)+1);
                    maxi=Math.max(maxi,dp[i]);
            }


        }

        return hash.get(maxi);


        
    }
}

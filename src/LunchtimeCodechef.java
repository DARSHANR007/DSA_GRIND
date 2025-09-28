public class LunchtimeCodechef {



    public int[] helper(int[] heights, int n){

        int[] dp=new int[n];


        for(int i=0;i<n;i++){
            for(int j=i;j>=0;j--){

                if (i==j) continue;

               if(heights[i] == heights[j]){
                 dp[i]=1+dp[j];
                 break;
               }
               if(heights[i] <  heights[j]){
                break;
               }

            }
        }


 


        return dp;
    }
    
}

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class lc1187Dp {

     public int makeArrayIncreasing(int[] arr1, int[] arr2) {



        int m=arr1.length;
        int n=arr2.length;

        int[] dp=new int[m+1];

        Arrays.sort(arr2);


        boolean [] seen=new int[n];

        int start=0;


        for(int i=1;i<=m;i++){
            dp[i]=dp[i-1];

            if(arr1[i] < arr[i-1]){

                for(int j=start;j<n;j++){
                    if( arr2[j]> arr1[i-1] && !seen[j] || arr2[j] < arr1[i] && !seen[j]){
                        seen[j]=true;
                        dp[i]=dp[i-1]+1;
                        start=j;
                    }
                }
            }
              
            

        }

        return dp[m];

        
        
    }
    
}

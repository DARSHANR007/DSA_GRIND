import java.util.Arrays;

public class RussianDollEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {


        int n=envelopes.length;

        int [] dp= new int[n+1];

        int []heights=new int[n];

        Arrays.fill(dp,1);

        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; // same width -> sort by height descending
            } else {
                return a[0] - b[0]; // otherwise sort by width ascending
            }
        });

        for(int i=0;i<n;i++){
            heights[i]=envelopes[i][1];
        }

        int len=0;

        for(int num:heights){

            int index = lowerBound(dp,n+1,num);

            dp[index]=num;

            if(index==len){
                len++;
            }

        }



        return len;

    }

    public static int lowerBound(int[] dp, int size, int target){

        int low = 0, high = size - 1;
        while (low <= high){

            int mid = low + (high - low) / 2;

            if(dp[mid] <= target){
                low=mid+1;
            }
            else{
                high=mid;
            }

        }

        return low;

    }

}

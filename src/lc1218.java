import java.util.HashMap;

public class lc1218 {


    public int longestSubsequence(int[] arr, int difference) {

        HashMap<Integer,Integer> hash=new HashMap<>();

        int maxi=0;

        for(int num:arr){

            int curr=hash.getOrDefault(num-difference,0)+1;

            maxi=Math.max(maxi,curr);


        }




        return maxi;


    }

}

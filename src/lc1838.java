import java.util.Arrays;

public class lc1838 {


    public int maxFrequency(int[] nums, int k) {


        int n=nums.length;

        Arrays.sort(nums);

        int duplicate=k;

        int maxi=0;


        int []dp=new int[n];


        for(int i=1;i<n;i++){


                k-=nums[i];
            }

        if(k>=0){
            maxi++;


        }





        return maxi;

    }



}

public class lc1671 {


    //[2,1,1,5,6,2,3,1]


    public int minimumMountainRemovals(int[] nums) {

        return 0;

    }
    
    public int checkMountain(int start, int end, int[] nums) {

        int maxi = Integer.MIN_VALUE;
        int index = -1;
        int n=nums.length;

        for (int i = start; i <= end; i++) {
            
            if (nums[i] > maxi) {
                maxi = nums[i];
                index = i;
            }

            
        }
        


        

        return 0;
    }
    
}

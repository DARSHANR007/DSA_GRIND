class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {

        Arrays.sort(nums);


        return count(nums,upper)-count(nums,lower-1);

        
        
    }


    public long count(int[] nums, int target){

        int low=0;

        int high=nums.length-1;

        long count=0;


        while(low < high){

            if(nums[low]+nums[high]<=target){

                count+=high-low;
                low++;
            }
            else{

                high--;

            }
        }

        return count;





    }
}
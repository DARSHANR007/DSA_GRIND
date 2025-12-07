class Solution {
    public int splitArray(int[] nums, int k) {

        int high=0;

        int low=0;

     int best=0;


        for(int num:nums){
            high+=num;
            low=Math.max(low,num);
        }

        while(low <=high){
            int mid=low+(high-low)/2;

            if(bs(nums,k,mid)){
                best=mid;
                high=mid-1;

            }
            else{
                low=mid+1;
            }
        }

        return best;

        

        
    }


    public boolean bs(int[] nums, int k , int cap){
        int count=1;

        int sum=0;

        for(int num:nums){

            if(sum+num >cap){
                count++;
                sum=num;
            }
            else{
                sum+=num;
            }

            
            if(count >k) return false;

        }

        return true;
    }
}
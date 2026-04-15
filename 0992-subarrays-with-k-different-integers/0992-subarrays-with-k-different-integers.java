class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {


        return helper(nums,k)-helper(nums,k-1);

        
    }


    public int helper(int[] nums, int k){


        HashMap<Integer,Integer> hash= new HashMap();


        int left=0;

        int n=nums.length;


        int count=0;

        for(int right=0;right<n;right++){


            hash.put(nums[right],hash.getOrDefault(nums[right],0)+1);


            while(hash.size()>k){

                hash.put( nums[left],hash.get(nums[left])-1);

                if(hash.get(nums[left])==0){
                    hash.remove(nums[left]);
                }

                left++;
            }


            count+=right-left+1;
        }

        return count;



    }
}
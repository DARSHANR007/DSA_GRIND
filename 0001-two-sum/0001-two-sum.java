class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> hash= new HashMap();

        int n=nums.length;


      for(int i=0;i<n;i++){

        if(hash.containsKey(target-nums[i])){
            return new int[]{i, hash.get(target-nums[i])};
        }

        hash.put(nums[i],i);

      }

      return new int[]{};


        
    }
}
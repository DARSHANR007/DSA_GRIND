class Solution {
    public int subarraySum(int[] nums, int k) {


        HashMap<Integer,Integer> hash= new HashMap<>();


        hash.put(0,1);
        int count=0;

        int sum=0;

        for(int i:nums){

            sum+=i;

            count+=hash.getOrDefault(sum-k,0);
            hash.put(sum, hash.getOrDefault(sum,0)+1);

        }

        return count;
        
    }
}
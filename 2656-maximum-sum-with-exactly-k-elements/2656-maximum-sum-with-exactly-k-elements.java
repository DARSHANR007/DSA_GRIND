class Solution {
    public int maximizeSum(int[] nums, int k) {

        int maxi=0;

        for(int i:nums){
            maxi=Math.max(i,maxi);
        }


        return (maxi*k)+(k*(k-1)/2);

        
        
    }
}
class Solution {
    public int minimumCost(int[] nums) {

        int n= nums.length;


       int firstCost = nums[0];
        int minSecond = nums[1];
        int answer = Integer.MAX_VALUE;

        for (int j = 2; j < n; j++) {
            answer = Math.min(answer, firstCost + minSecond + nums[j]);
            minSecond = Math.min(minSecond, nums[j]);
        }

        return answer;
}}
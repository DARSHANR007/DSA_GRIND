class Solution {

    public long zeroFilledSubarray(int[] nums) {
        int n = nums.length;

        int left = 0;

        long count = 0;

        int right = 0;

        for (left = 0; left < n; left++) {
            if (nums[left] == 0) {
                right = left;

                while (right + 1 < n && nums[right + 1] == 0) {
                    right++;
                }

                int length = right - left + 1;

                count += (long) length * (length + 1) / 2;
                left = right;
            }
        }

        return count;
    }
}

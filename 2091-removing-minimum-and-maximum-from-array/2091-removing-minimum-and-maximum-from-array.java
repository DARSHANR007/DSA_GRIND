class Solution {
    public int minimumDeletions(int[] nums) {

        int n = nums.length;

        if (n == 1) return 1;

        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;

        int a = -1;
        int b = -1;

        for (int i = 0; i < n; i++) {

            if (nums[i] > maxi) {
                a = i;
                maxi = nums[i];
            }

            if (nums[i] < mini) {
                b = i;
                mini = nums[i];
            }
        }

        int left = Math.max(a, b) + 1;
        int right = n - Math.min(a, b);
        int both = (Math.min(a, b) + 1) + (n - Math.max(a, b));

        return Math.min(left, Math.min(right, both));
    }
}
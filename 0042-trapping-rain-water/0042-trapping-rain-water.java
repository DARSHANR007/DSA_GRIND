class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];

        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);

            int j = n - 1 - i;
            rightMax[j] = Math.max(rightMax[j + 1], height[j]);
        }

        int cap = 0;
        for (int i = 0; i < n; i++) {
            cap += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return cap;
    }
}
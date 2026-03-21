class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n <= 2) return 0;

        // 1. Build the Prefix Sum array (as you did)
        int[] prefix = new int[n];
        int currentSum = 0;
        for (int i = 0; i < n; i++) {
            currentSum += height[i];
            prefix[i] = currentSum;
        }

        int totalWater = 0;
        int left = 0;

        // 2. Forward Pass: Find containers where right wall >= left wall
        for (int right = 1; right < n; right++) {
            if (height[right] >= height[left]) {
                if (right - left > 1) {
                    // Formula: (width * height of shorter wall) - sum of bars in between
                    int width = right - left - 1;
                    int fillHeight = height[left];
                    int barsInBetween = prefix[right - 1] - prefix[left];
                    totalWater += (width * fillHeight) - barsInBetween;
                }
                left = right;
            }
        }

        // 3. Backward Pass: Handle the remaining part (where left wall was tallest)
        int tallestSoFar = left; // This was the last "left" we reached
        int right = n - 1;
        for (int i = n - 2; i >= tallestSoFar; i--) {
            if (height[i] >= height[right]) {
                if (right - i > 1) {
                    int width = right - i - 1;
                    int fillHeight = height[right];
                    // Using prefix sum to get bars between i and right
                    int barsInBetween = prefix[right - 1] - prefix[i];
                    totalWater += (width * fillHeight) - barsInBetween;
                }
                right = i;
            }
        }

        return totalWater;
    }
}
class Solution {

    public int maxArea(int[] height) {
        int n = height.length;

        int left = 0;

        int right = n - 1;

        int maxi = -1;

        int smaller = -1;

        while (left < right) {

            int curr=-1;

            if (height[left] < height[right]) {
                curr = (right - left) * height[left];
                left++;
            } else if (height[right] < height[left]) {
                 curr = (right - left) * height[right];
                right--;
            } else {
                 curr = (right - left) * height[right];
                left++;
                right--;
            }

            maxi = Math.max(maxi, curr);
        }

        return maxi;
    }
}

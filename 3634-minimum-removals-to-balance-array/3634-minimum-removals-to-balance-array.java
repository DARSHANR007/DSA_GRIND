import java.util.Arrays;

class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        if (n <= 1) return 0;

        Arrays.sort(nums);

        int mini = n; 

        for (int left = 0; left < n; left++) {
            long tofind = (long) nums[left] * k;
            int check = upperbound(nums, tofind);

            int lastValidIdx;
            if (check == -1) {
                lastValidIdx = n;
            } else {
                lastValidIdx = check;
            }

            int kept = lastValidIdx - left;
            int removing = n - kept;

            mini = Math.min(mini, removing);
        }

        return mini;
    }

    public int upperbound(int[] nums, long k) {
        int answer = -1;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > k) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer; 
    }
}
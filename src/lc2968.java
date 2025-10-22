import java.util.Arrays;

public class lc2968 {

    public int maxFrequencyScore(int[] nums, long k) {
        Arrays.sort(nums);
        int n = nums.length;

        long sum = 0;
        int left = 0;
        int result = 1;

        for (int right = 0; right < n; right++) {
            sum += nums[right];

            // If cost > k, shrink the window
            while ((long)nums[right] * (right - left + 1) - sum > k) {
                sum -= nums[left];
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}

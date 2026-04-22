class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0, high = 0;

        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        int best = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (check(nums, mid, k)) {
                best = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return best;
    }

    public boolean check(int[] nums, int cap, int k) {
        int count = 1;
        int sum = 0;

        for (int num : nums) {
            sum += num;

            if (sum > cap) {
                count++;
                sum = num;
            }
        }

        return count <= k;
    }
}
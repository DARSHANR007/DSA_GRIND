class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = lowerbound(nums, target);
        
        if (start == -1 || start >= nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }
        
        int firstGreater = upper(nums, target);
        
        return new int[]{start, firstGreater - 1};
    }

    public int lowerbound(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int best = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                best = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return best;
    }

    public int upper(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int best = nums.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                best = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return best;
    }
}
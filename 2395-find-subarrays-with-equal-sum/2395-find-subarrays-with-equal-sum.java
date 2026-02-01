import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean findSubarrays(int[] nums) {

        Set<Integer> set = new HashSet<>();

        int n = nums.length;

        for (int i = 1; i < n; i++) {

            int curr = nums[i] + nums[i - 1];

            if (set.contains(curr)) {
                return true;
            }

            set.add(curr);
        }

        return false;
    }
}

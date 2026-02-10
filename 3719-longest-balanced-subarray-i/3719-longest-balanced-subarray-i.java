class Solution {
    public int longestBalanced(int[] nums) {

        int n = nums.length;
        int maxLen = 0;

        // i is the starting point of the subarray
        for (int i = 0; i < n; i++) {
            Set<Integer> distinctEvens = new HashSet<>();
            Set<Integer> distinctOdds = new HashSet<>();

            // j is the ending point of the subarray
            for (int j = i; j < n; j++) {
                int current = nums[j];

                // Categorize the number
                if (current % 2 == 0) {
                    distinctEvens.add(current);
                } else {
                    distinctOdds.add(current);
                }

                if (distinctEvens.size() == distinctOdds.size()) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
        
    }
}
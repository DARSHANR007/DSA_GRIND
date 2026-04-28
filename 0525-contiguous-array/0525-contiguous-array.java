class Solution {

    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap();

        hash.put(0, -1);

        int sum = 0;

        int maxi = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                sum++;
            } else {
                sum--;
            }

            if (hash.containsKey(sum)) {
                maxi = Math.max(maxi, i - hash.get(sum));
            }
            else {
            hash.put(sum, i);

            }

         }

        return maxi;
    }
}

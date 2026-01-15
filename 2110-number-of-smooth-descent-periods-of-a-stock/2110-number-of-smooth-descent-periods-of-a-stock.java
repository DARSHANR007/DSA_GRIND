class Solution {
    public long getDescentPeriods(int[] prices) {
        long count = 1;   
        long streak = 1;

        for (int i = 1; i < prices.length; i++) {

            if (prices[i - 1] - prices[i] == 1) {
                streak++;
            } else {
                streak = 1;
            }

            count += streak;
        }

        return count;
    }
}

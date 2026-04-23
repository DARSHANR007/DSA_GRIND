class Solution {

    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE;

        int buy2 = Integer.MIN_VALUE;

        int sell1 = 0;

        int sell2 = 0;

        for (int cost : prices) {
            buy1 = Math.max(buy1, -cost);
            sell1 = Math.max(sell1, cost + buy1);
            buy2 = Math.max(buy2, sell1 - cost);
            sell2 = Math.max(sell2, cost + buy2);
        }

        return sell2;
    }
}

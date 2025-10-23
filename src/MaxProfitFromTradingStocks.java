public class MaxProfitFromTradingStocks {

    public int maxProfit(int[] present, int[] futures, int budget) {
        int n = present.length;
        int[] dp = new int[budget + 1]; // 1D array for DP

        for (int i = 0; i < n; i++) {
            int cost = present[i];
            int profit = futures[i] - present[i];

            // Iterate budget from high to low
            for (int b = budget; b >= cost; b--) {
                dp[b] = Math.max(dp[b], profit + dp[b - cost]);
            }
        }

        return dp[budget];
    }

    public static void main(String[] args) {
        MaxProfitFromTradingStocks m = new MaxProfitFromTradingStocks();
        int[] present = {3, 4, 5};
        int[] futures = {7, 8, 9};
        int budget = 10;

        System.out.println(m.maxProfit(present, futures, budget)); // Output: 9
    }
}

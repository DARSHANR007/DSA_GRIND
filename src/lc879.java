static final int MOD = 1_000_000_007;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int m = group.length;
        int[][][] dp = new int[m + 1][n + 1][minProfit + 1];

        dp[0][0][0] = 1;

        for (int i = 1; i <= m; i++) {
            int membersNeeded = group[i - 1];
            int profitMade = profit[i - 1];

            for (int members = 0; members <= n; members++) {
                for (int prof = 0; prof <= minProfit; prof++) {

                    // Case 1: Skip current crime
                    dp[i][members][prof] = dp[i - 1][members][prof];

                    // Case 2: Take current crime (if enough members)
                    if (members >= membersNeeded) {
                        int prevProfit = Math.max(0, prof - profitMade);
                        dp[i][members][prof] = (dp[i][members][prof] +
                                dp[i - 1][members - membersNeeded][prevProfit]) % MOD;
                    }
                }
            }
        }

        int result = 0;
        for (int members = 0; members <= n; members++) {
            result = (result + dp[m][members][minProfit]) % MOD;
        }

        return result;
    }
class Solution {

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[1], b[1]));

        int n = events.length;
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            int prev = findbest(events, i - 1);

            for (int j = 1; j <= k; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[prev + 1][j - 1] + events[i - 1][2]);
            }
        }

        return dp[n][k];
    }

    public int findbest(int[][] events, int idx) {
        int low = 0;
        int high = idx - 1;
        int res = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (events[mid][1] < events[idx][0]) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return res;
    }
}

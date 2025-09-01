import java.util.Arrays;

public class frog2 {
    


    public int frog2(int n, int k, int[] h) {
    int[] dp = new int[n];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;

    for (int i = 1; i < n; i++) {
        for (int j = Math.max(0, i - k); j < i; j++) {
            dp[i] = Math.min(dp[i], dp[j] + Math.abs(h[i] - h[j]));
        }
    }
    return dp[n - 1];
}

}

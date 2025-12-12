class Solution {
  public int minCut(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        // Step 1: Precompute palindrome table
        for (int i = 0; i < n; i++) {
            dp[i][i] = true; // length 1
        }
        for (int i = 0; i < n - 1; i++) { // length 2
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
            }
        }
        for (int len = 3; len <= n; len++) { // length >= 3
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }

        // Step 2: Min cuts array
        int[] cuts = new int[n];
        for (int i = 0; i < n; i++) {
            if (dp[0][i]) {
                cuts[i] = 0; 
            } else {
                cuts[i] = i; 
                for (int j = 0; j < i; j++) {
                    if (dp[j + 1][i]) {
                        cuts[i] = Math.min(cuts[i], cuts[j] + 1);
                    }
                }
            }
        }

        return cuts[n - 1];
    }

}
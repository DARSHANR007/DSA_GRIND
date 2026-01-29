class Solution {
    public int maxPalindromes(String s, int k) {

        int n = s.length();

        boolean[][] pal = new boolean[n][n];

        for(int i=0;i<n;i++)
            pal[i][i] = true;

        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1))
                pal[i][i+1] = true;
        }

        for(int len=3; len<=n; len++){
            for(int i=0; i<=n-len; i++){
                int j = i+len-1;
                if(s.charAt(i)==s.charAt(j) && pal[i+1][j-1])
                    pal[i][j] = true;
            }
        }

        int[] dp = new int[n+1];

        for(int i=1;i<=n;i++){
            dp[i] = dp[i-1];

            if(i-k >= 0 && pal[i-k][i-1])
                dp[i] = Math.max(dp[i], dp[i-k] + 1);

            if(i-k-1 >= 0 && pal[i-k-1][i-1])
                dp[i] = Math.max(dp[i], dp[i-k-1] + 1);
        }

        return dp[n];
    }
}

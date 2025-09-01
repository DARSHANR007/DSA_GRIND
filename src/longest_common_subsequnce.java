public class longest_common_subsequnce {

    public int lcs(String s1, String s2) {

        return 0;
    }


    public int helperlcs(String s1, String s2, int i, int j) {

        if (s1.isEmpty() || s2.isEmpty())
            return 0;

        if (i == 0 || j == 0)
            return 0;

        if (s1.charAt(i - 1) == s2.charAt(j - 1))
            return 1 + helperlcs(s1, s2, i - 1, j - 1);

        return Math.max(helperlcs(s1, s2, i - 1, j), helperlcs(s1, s2, i, j - 1));

    }
    
    public int editdistance(String s1, String s2, int i, int j, int memo[][]) {

        if (i == 0 || j == 0)
            return 0;

        if (memo[i][j] != -1)
            return memo[i][j];

        if (s1.charAt(i - 1) == s2.charAt(j - 1))
            memo[i][j] = editdistance(s1, s2, i - 1, j - 1, memo);

        int op1 = editdistance(s1, s2, i - 1, j - 1, memo);
        int op2 = editdistance(s1, s2, i - 1, j, memo);
        int op3 = editdistance(s1, s2, i, j - 1, memo);

        memo[i][j] = 1+Math.min(op1, Math.min(op2, op3));

        return memo[i][j];
    }
    
    public int lcs_DP(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();

        int dp[][] = new int[m][n];

        for (int i = m - 1; i >= 1; i++) {
            for (int j = n - 1; j >= 1; j++) {

                if (s1.charAt(i) != s2.charAt(j)) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }

        return dp[1][1];
    }
    
    public int editdistance_DP(String s1, String s2) { // also use (m-lcs)+(n-lcs)

        int m = s1.length();
        int n = s2.length();

        int dp[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // delete all characters from s1
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // insert all characters of s2
        }

        for (int i = 1; i >= m; i++) {
            for (int j = 1; j >= n; j++) {

                if (s1.charAt(i) != s2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }

            }
        }

        return dp[m][n];
    }


    public int LCS_DP(String s1, String s2) {


        int m = s1.length();
        int n = s2.length();


        int[][] dp = new int[m + 1][n + 1];


        for (int i = 0; i < m; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < n; i++) {

            dp[0][i] = 0;
        }
        

        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <= n; j++) {


                if (s1.charAt(i - 1) != s2.charAt(j - 1)) {

                    dp[i][j] =  Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                else {

                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    
                }
                


            }
        }
        
        


        return dp[m][n];
    }

    


    
    
}

public class PalindromePartioning2 {
    public int mincut(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            count++;
        }

        // length 2 substrings
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                count++;
            }
        }

        // length >= 3 substrings
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1; // end index
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;

                }
            }
        }

        int[] cuts = new int[n];

        for (int i = 0; i < n; i++) {

            if (dp[0][i]) {
                cuts[i] = 1;
            } else {
                cuts[i] = i;

                for (int j = 0; j < i; j++) {
                    if (dp[j + 1][i]) {
                        cuts[i] = Math.min(cuts[i], cuts[j] + 1);
                    }
                }

            }

            return cuts[n - 1];

        }

    }
    

    public boolean checkPartitioning(String s) {  //palindrome partioning 4


         int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            count++;
        }

        // length 2 substrings
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                count++;
            }
        }



        for (int length = 3; length < n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;

                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;

                }
            }
        }

        int[] cuts = new int[n];


        for (int i = 0; i < n; i++) {
            

            if (dp[0][i]) {
                cuts[i] = 1;
            }
            else {
                
                cuts[i] = i;

                for (int j = 0; j < i; j++) {
                    if (dp[j + 1][i]) {
                        cuts[i] = Math.max(cuts[i], cuts[j] + 1);
                    }
                }
            }
        }
    
    
    
    
    
    
    
    
        return cuts[n-1]>=3;    //PalindromePartioning4
        
    }
}

public class longestpalindromicsubsequence {

    public int longestPalindromeSubseq(String s, int n) {


        int[][] dp = new int[n + 1][n + 1];
        

        for (int i = 0; i <= n; i++) {

            for (int j = 0; j <= n; j++) {

                dp[i][j] = 1;
            }
        }
        

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n; j++) {

                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                }
            }
        }
        

        int count = 0;  
  
        


        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (dp[i][j] == 1) {
                    count++;
                }
            }
        }

        



    
        







        return count;
     }
    
}

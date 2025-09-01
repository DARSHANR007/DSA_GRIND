public class LCS_improved {



    private int dp_helper(String s1, String s2) {


        int m = s1.length();
        int n = s2.length();


        int[][] dp = new int[m + 1][n + 1];
        
        String longer;
        String smaller;

        if (s1.length() >= s2.length()) {
            longer = s1;
            smaller = s2;
        }
        else {
            longer = s2;
            smaller = s1;
        }
        



        for (int i = 1; i < longer.length(); i++) {
            

            for (int j = i; j < smaller.length(); j++) {
                


                if (s1.charAt(i) == s1.charAt(j)) {

                    dp[i][j] = 1 + Math.max(i - 1, j - 1);
                    continue;
                    
                }
            }
        }
        









        return 0;
    }
    
}

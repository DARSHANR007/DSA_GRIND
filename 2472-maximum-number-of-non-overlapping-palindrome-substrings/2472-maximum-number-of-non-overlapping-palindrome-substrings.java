class Solution {
    public int maxPalindromes(String s, int k) {

        int n = s.length();
        int[] dp = new int[n+1];

        for(int center = 0; center < n; center++){

            expand(s, center, center, k, dp);     // odd
            expand(s, center, center+1, k, dp);   // even
        }

        return dp[n];
    }

    private void expand(String s, int l, int r, int k, int[] dp){

        int n = s.length();

        while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)){

            int len = r - l + 1;

            if(len >= k){
                dp[r+1] = Math.max(dp[r+1], dp[l] + 1);
            }

            dp[r+1] = Math.max(dp[r+1], dp[r]); 
            
            l--;
            r++;
        }
    }
}

class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;

        long dp = 1; // includes empty subsequence
        long[] last = new long[26]; // last contribution of each char

        for (char ch : s.toCharArray()) {
            int c = ch - 'a';

            long newDp = (2 * dp % MOD - last[c] + MOD) % MOD;

            last[c] = dp;
            dp = newDp;
        }

        // subtract empty subsequence
        return (int)((dp - 1 + MOD) % MOD);
    }
}

class Solution {

    char[] arr;
    int[][][][] memo;

    public int countSpecialNumbers(int n) {
        arr = String.valueOf(n).toCharArray();

        // pos, bounded, started, mask
        memo = new int[arr.length][2][2][1 << 10];
        for (int[][][] a : memo)
            for (int[][] b : a)
                for (int[] c : b)
                    Arrays.fill(c, -1);

        return solve(0, true, false, 0);
    }

    public int solve(int pos, boolean bounded, boolean started, int mask) {

        if (pos == arr.length) {
            return started ? 1 : 0;
        }

        int bi = bounded ? 1 : 0;
        int si = started ? 1 : 0;

        if (memo[pos][bi][si][mask] != -1) {
            return memo[pos][bi][si][mask];
        }

        int limit;
        if (bounded) {
            limit = arr[pos] - '0';
        } else {
            limit = 9;
        }

        int result = 0;

        for (int i = 0; i <= limit; i++) {

            if (!started && i == 0) {
                // leading zero, dont mark in mask
                result += solve(pos + 1, bounded && i == limit, false, 0);
            } else {
                // real digit, check if already used
                if ((mask & (1 << i)) != 0) continue;
                result += solve(pos + 1, bounded && i == limit, true, mask | (1 << i));
            }
        }

        memo[pos][bi][si][mask] = result;
        return result;
    }
}
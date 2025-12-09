class Solution {
    public int findMinMoves(int[] machines) {
        int n = machines.length;
        long sum = 0;
        for (int x : machines) sum += x;
        if (sum % n != 0) return -1;
        
        int avg = (int)(sum / n);
        int ans = 0;
        long prefix = 0;
        
        for (int x : machines) {
            int diff = x - avg;
            prefix += diff;
            ans = Math.max(ans, Math.max((int)Math.abs(prefix), diff));
        }
        return ans;
    }
}

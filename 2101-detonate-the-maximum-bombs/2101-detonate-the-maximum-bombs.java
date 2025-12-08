import java.util.*;

class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<List<Integer>> g = new ArrayList<>(n);
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            long xi = bombs[i][0], yi = bombs[i][1], ri = bombs[i][2];
            long r2 = ri * ri;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                long dx = xi - bombs[j][0];
                long dy = yi - bombs[j][1];
                long dist2 = dx * dx + dy * dy;
                if (dist2 <= r2) g.get(i).add(j);
            }
        }

        int ans = 1;
        boolean[] vis = new boolean[n];
        for (int s = 0; s < n; s++) {
            Arrays.fill(vis, false);
            ans = Math.max(ans, dfsCount(s, g, vis));
        }
        return ans;
    }

    private int dfsCount(int u, List<List<Integer>> g, boolean[] vis) {
        Deque<Integer> st = new ArrayDeque<>();
        st.push(u);
        int count = 0;
        while (!st.isEmpty()) {
            int cur = st.pop();
            if (vis[cur]) continue;
            vis[cur] = true;
            count++;
            for (int v : g.get(cur)) {
                if (!vis[v]) st.push(v);
            }
        }
        return count;
    }
}

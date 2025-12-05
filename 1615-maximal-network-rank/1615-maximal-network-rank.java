import java.util.*;

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        List<Set<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) adj.add(new HashSet<>());

        for (int[] r : roads) {
            int a = r[0], b = r[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        int best = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int rank = adj.get(i).size() + adj.get(j).size();
                if (adj.get(i).contains(j)) {
                    rank -= 1;
                }
                if (rank > best) best = rank;
            }
        }
        return best;
    }
}

import java.util.*;

class Solution {
    public int minCost(int[][] grid, int k) {

        int rows = grid.length;
        int cols = grid[0].length;
        int INF = Integer.MAX_VALUE / 4;

        int[][][] dist = new int[rows][cols][k + 1];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                Arrays.fill(dist[i][j], INF);

        // pq: {row, col, cost, teleportsUsed}
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));

        dist[0][0][0] = 0;
        pq.add(new int[]{0, 0, 0, 0});

        // Flatten grid
        int total = rows * cols;
        int[][] cells = new int[total][3]; // {value, row, col}
        int idx = 0;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                cells[idx++] = new int[]{grid[i][j], i, j};

        Arrays.sort(cells, Comparator.comparingInt(a -> a[0]));

        // pointer per teleport count
        int[] ptr = new int[k + 1];

        int[][] dirs = {{0,1},{1,0}};

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int r = cur[0], c = cur[1], cost = cur[2], t = cur[3];

            if (cost > dist[r][c][t]) continue;

            // Normal moves
            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                    int newCost = cost + grid[nr][nc];
                    if (newCost < dist[nr][nc][t]) {
                        dist[nr][nc][t] = newCost;
                        pq.add(new int[]{nr, nc, newCost, t});
                    }
                }
            }

            // Optimized teleport
            if (t < k) {
                while (ptr[t] < total && cells[ptr[t]][0] <= grid[r][c]) {
                    int i = cells[ptr[t]][1];
                    int j = cells[ptr[t]][2];
                    if (cost < dist[i][j][t + 1]) {
                        dist[i][j][t + 1] = cost;
                        pq.add(new int[]{i, j, cost, t + 1});
                    }
                    ptr[t]++;
                }
            }
        }

        int ans = INF;
        for (int t = 0; t <= k; t++)
            ans = Math.min(ans, dist[rows - 1][cols - 1][t]);

        return ans;
    }
}

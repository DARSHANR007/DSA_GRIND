class Solution {

    public int minimumObstacles(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));

        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);

        dist[0][0] = 0;
        pq.add(new int[]{0, 0, 0});

        int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();
            int r = curr[0], c = curr[1], cost = curr[2];

            // Skip outdated states
            if (cost > dist[r][c]) continue;

            if (r == m - 1 && c == n - 1)
                return cost;

            for (int[] dir : directions) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {

                    int newCost = cost + grid[nr][nc];

                    if (newCost < dist[nr][nc]) {
                        dist[nr][nc] = newCost;
                        pq.add(new int[]{nr, nc, newCost});
                    }
                }
            }
        }

        return -1;
    }
}

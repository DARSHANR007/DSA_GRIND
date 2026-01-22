class Solution {
    public int shortestPath(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        // {row, col, remainingK, steps}

        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(visited[i], -1);
        }

        visited[0][0] = k;
        queue.add(new int[]{0, 0, k, 0});

        int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int remainingK = curr[2];
            int steps = curr[3];

            if (r == m - 1 && c == n - 1) return steps;

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                // boundary check
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;

                int newK = remainingK - grid[nr][nc];
                if (newK < 0) continue;

                // pruning
                if (visited[nr][nc] >= newK) continue;

                visited[nr][nc] = newK;
                queue.add(new int[]{nr, nc, newK, steps + 1});
            }
        }

        return -1;
    }
}

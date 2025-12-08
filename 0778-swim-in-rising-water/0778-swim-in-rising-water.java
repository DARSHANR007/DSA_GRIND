class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int low = Math.max(grid[0][0], grid[n-1][n-1]);
        int high = n * n - 1;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (low < high) {
            int mid = (low + high) / 2;

            if (canReach(grid, mid, dirs)) {
                high = mid; // can reach → try lower time
            } else {
                low = mid + 1; // cannot reach → raise water level
            }
        }
        return low;
    }

    private boolean canReach(int[][] grid, int t, int[][] dirs) {
        int n = grid.length;
        if (grid[0][0] > t) return false;

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            if (x == n - 1 && y == n - 1) return true;

            for (int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n &&
                    !visited[nx][ny] && grid[nx][ny] <= t) {

                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        return false;
    }
}
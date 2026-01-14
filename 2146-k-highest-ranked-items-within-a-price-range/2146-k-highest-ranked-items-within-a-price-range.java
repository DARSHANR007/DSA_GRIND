class Solution {
    public List<List<Integer>> highestRankedKItems(
            int[][] grid, int[] pricing, int[] start, int k) {

        int m = grid.length, n = grid[0].length;
        int low = pricing[0], high = pricing[1];

        Queue<int[]> queue = new LinkedList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[2] != b[2]) return a[2] - b[2];
                int pa = grid[a[0]][a[1]];
                int pb = grid[b[0]][b[1]];
                if (pa != pb) return pa - pb;
                if (a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            }
        );

        queue.add(new int[]{start[0], start[1], 0});
        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;

        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1], d = cur[2];

            if (grid[r][c] >= low && grid[r][c] <= high) {
                pq.add(new int[]{r, c, d});
            }

            for (int[] dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n &&
                    !visited[nr][nc] && grid[nr][nc] != 0) {

                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc, d + 1});
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        while (k-- > 0 && !pq.isEmpty()) {
            int[] x = pq.poll();
            result.add(Arrays.asList(x[0], x[1]));
        }

        return result;
    }
}

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // Directions for Up, Down, Left, Right
    int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid2.length;
        int n = grid2[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If we find land in grid2, start a BFS to process the entire island
                if (grid2[i][j] == 1) {
                    if (bfs(grid1, grid2, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public boolean bfs(int[][] grid1, int[][] grid2, int i, int j) {
        int m = grid2.length;
        int n = grid2[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { i, j });
        
        // Mark as visited immediately by sinking it (changing 1 to 0)
        grid2[i][j] = 0; 
        
        boolean isSubIsland = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];

            // CRITICAL LOGIC: If the land in grid2 exists where grid1 is water,
            // this island is NOT a sub-island.
            if (grid1[x][y] == 0) {
                isSubIsland = false;
            }

            for (int[] dir : directions) {
                int nr = x + dir[0];
                int nc = y + dir[1];

                // Check bounds and if the neighbor is land in grid2
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid2[nr][nc] == 1) {
                    // Sink the land immediately before adding to queue to prevent 
                    // duplicate entries and memory overflow
                    grid2[nr][nc] = 0;
                    queue.add(new int[] { nr, nc });
                }
            }
        }
        
        // Returns true only if EVERY cell visited in grid2 had land in grid1
        return isSubIsland;
    }
}
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class WallsandGates {


    public int[][] findNearest(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Result matrix: store distances
        int[][] res = new int[rows][cols];
        for (int[] x : res) {
            Arrays.fill(x, Integer.MAX_VALUE); // Initially all INF
        }

        Queue<int[]> queue = new LinkedList<>();

        // Add all gates (0) as BFS sources
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    res[i][j] = 0; // Distance to itself
                }
            }
        }

        // 4 directions: up, down, left, right
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // Multi-source BFS
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1];

            for (int[] dir : dirs) {
                int nr = x + dir[0];
                int nc = y + dir[1];

                // Check bounds first
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                    // Skip walls
                    if (grid[nr][nc] == -1) continue;

                    // Only visit empty rooms not visited yet
                    if (res[nr][nc] == Integer.MAX_VALUE) {
                        res[nr][nc] = res[x][y] + 1;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        return res;
    }

}

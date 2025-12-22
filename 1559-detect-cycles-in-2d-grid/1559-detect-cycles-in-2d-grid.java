import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public boolean containsCycle(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (helper(grid[i][j], i, j, visited, grid)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean helper(char letter, int x, int y, boolean[][] visited, char[][] grid) {

        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, -1, -1});
        visited[x][y] = true;

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();
            int currx = curr[0];
            int curry = curr[1];
            int pr = curr[2];
            int pc = curr[3];

            for (int[] d : directions) {
                int nr = currx + d[0];
                int nc = curry + d[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                if (grid[nr][nc] != letter) continue;

                if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc, currx, curry});
                } else if (nr != pr || nc != pc) {
                    return true;
                }
            }
        }
        return false;
    }
}

import java.util.LinkedList;
import java.util.Queue;

public class shortestpathtogetfood {

    public int getshortestPath(String[] grid) {

        int m = grid.length;
        int n = grid[0].length();

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        // Find your starting location (*) and enqueue it
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '*') {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        // Directions for moving up, down, left, right
        int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
        int steps = 0;

        // BFS traversal
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];

                // Explore all 4 directions
                for (int[] d : directions) {
                    int nx = x + d[0];
                    int ny = y + d[1];

                    // Check bounds
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;

                    // Skip walls or visited
                    if (grid[nx].charAt(ny) == 'X' || visited[nx][ny]) continue;

                    // Found food
                    if (grid[nx].charAt(ny) == '#') return steps;

                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        // Food not reachable
        return -1;
    }

    // method 2

        public int getFood(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[m][n];

            // Step 1: Add all food cells (#) to the queue
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '#') {
                        queue.offer(new int[]{i, j, 0}); // {row, col, distance}
                        visited[i][j] = true;
                    }
                }
            }

            int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

            // Step 2: BFS from all food cells simultaneously
            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                int r = curr[0], c = curr[1], dist = curr[2];

                // Step 3: If we reach the player’s position (*), return distance
                if (grid[r][c] == '*') {
                    return dist;
                }

                // Step 4: Explore neighbors
                for (int[] d : dirs) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                    if (grid[nr][nc] == 'X' || visited[nr][nc]) continue;

                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc, dist + 1});
                }
            }

            // Step 5: If * is never reached
            return -1;
        }
    }



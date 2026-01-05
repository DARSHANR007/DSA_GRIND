class Solution {
   public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;

        // Step 1: Add all rotten oranges (2) to the queue
        // These are the multiple sources
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        // If no fresh oranges, no time is needed
        if (freshOranges == 0) return 0;

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int minutes = 0;

        // Step 2: BFS from all rotten oranges simultaneously
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottedThisMinute = false;

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];

                for (int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];

                    // Only spread to fresh oranges
                    if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;  // Make it rotten
                        queue.offer(new int[]{nx, ny});
                        freshOranges--;
                        rottedThisMinute = true;
                    }
                }
            }

            // Increase minutes only if we rotted at least one orange
            if (rottedThisMinute) minutes++;
        }

        return freshOranges == 0 ? minutes : -1;
    }
}
public class lc200NumberofIslands {

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    helper(grid, i, j);
                }
            }
        }
        return count;
    }

    private void helper(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        // Boundary + visited + water check
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') {
            return;
        }

        // Mark current cell as visited
        grid[i][j] = '0';

        // Explore all 4 directions
        helper(grid, i + 1, j); // down
        helper(grid, i - 1, j); // up
        helper(grid, i, j + 1); // right
        helper(grid, i, j - 1); // left
    }

    // Example usage
    public static void main(String[] args) {
        lc200NumberofIslands obj = new lc200NumberofIslands();
        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        System.out.println(obj.numIslands(grid)); // Output: 3
    }
}


class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        // Sort diagonals in NON-INCREASING (descending) order
        for (int startRow = 0; startRow < n; startRow++) {
            PriorityQueue<Integer> pq =
                new PriorityQueue<>(Collections.reverseOrder());

            int r = startRow, c = 0;

            // collect diagonal
            while (r < n && c < n) {
                pq.add(grid[r][c]);
                r++;
                c++;
            }

            // put back sorted values
            r = startRow;
            c = 0;
            while (r < n && c < n) {
                grid[r][c] = pq.poll();
                r++;
                c++;
            }
        }

        // Sort diagonals in NON-DECREASING (ascending) order
        for (int startCol = 1; startCol < n; startCol++) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            int r = 0, c = startCol;

            // collect diagonal
            while (r < n && c < n) {
                pq.add(grid[r][c]);
                r++;
                c++;
            }

            // put back sorted values
            r = 0;
            c = startCol;
            while (r < n && c < n) {
                grid[r][c] = pq.poll();
                r++;
                c++;
            }
        }

        return grid;
    }
}

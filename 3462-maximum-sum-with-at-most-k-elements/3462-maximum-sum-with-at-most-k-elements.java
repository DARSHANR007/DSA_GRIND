class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {

        PriorityQueue<Integer> global = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < grid.length; i++) {

            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            // push all elements of current row
            for (int val : grid[i]) {
                pq.add(val);
            }

            // take only up to limits[i] best elements
            int take = limits[i];

            for (int j = 0; j < take && !pq.isEmpty(); j++) {
                global.add(pq.remove());
            }
        }

        long sum = 0;

        // now take top k elements globally
        while (k > 0 && !global.isEmpty()) {
            sum += global.remove();
            k--;
        }

        return sum;
    }
}
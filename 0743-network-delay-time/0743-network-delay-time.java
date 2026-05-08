class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        // Build adjacency list (1-indexed, so size n+1)
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] time : times) {
            int start = time[0];
            int end   = time[1];
            int cost  = time[2];
            adj.get(start).add(new int[]{end, cost});
        }

        // dist array — 1-indexed
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // Min-heap on distance (index 1 of the pair)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] curr   = pq.poll();
            int dest     = curr[0];
            int weight   = curr[1];

            // Stale entry check — we already found a shorter path to dest
            if (weight > dist[dest]) continue;

            for (int[] neighbour : adj.get(dest)) {
                int nDest = neighbour[0];
                int nCost = neighbour[1];

                if (weight + nCost < dist[nDest]) {
                    dist[nDest] = weight + nCost;
                    pq.offer(new int[]{nDest, dist[nDest]});
                }
            }
        }

        // Find the maximum distance across all nodes (answer = last node to receive signal)
        int maxi = -1;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;  // unreachable node
            maxi = Math.max(maxi, dist[i]);
        }

        return maxi;
    }
}
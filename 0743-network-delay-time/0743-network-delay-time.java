import java.util.*;

public class Solution {

    class Network {
        int destination;
        int cost;

        Network(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }
    }

    List<List<Network>> graph = new ArrayList<>();

    public int networkDelayTime(int[][] times, int n, int k) {
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] time : times) {
            int source = time[0];
            int destination = time[1];
            int cost = time[2];
            graph.get(source).add(new Network(destination, cost));
        }

        int[] distances = dijkstra(graph, n, k);

        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (distances[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, distances[i]);
        }

        return maxTime;
    }

    private int[] dijkstra(List<List<Network>> graph, int n, int start) {
        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        PriorityQueue<Network> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        pq.add(new Network(start, 0));

        while (!pq.isEmpty()) {
            Network curr = pq.poll();
            int node = curr.destination;
            int cost = curr.cost;

            if (cost > distances[node]) continue;

            for (Network neighbour : graph.get(node)) {
                int newCost = cost + neighbour.cost;
                if (newCost < distances[neighbour.destination]) {
                    distances[neighbour.destination] = newCost;
                    pq.add(new Network(neighbour.destination, newCost));
                }
            }
        }

        return distances;
    }
}

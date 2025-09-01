import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS_graph {





    public void adjcaceny_list(int[][] arr, int n) {

         List<List<Integer>> list = new ArrayList<>();
        

        for (int i = 0; i < n; i++) {

            list.add(new ArrayList<>());
        }
        
        for (int[] x : arr) {

            int source = x[0];
            int destination = x[1];

            list.get(source).add(destination);
            list.get(destination).add(source);
        }
        
        

    }







    public void bfs(int n, int[][] arr) {

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            list.add(new ArrayList<>());
        }

        for (int[] x : arr) {

            int source = x[0];
            int destination = x[1];

            list.get(source).add(destination);
            list.get(destination).add(source);
        }

        Queue<Integer> queue = new LinkedList<>();

        boolean[] visited = new boolean[n];

        queue.add(0);

        visited[0] = true;

        while (!queue.isEmpty()) {

            int node = queue.poll();

            for (int x : list.get(node)) {

                if (!visited[x]) {
                    visited[x] = true;
                    queue.add(x);
                }
            }

        }

    }
    

    public void dfs_graph(boolean[] visited, int node, List<List<Integer>> adjList) {


        visited[node] = true;


        for (int x : adjList.get(node)) {

            if (!visited[x]) {
                dfs_graph(visited, x, adjList);
            }
        }


    }
    
}
